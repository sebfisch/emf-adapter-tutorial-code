package game.adapters.access;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;

import constructors.GameConstructors;
import game.Board;
import game.Field;
import game.Mark;
import game.Player;

public class FieldAccess implements Adapter {

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
		return field.eAdapters().stream() //
				.filter(FieldAccess.class::isInstance) //
				.map(FieldAccess.class::cast) //
				.findFirst().orElseThrow();
	}

	private Field field;

	/**
	 * Constructs a field access adapter. Use
	 * {@link AccessAdapterFactory::adaptAllNew} to attach a field access adapter to
	 * a field model instance.
	 */
	FieldAccess() {
	}

	/**
	 * Modifies the board to reflect a move of the current player on the associated
	 * field.
	 */
	public void makeMove() {
		final Board board = field.getBoard();
		final Player player = board.getCurrentPlayer();
		field.setMark(GameConstructors.markFor(player));
		board.setCurrentPlayer(Player.X.equals(player) ? Player.O : Player.X);
	}

	/**
	 * Provides access to the player whose mark is on the associated field.
	 *
	 * @return marking player or empty if no mark is present
	 */
	public Optional<Player> getMarkingPlayer() {
		return Optional.ofNullable(field.getMark()).map(Mark::getPlayer);
	}

	@Override
	public void notifyChanged(final Notification notification) {
	}

	@Override
	public Field getTarget() {
		return field;
	}

	@Override
	public void setTarget(final Notifier target) {
		if (target instanceof Field) {
			field = (Field) target;
		}
	}

	@Override
	public boolean isAdapterForType(final Object target) {
		return target instanceof Field;
	}
}
