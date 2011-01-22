package de.saxsys.roo.xtext;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.common.types.access.AbstractTypeProviderFactory;
import org.springframework.roo.classpath.PhysicalTypeMetadataProvider;
import org.springframework.roo.classpath.scanner.MemberDetailsScanner;

import com.google.inject.Inject;

public class RooTypeProviderFactory extends AbstractTypeProviderFactory {

	private PhysicalTypeMetadataProvider physicalTypeMetadataProvider;
	private MemberDetailsScanner detailsScanner;
	
	@Inject
	public RooTypeProviderFactory(
			PhysicalTypeMetadataProvider physicalTypeMetadataProvider,
			MemberDetailsScanner detailsScanner) {
		super();
		this.physicalTypeMetadataProvider = physicalTypeMetadataProvider;
		this.detailsScanner = detailsScanner;
	}

	public MemberDetailsScanner getDetailsScanner() {
		return detailsScanner;
	}
	
	public PhysicalTypeMetadataProvider getPhysicalTypeMetadataProvider() {
		return physicalTypeMetadataProvider;
	}
	
	public RooTypeProvider createTypeProvider(ResourceSet resourceSet) {
		if (resourceSet == null)
			throw new IllegalArgumentException("resourceSet may not be null.");
		RooTypeProvider result = createRooTypeProvider(resourceSet);
		return result;
	}
	
	protected RooTypeProvider createRooTypeProvider(ResourceSet resourceSet) {
		return new RooTypeProvider(physicalTypeMetadataProvider, detailsScanner, resourceSet);
	}

	
	@Override
	public RooTypeProvider createTypeProvider() {
		return (RooTypeProvider) super.createTypeProvider();
	}
	
	@Override
	public RooTypeProvider findTypeProvider(ResourceSet resourceSet) {
		return (RooTypeProvider) super.findTypeProvider(resourceSet);
	}
}
