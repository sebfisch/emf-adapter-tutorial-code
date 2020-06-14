package app;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JComponent;

import constructors.GameConstructors;
import game.Board;
import game.Field;
import game.Player;

/**
 * Provides static methods operating on field model instances.
 */
class FieldHelpers {

	private static final Dimension FIELD_DIMENSIONS = new Dimension(100, 100);

	/**
	 * Creates a component representing an unmarked field.
	 *
	 * It can be clicked to mark the given field with the current player.
	 *
	 * @param field     field to create a component for
	 * @param container container to modify when given field is marked
	 *
	 * @return component representing unmarked field
	 */
	static JComponent unmarkedFieldComponent(final Field field, final JComponent container) {
		final JButton button = new JButton("");
		button.setPreferredSize(FIELD_DIMENSIONS);
		button.addActionListener(_event -> BoardHelpers.markFieldAt(container, field.getIndex(), makeMoveAt(field)));
		return button;
	}

	/**
	 * Modifies the board to reflect a move of the current player on the given
	 * field.
	 *
	 * @param field field to make a move at
	 *
	 * @return player that made the move
	 */
	static Player makeMoveAt(final Field field) {
		final Board board = field.getBoard();
		final Player player = board.getCurrentPlayer();
		field.setMark(GameConstructors.markFor(player));
		board.setCurrentPlayer(Player.X.equals(player) ? Player.O : Player.X);
		return player;
	}
}
