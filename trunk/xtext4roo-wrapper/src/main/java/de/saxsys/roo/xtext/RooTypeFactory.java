package de.saxsys.roo.xtext;

import static org.springframework.roo.classpath.PhysicalTypeCategory.ANNOTATION;
import static org.springframework.roo.classpath.PhysicalTypeCategory.ENUMERATION;
import static org.springframework.roo.classpath.PhysicalTypeCategory.INTERFACE;
import static org.springframework.roo.classpath.PhysicalTypeCategory.OTHER;
import static org.springframework.roo.model.JavaType.WILDCARD_EXTENDS;
import static org.springframework.roo.model.JavaType.WILDCARD_NEITHER;
import static org.springframework.roo.model.JavaType.WILDCARD_SUPER;

import java.lang.reflect.Modifier;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmAnnotationTarget;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmArrayType;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmEnumerationType;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmLowerBound;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmReferenceTypeArgument;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeArgument;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.common.types.JvmWildcardTypeArgument;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.access.TypeNotFoundException;
import org.eclipse.xtext.common.types.access.impl.ITypeFactory;
import org.springframework.roo.classpath.PhysicalTypeCategory;
import org.springframework.roo.classpath.PhysicalTypeDetails;
import org.springframework.roo.classpath.PhysicalTypeMetadata;
import org.springframework.roo.classpath.PhysicalTypeMetadataProvider;
import org.springframework.roo.classpath.details.ClassOrInterfaceTypeDetails;
import org.springframework.roo.classpath.details.ConstructorMetadata;
import org.springframework.roo.classpath.details.FieldMetadata;
import org.springframework.roo.classpath.details.IdentifiableAnnotatedJavaStructure;
import org.springframework.roo.classpath.details.MemberHoldingTypeDetails;
import org.springframework.roo.classpath.details.MethodMetadata;
import org.springframework.roo.classpath.details.annotations.AnnotatedJavaType;
import org.springframework.roo.classpath.details.annotations.AnnotationMetadata;
import org.springframework.roo.classpath.scanner.MemberDetails;
import org.springframework.roo.classpath.scanner.MemberDetailsScanner;
import org.springframework.roo.model.JavaSymbolName;
import org.springframework.roo.model.JavaType;

public class RooTypeFactory implements ITypeFactory<JavaType> {

	private MemberDetailsScanner detailsScanner;
	private RooURIHelper uriHelper;
	private PhysicalTypeMetadataProvider physicalTypeMetadataProvider;

	public RooTypeFactory(
			PhysicalTypeMetadataProvider physicalTypeMetadataProvider,
			MemberDetailsScanner detailsScanner, RooURIHelper uriHelper) {
		super();
		this.detailsScanner = detailsScanner;
		this.physicalTypeMetadataProvider = physicalTypeMetadataProvider;
		this.uriHelper = uriHelper;
	}

	public JvmType createType(JavaType javaType) {

		ClassOrInterfaceTypeDetails cid;
		try {
			cid = findClassOrInterfaceTypeDetails(javaType);
		} catch (TypeNotFoundException e) {
			//TODO: Shall we fallback to classpath reflection here?
			JvmGenericType result = TypesFactory.eINSTANCE.createJvmGenericType();
			result.setFullyQualifiedName(javaType.getFullyQualifiedTypeName());
			return result;
		}

		PhysicalTypeCategory typeCategory = cid.getPhysicalTypeCategory();
		MemberDetails memberDetails = detailsScanner.getMemberDetails(
				RooTypeFactory.class.getName(), cid);
		List<MemberHoldingTypeDetails> details = memberDetails.getDetails();

		if (OTHER.equals(typeCategory)
				|| PhysicalTypeCategory.ITD.equals(typeCategory)) {
			throw new IllegalArgumentException("Cannot create JvmType for "
					+ cid.getName().getFullyQualifiedTypeName());
		}

		if (ANNOTATION.equals(typeCategory))
			return createAnnotationType(cid, details);
		if (ENUMERATION.equals(typeCategory))
			return createEnumerationType(cid, details);

		JvmGenericType result = TypesFactory.eINSTANCE.createJvmGenericType();

		result.setInterface(INTERFACE.equals(typeCategory));
		setTypeModifiers(result, cid.getModifier());
		setVisibility(result, cid.getModifier());
		result.setFullyQualifiedName(javaType.getFullyQualifiedTypeName());
		// createNestedTypes(clazz, result);
		createMethods(cid, details, result);
		createConstructors(cid, details, result);
		createFields(cid, details, result);
		setSuperTypes(cid, result);

		// for (TypeVariable<?> variable : clazz.getTypeParameters()) {
		// result.getTypeParameters().add(createTypeParameter(variable,
		// result));
		// }
		createAnnotationValues(cid, details, result);
		return result;
	}

