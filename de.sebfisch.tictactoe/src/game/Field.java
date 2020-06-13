/**
 */
package game;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Field</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link game.Field#getMark <em>Mark</em>}</li>
 * </ul>
 *
 * @see game.GamePackage#getField()
 * @model
 * @generated
 */
public interface Field extends EObject {
	/**
	 * Returns the value of the '<em><b>Mark</b></em>' attribute.
	 * The literals are from the enumeration {@link game.Player}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mark</em>' attribute.
	 * @see game.Player
	 * @see #setMark(Player)
	 * @see game.GamePackage#getField_Mark()
	 * @model
	 * @generated
	 */
	Player getMark();

	/**
	 * Sets the value of the '{@link game.Field#getMark <em>Mark</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mark</em>' attribute.
	 * @see game.Player
	 * @see #getMark()
	 * @generated
	 */
	void setMark(Player value);

} // Field
