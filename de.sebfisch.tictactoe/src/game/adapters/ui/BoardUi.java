package game.adapters.ui;

import java.awt.GridLayout;
import java.util.NoSuchElementException;

import javax.swing.JComponent;
import javax.swing.JPanel;

import org.eclipse.emf.ecore.EObject;

import game.Board;
import util.ObjectAdapter;

/**
 * Extends board model instances with user interface related operations.
 */
public class BoardUi extends ObjectAdapter<Board> {

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
		board.getFields().forEach(field -> panel.add(FieldUi.from(field).getUnmarkedComponent()));
	}
}
