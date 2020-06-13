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
 *   <li>{@link game.Board#getCurrentPlayer <em>Current Player</em>}</li>
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
	 * It is bidirectional and its opposite is '{@link game.Field#getBoard <em>Board</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fields</em>' containment reference list.
	 * @see game.GamePackage#getBoard_Fields()
	 * @see game.Field#getBoard
	 * @model opposite="board" containment="true" lower="9" upper="9"
	 * @generated
	 */
	EList<Field> getFields();

	/**
	 * Returns the value of the '<em><b>Current Player</b></em>' attribute.
	 * The literals are from the enumeration {@link game.Player}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Current Player</em>' attribute.
	 * @see game.Player
	 * @see #setCurrentPlayer(Player)
	 * @see game.GamePackage#getBoard_CurrentPlayer()
	 * @model required="true"
	 * @generated
	 */
	Player getCurrentPlayer();

	/**
	 * Sets the value of the '{@link game.Board#getCurrentPlayer <em>Current Player</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Current Player</em>' attribute.
	 * @see game.Player
	 * @see #getCurrentPlayer()
	 * @generated
	 */
	void setCurrentPlayer(Player value);

} // Board
