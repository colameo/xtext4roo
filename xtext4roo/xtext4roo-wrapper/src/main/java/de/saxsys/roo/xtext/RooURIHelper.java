package de.saxsys.roo.xtext;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.common.types.access.impl.URIHelperConstants;
import org.springframework.roo.classpath.details.ClassOrInterfaceTypeDetails;
import org.springframework.roo.model.DataType;
import org.springframework.roo.model.JavaType;

public class RooURIHelper implements URIHelperConstants {

	public URI createResourceURI(JavaType javaType) {
		StringBuilder uriBuilder = createURIBuilder();
		createResourceURI(null, javaType, uriBuilder);
		return createURI(uriBuilder);
	}

	protected void createResourceURI(
			ClassOrInterfaceTypeDetails declaringClass, JavaType javaType,
			StringBuilder uriBuilder) {
		if (javaType.getDataType().equals(DataType.VARIABLE)) {
			// A type variable is in the same resource as the generic type where
			// it is declared in
			createResourceURI(null, declaringClass.getName(), uriBuilder);
		} else if (javaType.getEnclosingType() != null) {
			// nested types are in the same resource as the type they are
			// declared in
			createResourceURI(null, javaType.getEnclosingType(), uriBuilder);
		} else if (javaType.isPrimitive()) {
			uriBuilder.append(URIHelperConstants.PRIMITIVES);
		} else {
			// all Top-Level types have their own resource identified by their
			// FQN
			uriBuilder.append(URIHelperConstants.OBJECTS).append(
					javaType.getFullyQualifiedTypeName());
		}
	}

	public String getFragment(JavaType type) {
		StringBuilder uriBuilder = new StringBuilder(32);
		createFragment(null, type, uriBuilder);
		return uriBuilder.toString();
	}

	protected void createFragment(ClassOrInterfaceTypeDetails declaringClass,
			JavaType type, StringBuilder uriBuilder) {
		if (type.getDataType().equals(DataType.VARIABLE)) {
			// a type variable has the same Fragment as the class where it is
			// declared in plus "/" plus the name of the type variable
			createFragment(null, declaringClass.getName(), uriBuilder);
			uriBuilder.append('/');
			uriBuilder.append(type.getArgName());

		} else {
			uriBuilder.append(type.getFullyQualifiedTypeName());
			if (type.isArray()) {
				for (int i = 0; i < type.getArray(); i++) {
					uriBuilder.append("[]");
				}
			}
		}

	}

	/**
	 * 
	 * @param declaringClass
	 *            if type might represent a type variable, its declaring class must
	 *            be passed here. Otherwise it might be null.
	 * @param type
	 *            the type to refer to
	 * @return the full URI to refer to the type
	 */
	public URI getFullURI(ClassOrInterfaceTypeDetails declaringClass,
			JavaType type) {
		StringBuilder uriBuilder = createURIBuilder();
		createResourceURI(declaringClass, type, uriBuilder);
		uriBuilder.append('#');
		createFragment(declaringClass, type, uriBuilder);
		return createURI(uriBuilder);
	}

	protected StringBuilder createURIBuilder() {
		StringBuilder builder = new StringBuilder(48);
		builder.append(URIHelperConstants.PROTOCOL);
		builder.append(':');
		return builder;
	}

	protected URI createURI(StringBuilder uriBuilder) {
		return URI.createURI(uriBuilder.toString());
	}

	public void computeTypeName(JavaType javaType,
			StringBuilder uriBuilder) {
		
		//TODO: Ist this enough in any case?
		uriBuilder.append(javaType.getNameIncludingTypeParameters());
		
	}
}
