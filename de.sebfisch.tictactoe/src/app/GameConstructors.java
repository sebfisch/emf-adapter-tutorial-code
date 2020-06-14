package app;

import game.Board;
import game.Field;
import game.GameFactory;
import game.Mark;
import game.Player;

/**
 * Provides static methods to construct game objects.
 */
class GameConstructors {

	private static final int FIELD_COUNT = 9;

	/**
	 * Creates an board where no player has marked fields yet. The player X is the
	 * one to play first.
	 *
	 * @return model instance representing an empty board
	 */
	static Board emptyBoard() {
		final Board board = GameFactory.eINSTANCE.createBoard();
		board.setCurrentPlayer(Player.X);
		for (int index = 0; index < FIELD_COUNT; index++) {
			board.getFields().add(emptyField(index));
		}
		return board;
	}

	/**
	 * Creates an empty field with the given index.
	 *
	 * @param index index of the field
	 *
	 * @return empty field
	 */
	static Field emptyField(final int index) {
		final Field field = GameFactory.eINSTANCE.createField();
		field.setIndex(index);
		field.setMark(null);
		return field;
	}

	/**
	 * Creates a mark for the given player.
	 *
	 * @param player player to show on the mark
	 *
	 * @return mark for given player.
	 */
	static Mark markFor(final Player player) {
		final Mark mark = GameFactory.eINSTANCE.createMark();
		mark.setPlayer(player);
		return mark;
	}
}