	private void createConstructors(ClassOrInterfaceTypeDetails cid,
			List<MemberHoldingTypeDetails> details, JvmDeclaredType result) {
		for (MemberHoldingTypeDetails memberHoldingTypeDetails : details) {
			for (ConstructorMetadata constr : memberHoldingTypeDetails
					.getDeclaredConstructors()) {
				result.getMembers().add(createConstructor(cid, constr));
			}
		}

	}

	private JvmMember createConstructor(ClassOrInterfaceTypeDetails cid,
			ConstructorMetadata constr) {
		org.eclipse.xtext.common.types.JvmConstructor result = TypesFactory.eINSTANCE
				.createJvmConstructor();
		enhanceExecutable(cid, result, constr.getModifier(), cid.getName()
				.getSimpleTypeName(), constr.getParameterTypes());
		//TODO: enhanceGenericDeclaration(result, constructor);
		for (JavaType throwsType : constr.getThrowsTypes()) {
			result.getExceptions().add(createTypeReference(cid, throwsType));
		}
		createAnnotationValues(cid, constr, result);
		return result;
	}

	private void createMethods(ClassOrInterfaceTypeDetails cid,
			List<MemberHoldingTypeDetails> details, JvmDeclaredType result) {
		for (MemberHoldingTypeDetails memberHoldingTypeDetails : details) {
			for (MethodMetadata method : memberHoldingTypeDetails
					.getDeclaredMethods()) {
				result.getMembers().add(createOperation(cid, method));
			}
		}

	}

	private JvmMember createOperation(ClassOrInterfaceTypeDetails cid,
			MethodMetadata method) {
		JvmOperation result = TypesFactory.eINSTANCE.createJvmOperation();
		enhanceExecutable(cid, result, method.getModifier(),
				method.getMethodName().getSymbolName(), method.getParameterTypes());
		enhanceGenericDeclaration(result, method);
		result.setFinal(Modifier.isFinal(method.getModifier()));
		result.setStatic(Modifier.isStatic(method.getModifier()));
		result.setReturnType(createTypeReference(cid, method.getReturnType()));
		for (JavaType exceptionType : method.getThrowsTypes()) {
			result.getExceptions().add(createTypeReference(cid, exceptionType));
		}
		createAnnotationValues(cid, method, result);
		return result;
	}

	public void enhanceGenericDeclaration(JvmExecutable result,
			MethodMetadata method) {
		// TODO: No information is provided by roo about type parameters of a
		// method
		// Can it be derived in other ways?
		// for (TypeVariable<?> variable : method.getTypeParameters()) {
		// result.getTypeParameters().add(createTypeParameter(variable,
		// result));
		// }
	}

	private void enhanceExecutable(ClassOrInterfaceTypeDetails cid,
			JvmExecutable result, int modifier, String simpleName,
			List<AnnotatedJavaType> parameterTypes) {
		StringBuilder fqName = new StringBuilder(48);
		fqName.append(cid.getName().getFullyQualifiedTypeName());
		fqName.append('.');
		fqName.append(simpleName);
		fqName.append('(');
		for (int i = 0; i < parameterTypes.size(); i++) {
			if (i != 0)
				fqName.append(',');
			uriHelper.computeTypeName(parameterTypes.get(i).getJavaType(),
					fqName);
		}
		fqName.append(')');
		result.setFullyQualifiedName(fqName.toString());
		setVisibility(result, modifier);
		int i = 0;
		for (AnnotatedJavaType parameterType : parameterTypes) {
			result.getParameters().add(
					createFormalParameter(cid, parameterType, "p" + i, result));
			i++;
		}

	}

	private JvmFormalParameter createFormalParameter(
			ClassOrInterfaceTypeDetails cid, AnnotatedJavaType parameterType,
			String paramName, JvmMember container) {
		JvmFormalParameter result = TypesFactory.eINSTANCE
				.createJvmFormalParameter();
		result.setName(paramName);
		result.setParameterType(createTypeReference(cid,
				parameterType.getJavaType()));
		for (AnnotationMetadata annotation : parameterType.getAnnotations()) {
			result.getAnnotations().add(
					createAnnotationReference(cid, annotation));
		}
		return result;
	}

	private void createAnnotationValues(ClassOrInterfaceTypeDetails cid,
			IdentifiableAnnotatedJavaStructure annotatedJavaStructure,
			JvmAnnotationTarget result) {
		for (AnnotationMetadata annotation : annotatedJavaStructure
				.getAnnotations()) {
			result.getAnnotations().add(
					createAnnotationReference(cid, annotation));
		}

	}

	private void createAnnotationValues(ClassOrInterfaceTypeDetails cid,
			List<MemberHoldingTypeDetails> details, JvmDeclaredType result) {
		for (MemberHoldingTypeDetails memberHoldingTypeDetails : details) {
			createAnnotationValues(cid, memberHoldingTypeDetails, result);
		}

	}

