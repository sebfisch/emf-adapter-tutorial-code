package game.adapters.ui;

import java.awt.Dimension;
import java.util.NoSuchElementException;

import javax.swing.JButton;
import javax.swing.JComponent;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;

import constructors.UiConstructors;
import game.Field;
import game.GamePackage;
import game.adapters.access.FieldAccess;

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
	 * Constructs a field UI. Use {@link UiAdapterFactory::adaptAllNew} to attach a
	 * field UI to a field model instance.
	 */
	FieldUi() {
		button = new JButton("");
		button.setPreferredSize(FIELD_DIMENSIONS);
		button.addActionListener(_event -> FieldAccess.from(field).makeMove());
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
	 * Shows the name of the marking player on the user interface component for the
	 * associated field.
	 */
	public void updateMark() {
		FieldAccess.from(field).getMarkingPlayer().ifPresent(player -> {
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
