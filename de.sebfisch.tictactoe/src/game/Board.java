/**
 */
package game;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Board</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link game.Board#getFields <em>Fields</em>}</li>
 *   <li>{@link game.Board#getCurrent <em>Current</em>}</li>
 * </ul>
 *
 * @see game.GamePackage#getBoard()
 * @model
 * @generated
 */
public interface Board extends EObject {
	/**
	 * Returns the value of the '<em><b>Fields</b></em>' containment reference list.
	 * The list contents are of type {@link game.Field}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fields</em>' containment reference list.
	 * @see game.GamePackage#getBoard_Fields()
	 * @model containment="true" lower="9" upper="9"
	 * @generated
	 */
	EList<Field> getFields();

	/**
	 * Returns the value of the '<em><b>Current</b></em>' attribute.
	 * The literals are from the enumeration {@link game.Player}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Current</em>' attribute.
	 * @see game.Player
	 * @see #setCurrent(Player)
	 * @see game.GamePackage#getBoard_Current()
	 * @model required="true"
	 * @generated
	 */
	Player getCurrent();

	/**
	 * Sets the value of the '{@link game.Board#getCurrent <em>Current</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Current</em>' attribute.
	 * @see game.Player
	 * @see #getCurrent()
	 * @generated
	 */
	void setCurrent(Player value);

} // Board
