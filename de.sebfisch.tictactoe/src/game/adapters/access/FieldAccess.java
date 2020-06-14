package game.adapters.access;

import java.util.NoSuchElementException;
import java.util.Optional;

import constructors.GameConstructors;
import game.Board;
import game.Field;
import game.Mark;
import game.Player;
import util.ObjectAdapter;

public class FieldAccess extends ObjectAdapter<Field> {

	/**
	 * Provides access to the field access adapter registered with a field model
	 * instance.
	 *
	 * @param field field model instance
	 *
	 * @return field access adapter
	 *
	 * @throws NoSuchElementException if no field access adapter is registered
	 */
	public static FieldAccess from(final Field field) {
		return from(field, FieldAccess.class);
	}

	/**
	 * Constructs a field access adapter. Use
	 * {@link AccessAdapterFactory::adaptAllNew} to attach a field access adapter to
	 * a field model instance.
	 */
	FieldAccess() {
		super(Field.class);
	}

	/**
	 * Modifies the board to reflect a move of the current player on the associated
	 * field.
	 */
	public void makeMove() {
		final Board board = getTarget().getBoard();
		final Player player = board.getCurrentPlayer();
		getTarget().setMark(GameConstructors.markFor(player));
		board.setCurrentPlayer(Player.X.equals(player) ? Player.O : Player.X);
	}

	/**
	 * Provides access to the player whose mark is on the associated field.
	 *
	 * @return marking player or empty if no mark is present
	 */
	public Optional<Player> getMarkingPlayer() {
		return Optional.ofNullable(getTarget().getMark()).map(Mark::getPlayer);
	}
}
