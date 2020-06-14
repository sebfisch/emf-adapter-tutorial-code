package game.adapters.access;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

import game.Board;
import game.Field;
import game.Player;
import util.Iter;
import util.ObjectAdapter;

public class BoardAccess extends ObjectAdapter<Board> {

	/**
	 * Provides access to the board access adapter registered with a board model
	 * instance.
	 *
	 * @param board model instance
	 *
	 * @return board access adapter
	 *
	 * @throws NoSuchElementException if no board access adapter is registered
	 */
	public static BoardAccess from(final Board board) {
		return from(board, BoardAccess.class);
	}

	/**
	 * Constructs a board access adapter. Use
	 * {@link AccessAdapterFactory::adaptAllNew} to attach a board access adapter to
	 * a board model instance.
	 */
	BoardAccess() {
		super(Board.class);
	}

	/**
	 * Checks if the game has a winner.
	 *
	 * @return true if one of the players has won the game
	 */
	public boolean hasWinner() {
		return isWinner(Player.X) || isWinner(Player.O);
	}

	/**
	 * Checks if the given player has won the game.
	 *
	 * @param player player to check winning condition for
	 * @return true if the given player has won the game
	 */
	public boolean isWinner(final Player player) {
		return lines().anyMatch(line -> line.allMatch(fa -> fa.getMarkingPlayer().map(player::equals).orElse(false)));
	}

	private Stream<Stream<FieldAccess>> lines() {
		final Stream.Builder<Stream<FieldAccess>> builder = Stream.builder();

		Iter.range(3).forEach(row -> builder.add(line(3 * row, 3 * row + 1, 3 * row + 2)));
		Iter.range(3).forEach(col -> builder.add(line(col, 3 + col, 6 + col)));
		builder.add(line(0, 4, 8));
		builder.add(line(2, 4, 6));

		return builder.build();
	}

	private Stream<FieldAccess> line(final Integer... indices) {
		final List<Field> fields = getTarget().getFields();
		return Stream.of(indices).map(fields::get).map(FieldAccess::from);
	}
}
