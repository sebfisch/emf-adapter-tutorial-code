package game.adapters.ui;

import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.NoSuchElementException;

import javax.swing.JComponent;
import javax.swing.JPanel;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;

import constructors.UiConstructors;
import game.Board;
import game.GamePackage;
import game.Player;
import game.adapters.access.BoardAccess;
import util.ObjectAdapter;

/**
 * Extends board model instances with user interface related operations.
 */
public class BoardUi extends ObjectAdapter<Board> implements KeyListener {

	private static final int GRID_SIZE = 3;

	private final JPanel panel;

	/**
	 * Provides access to the board UI registered with a board model instance.
	 *
	 * @param board board model instance
	 *
	 * @return board UI
	 *
	 * @throws NoSuchElementException if no board UI is registered
	 */
	public static BoardUi from(final Board board) {
		return from(board, BoardUi.class);
	}

	/**
	 * Provides access to the board UI registered with a board container of the
	 * given child object.
	 *
	 * @param child child of a board model instance
	 *
	 * @return board UI
	 *
	 * @throws NoSuchElementException if no board UI is registered with a container
	 */
	public static BoardUi fromContainer(final EObject child) {
		return fromContainer(child, Board.class, BoardUi.class);
	}

	/**
	 * Constructs a board UI. Use {@link UiAdapterFactory::adaptAllNew} to attach a
	 * board UI to a board model instance.
	 */
	BoardUi() {
		super(Board.class);
		panel = new JPanel();
		panel.setLayout(new GridLayout(GRID_SIZE, GRID_SIZE));
		panel.addKeyListener(this);
	}

	/**
	 * Provides access to the user interface component representing the associated
	 * board.
	 *
	 * @return board component
	 */
	public JComponent getComponent() {
		return panel;
	}

	/**
	 * Modifies the user interface component representing the board, replacing the
	 * child at the given index with the given component.
	 *
	 * @param index index of child component to replace
	 * @param child new child component
	 */
	public void replaceChild(final int index, final JComponent child) {
		panel.remove(index);
		panel.add(child, index);
		panel.revalidate();
		panel.repaint();
	}

	@Override
	public void setTarget(final Board board) {
		super.setTarget(board);
		panel.removeAll();
		board.getFields().forEach(field -> {
			field.setMark(null);
			final JComponent fieldComponent = FieldUi.from(field).getUnmarkedComponent();
			panel.add(fieldComponent);
			fieldComponent.addKeyListener(this);
		});
	}

	@Override
	public void notifyChanged(final int eventType, final int featureId) {
		if (eventType == Notification.SET && featureId == GamePackage.FIELD__MARK
				&& BoardAccess.from(getTarget()).hasWinner()) {
			disableUnmarkedFields();
		}
	}

	/**
	 * Replace user interfaces for unmarked fields with blank components.
	 */
	public void disableUnmarkedFields() {
		getTarget().getFields().forEach(field -> {
			if (field.getMark() == null) {
				final JComponent blank = UiConstructors.blankComponent();
				replaceChild(field.getIndex(), blank);
				blank.addKeyListener(this);
				blank.setFocusable(true);
			}
		});
	}

	@Override
	public void keyTyped(final KeyEvent e) {
		if (e.getExtendedKeyCode() == KeyEvent.VK_ESCAPE) {
			final Board board = getTarget();
			board.setCurrentPlayer(Player.X);
			setTarget(board);
			panel.revalidate();
			panel.repaint();
		}
	}

	@Override
	public void keyPressed(final KeyEvent e) {
	}

	@Override
	public void keyReleased(final KeyEvent e) {
	}
}
