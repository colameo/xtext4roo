package de.saxsys.roo.xtext;

import static de.saxsys.roo.xtext.XtextMetadataIdentifier.createIdentifier;
import static de.saxsys.roo.xtext.XtextMetadataIdentifier.getExtension;
import static de.saxsys.roo.xtext.XtextMetadataIdentifier.getPath;
import static de.saxsys.roo.xtext.XtextMetadataIdentifier.getQualifiedName;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.ReferenceCardinality;
import org.apache.felix.scr.annotations.ReferencePolicy;
import org.apache.felix.scr.annotations.ReferenceStrategy;
import org.apache.felix.scr.annotations.Service;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.common.TerminalsStandaloneSetup;
import org.eclipse.xtext.common.types.access.ITypeProvider.Factory;
import org.eclipse.xtext.common.types.xtext.AbstractTypeScopeProvider;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.service.AbstractGenericModule;
import org.springframework.roo.classpath.PhysicalTypeMetadataProvider;
import org.springframework.roo.classpath.scanner.MemberDetailsScanner;
import org.springframework.roo.file.monitor.event.FileDetails;
import org.springframework.roo.file.monitor.event.FileEvent;
import org.springframework.roo.file.monitor.event.FileEventListener;
import org.springframework.roo.file.monitor.event.FileOperation;
import org.springframework.roo.metadata.MetadataDependencyRegistry;
import org.springframework.roo.metadata.MetadataItem;
import org.springframework.roo.metadata.MetadataService;
import org.springframework.roo.process.manager.FileManager;
import org.springframework.roo.project.Path;
import org.springframework.roo.project.PathResolver;
import org.springframework.roo.project.ProjectMetadata;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.util.Modules;