	private JvmAnnotationReference createAnnotationReference(
			ClassOrInterfaceTypeDetails cid, AnnotationMetadata annotation) {
		JvmAnnotationReference annotationReference = TypesFactory.eINSTANCE
				.createJvmAnnotationReference();

		JavaType type = annotation.getAnnotationType();
		annotationReference.setAnnotation(createAnnotationProxy(type));

		annotation.getAttributeNames();
		// TODO
		// for(Method method: type.getDeclaredMethods()) {
		// try {
		// Object value = method.invoke(annotation, EMPTY_ARRAY);
		// if (method.getReturnType().isArray()) {
		// JvmAnnotationValue annotationValue =
		// createArrayAnnotationValue(value, method.getReturnType());
		// annotationReference.getValues().add(annotationValue);
		// annotationValue.setOperation(createMethodProxy(method));
		// } else {
		// JvmAnnotationValue annotationValue = createAnnotationValue(value,
		// method.getReturnType());
		// annotationReference.getValues().add(annotationValue);
		// annotationValue.setOperation(createMethodProxy(method));
		// }
		// } catch(Exception e) {
		// log.error(e.getMessage(), e);
		// }
		// }
		return annotationReference;
	}

	protected JvmAnnotationType createAnnotationProxy(JavaType type) {
		InternalEObject proxy = (InternalEObject) TypesFactory.eINSTANCE
				.createJvmAnnotationType();
		URI uri = uriHelper.getFullURI(null, type);
		proxy.eSetProxyURI(uri);
		return (JvmAnnotationType) proxy;
	}

	private void createFields(ClassOrInterfaceTypeDetails cid,
			List<MemberHoldingTypeDetails> details, JvmDeclaredType result) {
		for (MemberHoldingTypeDetails memberHoldingTypeDetails : details) {
			for (FieldMetadata field : memberHoldingTypeDetails
					.getDeclaredFields()) {
				result.getMembers().add(createField(cid, field));
			}
			// TODO: Consider Enum Constants.
		}
	}

	private JvmMember createField(ClassOrInterfaceTypeDetails declaringClass,
			FieldMetadata field) {
		org.eclipse.xtext.common.types.JvmField result;
		result = TypesFactory.eINSTANCE.createJvmField();

		result.setFullyQualifiedName(declaringClass.getName()
				.getFullyQualifiedTypeName()
				+ "."
				+ field.getFieldName().getSymbolName());
		result.setFinal(Modifier.isFinal(field.getModifier()));
		result.setStatic(Modifier.isStatic(field.getModifier()));
		setVisibility(result, field.getModifier());
		result.setType(createTypeReference(declaringClass, field.getFieldType()));
		// createAnnotationValues(field, result);
		return result;

	}

	private ClassOrInterfaceTypeDetails findClassOrInterfaceTypeDetails(
			JavaType javaType) {
		String id = physicalTypeMetadataProvider.findIdentifier(javaType);
		if (id == null) {
			throw new TypeNotFoundException("Cannot locate source for '"
					+ javaType + "'");
		}
		PhysicalTypeMetadata ptm = (PhysicalTypeMetadata) physicalTypeMetadataProvider
				.get(id);
		if (ptm == null) {
			throw new TypeNotFoundException(
					"Cannot get PhysicalTypeMetadata for '" + javaType + "'");
		}
		PhysicalTypeDetails ptd = ptm.getMemberHoldingTypeDetails();
		if (ptd == null) {
			throw new TypeNotFoundException(
					"Cannot get PhysicalTypeDetails for '" + javaType + "'");
		}
		if (!(ptd instanceof ClassOrInterfaceTypeDetails)) {
			throw new TypeNotFoundException("PhysicalTypeDetails for '"
					+ javaType + "' are no ClassOrInterfaceTypeDetails, but "
					+ ptd.getClass());
		}
		ClassOrInterfaceTypeDetails cid = (ClassOrInterfaceTypeDetails) ptd;
		return cid;
	}

	protected void setSuperTypes(ClassOrInterfaceTypeDetails cid,
			JvmDeclaredType result) {
		if (cid.getSuperclass() != null)
			result.getSuperTypes().add(
					createTypeReference(cid, cid.getSuperclass().getName()));
		for (JavaType type : cid.getImplementsTypes()) {
			result.getSuperTypes().add(createTypeReference(cid, type));
		}

	}

