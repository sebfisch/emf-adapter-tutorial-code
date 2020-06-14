package game.helpers;

import java.awt.GridLayout;

import javax.swing.JComponent;
import javax.swing.JPanel;

import game.Board;

/**
 * Provides static methods operating on board model instances.
 */
public class BoardHelpers {

	private static final int GRID_SIZE = 3;

	/**
	 * Creates a user interface for the given board.
	 *
	 * The fields of the board are displayed in a grid. They contain the marks of
	 * the players who have marked them previously or a button for the current
	 * player to mark them.
	 *
	 * @param board model instance representing the board
	 *
	 * @return component representing the given board
	 */
	public static JComponent getComponent(final Board board) {
		final JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(GRID_SIZE, GRID_SIZE));
		board.getFields().forEach(field -> FieldHelpers.addUnmarkedFieldComponent(field, panel));
		return panel;
	}

	/**
	 * Modifies the given parent component, replacing the child at the given index
	 * with the given child component.
	 *
	 * @param parent parent component
	 * @param index  index of child component to replace
	 * @param child  new child component
	 */
	public static void replaceChild(final JComponent parent, final int index, final JComponent child) {
		parent.remove(index);
		parent.add(child, index);
		parent.revalidate();
		parent.repaint();
	}
}
