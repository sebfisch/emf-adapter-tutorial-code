package game.helpers;

import java.awt.Dimension;
import java.util.Optional;

import javax.swing.JButton;
import javax.swing.JComponent;

import constructors.GameConstructors;
import constructors.UiConstructors;
import game.Board;
import game.Field;
import game.Mark;
import game.Player;

/**
 * Provides static methods operating on field model instances.
 */
class FieldHelpers {

	private static final int LABEL_SIZE = 90;
	private static final Dimension FIELD_DIMENSIONS = new Dimension(100, 100);

	/**
	 * Adds a component representing an unmarked field to the given parent
	 * component.
	 *
	 * The created component can be clicked to mark the given field with the name of
	 * the current player.
	 *
	 * @param field  field to create a component for
	 * @param parent parent component for the created component
	 */
	public static void addUnmarkedFieldComponent(final Field field, final JComponent parent) {
		final JButton button = new JButton("");
		button.setPreferredSize(FIELD_DIMENSIONS);
		button.addActionListener(_event -> {
			makeMoveAt(field);
			updateMark(field, parent);
		});
		parent.add(button);
	}

	/**
	 * Modifies the board to reflect a move of the current player on the given
	 * field.
	 *
	 * @param field field to make a move at
	 *
	 * @return player that made the move
	 */
	public static void makeMoveAt(final Field field) {
		final Board board = field.getBoard();
		final Player player = board.getCurrentPlayer();
		field.setMark(GameConstructors.markFor(player));
		board.setCurrentPlayer(Player.X.equals(player) ? Player.O : Player.X);
	}

	/**
	 * Shows the name of the marking player on the user interface component for the
	 * given field.
	 *
	 * @param parent parent component containing the component for this field
	 * @param field  field model instance
	 */
	public static void updateMark(final Field field, final JComponent parent) {
		getMarkingPlayer(field).ifPresent(player -> {
			final JComponent child = UiConstructors.boldLabel(player.toString(), LABEL_SIZE);
			BoardHelpers.replaceChild(parent, field.getIndex(), child);
		});
	}

	/**
	 * Provides access to the player whose mark is on the given field.
	 *
	 * @param field field model instance
	 *
	 * @return marking player or empty if no mark is present
	 */
	public static Optional<Player> getMarkingPlayer(final Field field) {
		return Optional.ofNullable(field.getMark()).map(Mark::getPlayer);
	}
}
