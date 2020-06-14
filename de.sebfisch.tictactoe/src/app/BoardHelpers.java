package app;

import java.awt.GridLayout;

import javax.swing.JComponent;
import javax.swing.JPanel;

import game.Board;
import game.Player;

/**
 * Provides static methods operating on board model instances.
 */
class BoardHelpers {

	private static final int GRID_SIZE = 3;
	private static final int LABEL_SIZE = 90;

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
	static JComponent getComponent(final Board board) {
		final JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(GRID_SIZE, GRID_SIZE));
		board.getFields().forEach(field -> panel.add(FieldHelpers.unmarkedFieldComponent(field, panel)));
		return panel;
	}

	/**
	 * Modifies the given container. The child at the given index is replaced with a
	 * mark for the given player.
	 *
	 * @param container container to replace component in
	 * @param index     index of child to replace
	 * @param player    player to create a mark for
	 */
	static void markFieldAt(final JComponent container, final int index, final Player player) {
		container.remove(index);
		container.add(UiConstructors.boldLabel(player.toString(), LABEL_SIZE), index);
		container.revalidate();
		container.repaint();
	}
}
