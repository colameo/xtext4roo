/**
 * <copyright>
 * </copyright>
 *

 */
package de.saxsys.roo.xtext.example.somedsl.someDsl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.common.types.JvmType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Greeting</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.saxsys.roo.xtext.example.somedsl.someDsl.Greeting#getName <em>Name</em>}</li>
 *   <li>{@link de.saxsys.roo.xtext.example.somedsl.someDsl.Greeting#getEntity <em>Entity</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.saxsys.roo.xtext.example.somedsl.someDsl.SomeDslPackage#getGreeting()
 * @model
 * @generated
 */
public interface Greeting extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see de.saxsys.roo.xtext.example.somedsl.someDsl.SomeDslPackage#getGreeting_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link de.saxsys.roo.xtext.example.somedsl.someDsl.Greeting#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Entity</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Entity</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Entity</em>' reference.
   * @see #setEntity(JvmType)
   * @see de.saxsys.roo.xtext.example.somedsl.someDsl.SomeDslPackage#getGreeting_Entity()
   * @model
   * @generated
   */
  JvmType getEntity();

  /**
   * Sets the value of the '{@link de.saxsys.roo.xtext.example.somedsl.someDsl.Greeting#getEntity <em>Entity</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Entity</em>' reference.
   * @see #getEntity()
   * @generated
   */
  void setEntity(JvmType value);

} // Greeting
