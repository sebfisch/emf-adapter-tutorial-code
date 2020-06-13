/**
 */
package game;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see game.GameFactory
 * @model kind="package"
 * @generated
 */
public interface GamePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "game";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://de/sebfisch/tictactoe/game";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "de.sebfisch.tictactoe.game";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GamePackage eINSTANCE = game.impl.GamePackageImpl.init();

	/**
	 * The meta object id for the '{@link game.impl.FieldImpl <em>Field</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see game.impl.FieldImpl
	 * @see game.impl.GamePackageImpl#getField()
	 * @generated
	 */
	int FIELD = 0;

	/**
	 * The feature id for the '<em><b>Mark</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD__MARK = 0;

	/**
	 * The number of structural features of the '<em>Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link game.impl.BoardImpl <em>Board</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see game.impl.BoardImpl
	 * @see game.impl.GamePackageImpl#getBoard()
	 * @generated
	 */
	int BOARD = 1;

	/**
	 * The feature id for the '<em><b>Fields</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOARD__FIELDS = 0;

	/**
	 * The feature id for the '<em><b>Current</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOARD__CURRENT = 1;

	/**
	 * The number of structural features of the '<em>Board</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOARD_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Board</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOARD_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link game.Player <em>Player</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see game.Player
	 * @see game.impl.GamePackageImpl#getPlayer()
	 * @generated
	 */
	int PLAYER = 2;


	/**
	 * Returns the meta object for class '{@link game.Field <em>Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Field</em>'.
	 * @see game.Field
	 * @generated
	 */
	EClass getField();

	/**
	 * Returns the meta object for the attribute '{@link game.Field#getMark <em>Mark</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mark</em>'.
	 * @see game.Field#getMark()
	 * @see #getField()
	 * @generated
	 */
	EAttribute getField_Mark();

	/**
	 * Returns the meta object for class '{@link game.Board <em>Board</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Board</em>'.
	 * @see game.Board
	 * @generated
	 */
	EClass getBoard();

	/**
	 * Returns the meta object for the containment reference list '{@link game.Board#getFields <em>Fields</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Fields</em>'.
	 * @see game.Board#getFields()
	 * @see #getBoard()
	 * @generated
	 */
	EReference getBoard_Fields();

	/**
	 * Returns the meta object for the attribute '{@link game.Board#getCurrent <em>Current</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Current</em>'.
	 * @see game.Board#getCurrent()
	 * @see #getBoard()
	 * @generated
	 */
	EAttribute getBoard_Current();

	/**
	 * Returns the meta object for enum '{@link game.Player <em>Player</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Player</em>'.
	 * @see game.Player
	 * @generated
	 */
	EEnum getPlayer();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	GameFactory getGameFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link game.impl.FieldImpl <em>Field</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see game.impl.FieldImpl
		 * @see game.impl.GamePackageImpl#getField()
		 * @generated
		 */
		EClass FIELD = eINSTANCE.getField();

		/**
		 * The meta object literal for the '<em><b>Mark</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FIELD__MARK = eINSTANCE.getField_Mark();

		/**
		 * The meta object literal for the '{@link game.impl.BoardImpl <em>Board</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see game.impl.BoardImpl
		 * @see game.impl.GamePackageImpl#getBoard()
		 * @generated
		 */
		EClass BOARD = eINSTANCE.getBoard();

		/**
		 * The meta object literal for the '<em><b>Fields</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOARD__FIELDS = eINSTANCE.getBoard_Fields();

		/**
		 * The meta object literal for the '<em><b>Current</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOARD__CURRENT = eINSTANCE.getBoard_Current();

		/**
		 * The meta object literal for the '{@link game.Player <em>Player</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see game.Player
		 * @see game.impl.GamePackageImpl#getPlayer()
		 * @generated
		 */
		EEnum PLAYER = eINSTANCE.getPlayer();

	}

} //GamePackage
