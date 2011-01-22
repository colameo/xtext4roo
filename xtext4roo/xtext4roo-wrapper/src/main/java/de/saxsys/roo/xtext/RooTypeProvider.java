package de.saxsys.roo.xtext;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.access.IMirror;
import org.eclipse.xtext.common.types.access.TypeNotFoundException;
import org.eclipse.xtext.common.types.access.TypeResource;
import org.eclipse.xtext.common.types.access.impl.AbstractTypeProvider;
import org.springframework.roo.classpath.PhysicalTypeMetadataProvider;
import org.springframework.roo.classpath.scanner.MemberDetailsScanner;
import org.springframework.roo.model.JavaType;

public class RooTypeProvider extends AbstractTypeProvider {

	private RooURIHelper uriHelper;
	private RooTypeFactory typeFactory;

	protected RooTypeProvider(
			PhysicalTypeMetadataProvider physicalTypeMetadataProvider,
			MemberDetailsScanner detailsScanner, ResourceSet resourceSet) {
		super(resourceSet);
		this.uriHelper= new RooURIHelper();
		this.typeFactory=new RooTypeFactory(physicalTypeMetadataProvider, detailsScanner, uriHelper);
	}

	@Override
	public JvmType findTypeByName(String name) {
			
		JavaType javaType = createJavaType(name);
		URI resourceURI = uriHelper.createResourceURI(javaType);
		TypeResource resource = (TypeResource) getResourceSet().getResource(resourceURI, true);
		
		String fragment = uriHelper.getFragment(javaType);
		JvmType result = (JvmType) resource.getEObject(fragment);
		if (result == null) {
			throw new IllegalStateException("Resource has not been loaded");
		} 
		return result;
	}

	private JavaType createJavaType(String name) {
		return new JavaType(name);
	}

	
	@Override
	protected IMirror createMirrorForFQN(String name)
			throws TypeNotFoundException {
		return RooClassMirror.createClassMirror(createJavaType(name), typeFactory);
	}

	

}
