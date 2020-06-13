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

} // Mark