	private JvmTypeReference createTypeReference(
			ClassOrInterfaceTypeDetails declaringClass, JavaType type) {

		JvmParameterizedTypeReference typeref = TypesFactory.eINSTANCE
				.createJvmParameterizedTypeReference();

		typeref.setType(createProxy(declaringClass, type));
		List<JavaType> parameters = type.getParameters();

		for (int i = 0; i < parameters.size(); i++) {
			JvmTypeArgument argument = createTypeArgument(declaringClass,parameters.get(i));
			typeref.getArguments().add(argument);
		}

		JvmTypeReference result = typeref;
		if (type.isArray()) {

			int dimensions = type.getArray();
			for (int i = 0; i < dimensions; i++) {
				JvmTypeReference componentTypeReference = result;
				result = TypesFactory.eINSTANCE
						.createJvmGenericArrayTypeReference();
				JvmArrayType resultArray = TypesFactory.eINSTANCE
						.createJvmArrayType();
				((JvmGenericArrayTypeReference) result).setType(resultArray);
				resultArray.setComponentType(componentTypeReference);
			}

		}
		return result;
	}

	public org.eclipse.xtext.common.types.JvmType createProxy(
			ClassOrInterfaceTypeDetails declaringClass, JavaType type) {
		InternalEObject proxy = (InternalEObject) TypesFactory.eINSTANCE
				.createJvmVoid();
		URI uri = uriHelper.getFullURI(declaringClass, type);
		proxy.eSetProxyURI(uri);
		return (org.eclipse.xtext.common.types.JvmType) proxy;
	}

	private JvmTypeArgument createTypeArgument(
			ClassOrInterfaceTypeDetails declaringClass,
			JavaType actualTypeArgument) {
		JavaSymbolName argName = actualTypeArgument.getArgName();
		if (WILDCARD_EXTENDS.equals(argName)
				|| WILDCARD_NEITHER.equals(argName)
				|| WILDCARD_SUPER.equals(argName)) {
			JvmWildcardTypeArgument result = TypesFactory.eINSTANCE
					.createJvmWildcardTypeArgument();
			if (WILDCARD_EXTENDS.equals(argName)) {
				JvmUpperBound upperBound = TypesFactory.eINSTANCE
						.createJvmUpperBound();
			
					JvmTypeReference upperBoundType = createTypeReference(
							declaringClass, actualTypeArgument);
					upperBound.setTypeReference(upperBoundType);
				
				result.getConstraints().add(upperBound);
			}
			if (WILDCARD_SUPER.equals(argName)) {
				JvmLowerBound lowerBound = TypesFactory.eINSTANCE
						.createJvmLowerBound();
				
					JvmTypeReference lowerBoundType = createTypeReference(
							declaringClass, actualTypeArgument);
					lowerBound.setTypeReference(lowerBoundType);
				
				result.getConstraints().add(lowerBound);
			}
			return result;
		} else {
			JvmReferenceTypeArgument result = TypesFactory.eINSTANCE
					.createJvmReferenceTypeArgument();
			JvmTypeReference typeReference = createTypeReference(
					declaringClass, actualTypeArgument);
			result.setTypeReference(typeReference);
			return result;
		}
	}

	public void setVisibility(org.eclipse.xtext.common.types.JvmMember result,
			int modifiers) {
		if (Modifier.isPrivate(modifiers))
			result.setVisibility(JvmVisibility.PRIVATE);
		else if (Modifier.isProtected(modifiers))
			result.setVisibility(JvmVisibility.PROTECTED);
		else if (Modifier.isPublic(modifiers))
			result.setVisibility(JvmVisibility.PUBLIC);
		else
			result.setVisibility(JvmVisibility.DEFAULT);
	}

	protected void setTypeModifiers(JvmDeclaredType result, int modifier) {
		result.setAbstract(Modifier.isAbstract(modifier));
		result.setFinal(Modifier.isFinal(modifier));
		result.setStatic(Modifier.isStatic(modifier));
	}

	private JvmType createEnumerationType(ClassOrInterfaceTypeDetails cid, List<MemberHoldingTypeDetails> details) {
		JvmEnumerationType result = TypesFactory.eINSTANCE.createJvmEnumerationType();
		result.setFullyQualifiedName(cid.getName().getFullyQualifiedTypeName());
		setVisibility(result, cid.getModifier());
		setTypeModifiers(result, cid.getModifier());
		//createNestedTypes(clazz, result);
		createMethods(cid, details, result);
		createFields(cid, details, result);
		createConstructors(cid, details, result);
		setSuperTypes(cid, result);
		createAnnotationValues(cid, details, result);
		return result;
	}

	private JvmType createAnnotationType(ClassOrInterfaceTypeDetails cid, List<MemberHoldingTypeDetails> details) {
		JvmAnnotationType result = TypesFactory.eINSTANCE.createJvmAnnotationType();
		result.setFullyQualifiedName(cid.getName().getFullyQualifiedTypeName());
		setVisibility(result, cid.getModifier());
		setTypeModifiers(result, cid.getModifier());
		//createNestedTypes(clazz, result);
		createMethods(cid, details, result);
		setSuperTypes(cid, result);
		createAnnotationValues(cid, details, result);
		return result;
	}

}