@Component(immediate = true)
@Service
@Reference(name = "xtextLanguage", strategy = ReferenceStrategy.EVENT, policy = ReferencePolicy.DYNAMIC, referenceInterface = XtextLanguage.class, cardinality = ReferenceCardinality.OPTIONAL_MULTIPLE)
public class XtextMetadataProviderImpl implements XtextMetadataProvider,
		FileEventListener {

	private static Logger logger = Logger
			.getLogger(XtextMetadataProviderImpl.class.getName());

	@Reference
	private PhysicalTypeMetadataProvider physicalTypeMetadataProvider;

	@Reference
	private MemberDetailsScanner memberDetailsScanner;
	private PathResolver pathResolver = null;

	@Reference
	private MetadataService metadataService;

	@Reference
	private MetadataDependencyRegistry metadataDependencyRegistry;

	@Reference
	private FileManager fileManager;

	// Cache for MetadataIDs. Maps from "extension#qualifiedName" to full MID
	private Map<String, String> cache = new HashMap<String, String>();

	// Map from extension to runtime modules of the DSLs
	private Map<String, Module> languages = new ConcurrentHashMap<String, Module>();

	public XtextMetadataProviderImpl() {
		TerminalsStandaloneSetup.doSetup();
	}

	@SuppressWarnings("unused")
	private Module rooTypeProviderBindings = new AbstractGenericModule() {

		public Class<? extends AbstractTypeScopeProvider> bindAbstractTypeScopeProvider() {
			return RooTypeScopeProvider.class;
		}

		public Class<? extends Factory> bindITypeProvider$Factory() {
			return RooTypeProviderFactory.class;
		}

		public PhysicalTypeMetadataProvider bindPhysicalTypeMetadataProvider() {
			return physicalTypeMetadataProvider;
		}

		public MemberDetailsScanner bindMemberDetailsScanner() {
			return memberDetailsScanner;
		}

		// TODO: We probably must inject the runtime module of the DSL here, as
		// a starting point for classpath resource loading
		// public Class<? extends XtextResourceSet> bindXtextResourceSet() {
		// return MyXtextResourceSet.class;
		// }
	};

	/**
	 * Xtext languages can announce themselves by implementing the interface
	 * XtextLanguage and registering this implementation as OSGi service.
	 * <p>
	 * Each time and XtextLanguage is discovered, the OSGi container will call
	 * the following method. This will create the Google Guice Injector for the
	 * language's runtime module (see {@link XtextLanguage#getRuntimeModule()})
	 * and perform the necessary registrations so that the ResourceFactory and
	 * in turn parser of the language will be used for files that have the
	 * extension as stated by {@link XtextLanguage#getExtension()}
	 * 
	 * 
	 * @param language
	 *            the Xtext language
	 */
	protected void bindXtextLanguage(XtextLanguage language) {

		logger.warning("Binding Xtext Language: " + language
				+ " which has extension " + language.getExtension());
		Module module = language.getRuntimeModule();
		module = Modules.override(module).with(rooTypeProviderBindings);
		languages.put(language.getExtension(), module);

	}

	private void registerXtextLanguageIfNecessary(String extension) {
		Module module = languages.get(extension);
		if (module == null)
			return;
		if (!IResourceServiceProvider.Registry.INSTANCE
				.getExtensionToFactoryMap().containsKey(extension)) {
			Injector injector = Guice.createInjector(module);

			IResourceFactory resourceFactory = injector
					.getInstance(IResourceFactory.class);
			IResourceServiceProvider serviceProvider = injector
					.getInstance(IResourceServiceProvider.class);
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
					extension, resourceFactory);
			IResourceServiceProvider.Registry.INSTANCE
					.getExtensionToFactoryMap().put(extension, serviceProvider);
		}

	}

	protected void unbindXtextLanguage(XtextLanguage language) {

		String extension = language.getExtension();
		IResourceServiceProvider.Registry.INSTANCE.getExtensionToFactoryMap()
				.remove(extension);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().remove(
				extension);

	}

	public void onFileEvent(FileEvent fileEvent) {
		String fileIdentifier = fileEvent.getFileDetails().getCanonicalPath();
		if (isXextFile(fileIdentifier)
				&& fileEvent.getOperation() != FileOperation.MONITORING_FINISH) {
			// file is of interest
			// start by evicting the cache
			cache.clear();
			logger.warning("Xtext File event: " + fileEvent);

			PathResolver pathResolver = getPathResolver();
			Path sourcePath = null;
			List<Path> paths = getAllowedPaths();
			for (Path path : paths) {
				if (new FileDetails(new File(pathResolver.getRoot(path)), null)
						.isParentOf(fileIdentifier)) {
					sourcePath = path;
					break;
				}
			}
			String relativePath = pathResolver
					.getRelativeSegment(fileIdentifier);
			logger.warning("Xtext File source path: " + sourcePath
					+ ", relative path: " + relativePath);
			relativePath = relativePath.substring(1);
			String extension = relativePath.substring(relativePath
					.lastIndexOf(".") + 1);
			relativePath = relativePath.substring(0,
					relativePath.lastIndexOf("."));

			String qualifiedName = relativePath
					.replace(File.separatorChar, '.');

			String id = XtextMetadataIdentifier.createIdentifier(sourcePath, qualifiedName, extension);
			logger.warning("Xtext Metadata ID:" + id);

			// Now we've worked out the id, we can publish the event in case
			// others were interested
			metadataService.evict(id);
			metadataDependencyRegistry.notifyDownstream(id);

		}
	}

	private boolean isXextFile(String fileIdentifier) {
		Set<String> xTextExtensions = languages.keySet();

		int lastIndexOfDot = fileIdentifier.lastIndexOf('.');
		if (lastIndexOfDot != -1) {
			return xTextExtensions.contains(fileIdentifier
					.substring(lastIndexOfDot + 1));
		}
		return false;
	}

	public String getProvidesType() {
		return XtextMetadataIdentifier.PROVIDES_TYPE;
	}

	public MetadataItem get(String metadataIdentificationString) {
		String fileIdentifier = obtainPathToIdentifier(metadataIdentificationString);
		logger.warning("Xtext Metadata File Identifier:" + fileIdentifier);
		metadataDependencyRegistry
				.deregisterDependencies(metadataIdentificationString);
		if (!fileManager.exists(fileIdentifier)) {
			// Couldn't find the file, so return null to distinguish from a file
			// that was found but could not be parsed
			return null;
		}
		String extension = XtextMetadataIdentifier.getExtension(metadataIdentificationString);
		registerXtextLanguageIfNecessary(extension);

		ResourceSet resourceSet = new ResourceSetImpl();
		URI uri = URI.createFileURI(fileIdentifier);
		Resource resource = resourceSet.getResource(uri, true);

		return new XtextMetadata(metadataIdentificationString, resource);
	}

	private PathResolver getPathResolver() {
		if (pathResolver != null) {
			return pathResolver;
		}
		ProjectMetadata projectMetadata = (ProjectMetadata) metadataService
				.get(ProjectMetadata.getProjectIdentifier());
		PathResolver pathResolver = projectMetadata.getPathResolver();
		this.pathResolver = pathResolver;
		return pathResolver;
	}

	public String findIdentifier(String qualifiedName, String extension) {

		String result = cache.get(extension + "#" + qualifiedName);

		if (result != null) {
			return result;
		}

		PathResolver pathResolver = getPathResolver();
		List<Path> paths = getAllowedPaths();
		for (Path sourcePath : paths) {
			String relativePath = qualifiedName
					.replace('.', File.separatorChar) + "." + extension;
			String fileIdentifier = pathResolver.getIdentifier(sourcePath,
					relativePath);
			if (fileManager.exists(fileIdentifier)) {
				// found the file, so use this one
				String mid = createIdentifier(sourcePath, qualifiedName,
						extension);
				cache.put(extension + "#" + qualifiedName, mid);
				return mid;
			}
		}
		return null;

	}

	private List<Path> getAllowedPaths() {
		// we allow DSL files to be place in source paths or in root
		List<Path> paths = pathResolver.getSourcePaths();
		paths.add(Path.ROOT);
		return paths;
	}

	private String obtainPathToIdentifier(String metadataIdentifier) {

		Path path = getPath(metadataIdentifier);
		String qn = getQualifiedName(metadataIdentifier);
		PathResolver pathResolver = getPathResolver();
		String extension = getExtension(metadataIdentifier);

		String relativePath = qn.replace('.', File.separatorChar) + "."
				+ extension;
		String fileIdentifier = pathResolver.getIdentifier(path, relativePath);
		return fileIdentifier;
	}
}
