package game.adapters;

import java.awt.Dimension;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.swing.JButton;
import javax.swing.JComponent;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;

import constructors.GameConstructors;
import constructors.UiConstructors;
import game.Board;
import game.Field;
import game.GamePackage;
import game.Mark;
import game.Player;

/**
 * Extends field model instances with user interface related operations.
 */
public class FieldUi implements Adapter {

	private static final int LABEL_SIZE = 90;
	private static final Dimension FIELD_DIMENSIONS = new Dimension(100, 100);

	private Field field;
	private final JButton button;

	/**
	 * Provides access to the field UI registered with a field model instance.
	 *
	 * @param field field model instance
	 *
	 * @return field UI
	 *
	 * @throws NoSuchElementException if no field UI is registered
	 */
	public static FieldUi from(final Field field) {
		return field.eAdapters().stream() //
				.filter(FieldUi.class::isInstance) //
				.map(FieldUi.class::cast) //
				.findFirst().orElseThrow();
	}

	/**
	 * Constructs a field UI.
	 */
	public FieldUi() {
		button = new JButton("");
		button.setPreferredSize(FIELD_DIMENSIONS);
		button.addActionListener(_event -> makeMove());
	}

	/**
	 * Provides access to the user interface component representing an unmarked
	 * field.
	 *
	 * @return button for marking the associated field
	 */
	public JComponent getUnmarkedComponent() {
		return button;
	}

	/**
	 * Modifies the board to reflect a move of the current player on the associated
	 * field.
	 *
	 * @return player that made the move
	 */
	public Player makeMove() {
		final Board board = field.getBoard();
		final Player player = board.getCurrentPlayer();
		field.setMark(GameConstructors.markFor(player));
		board.setCurrentPlayer(Player.X.equals(player) ? Player.O : Player.X);
		return player;
	}

	/**
	 * Provides access to the player whose mark is on the associated field.
	 *
	 * @return marking player or empty if no mark is present
	 */
	public Optional<Player> getMarkingPlayer() {
		return Optional.ofNullable(field.getMark()).map(Mark::getPlayer);
	}

	/**
	 * Shows the name of the marking player on the user interface component for the
	 * associated field.
	 */
	public void updateMark() {
		getMarkingPlayer().ifPresent(player -> {
			final JComponent child = UiConstructors.boldLabel(player.toString(), LABEL_SIZE);
			BoardUi.from(field.getBoard()).replaceChild(field.getIndex(), child);
		});
	}

	@Override
	public void notifyChanged(final Notification notification) {
		if (notification.isTouch()) {
			return;
		}
		if (notification.getEventType() == Notification.SET) {
			switch (notification.getFeatureID(Field.class)) {
			case GamePackage.FIELD__MARK:
				updateMark();
				break;
			default:
				break;
			}
		}
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
