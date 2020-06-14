/**
 */
package game;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mark</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link game.Mark#getPlayer <em>Player</em>}</li>
 *   <li>{@link game.Mark#getField <em>Field</em>}</li>
 * </ul>
 *
 * @see game.GamePackage#getMark()
 * @model
 * @generated
 */
public interface Mark extends EObject {
	/**
	 * Returns the value of the '<em><b>Player</b></em>' attribute.
	 * The literals are from the enumeration {@link game.Player}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Player</em>' attribute.
	 * @see game.Player
	 * @see #setPlayer(Player)
	 * @see game.GamePackage#getMark_Player()
	 * @model required="true"
	 * @generated
	 */
	Player getPlayer();

	/**
	 * Sets the value of the '{@link game.Mark#getPlayer <em>Player</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Player</em>' attribute.
	 * @see game.Player
	 * @see #getPlayer()
	 * @generated
	 */
	void setPlayer(Player value);

	/**
	 * Returns the value of the '<em><b>Field</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link game.Field#getMark <em>Mark</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Field</em>' container reference.
	 * @see #setField(Field)
	 * @see game.GamePackage#getMark_Field()
	 * @see game.Field#getMark
	 * @model opposite="mark" required="true" transient="false"
	 * @generated
	 */
	Field getField();

	/**
	 * Sets the value of the '{@link game.Mark#getField <em>Field</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Field</em>' container reference.
	 * @see #getField()
	 * @generated
	 */
	void setField(Field value);

} // Mark
