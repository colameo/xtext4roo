package de.saxsys.roo.xtext;

import org.eclipse.xtext.common.types.access.TypeResource;
import org.eclipse.xtext.common.types.access.impl.AbstractClassMirror;
import org.eclipse.xtext.common.types.access.impl.ITypeFactory;
import org.springframework.roo.model.JavaType;

public class RooClassMirror extends AbstractClassMirror {

	private final JavaType javaType;
	
	private final ITypeFactory<JavaType> typeFactory;

	public static RooClassMirror createClassMirror(JavaType javaType, ITypeFactory<JavaType> typeProvider) {
		return new RooClassMirror(javaType, typeProvider);
	}
	
	protected RooClassMirror(JavaType javaType, ITypeFactory<JavaType> typeFactory) {
		this.javaType = javaType;
		this.typeFactory = typeFactory;
	}

	public JavaType getMirroredClass() {
		return javaType;
	}
	
	@Override
	protected String getTypeName() {
		return javaType.getFullyQualifiedTypeName();
	}

	public void initialize(TypeResource typeResource) {
		typeResource.getContents().add(typeFactory.createType(javaType));
	}

}