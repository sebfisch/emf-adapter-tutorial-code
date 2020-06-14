package game.adapters.ui;

import java.awt.Dimension;
import java.util.NoSuchElementException;

import javax.swing.JButton;
import javax.swing.JComponent;

import org.eclipse.emf.common.notify.Notification;

import constructors.UiConstructors;
import game.Field;
import game.GamePackage;
import game.adapters.access.FieldAccess;
import util.ObjectAdapter;

/**
 * Extends field model instances with user interface related operations.
 */
public class FieldUi extends ObjectAdapter<Field> {

	private static final int LABEL_SIZE = 90;
	private static final Dimension FIELD_DIMENSIONS = new Dimension(100, 100);

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
		return from(field, FieldUi.class);
	}

	/**
	 * Constructs a field UI. Use {@link UiAdapterFactory::adaptAllNew} to attach a
	 * field UI to a field model instance.
	 */
	FieldUi() {
		super(Field.class);
		button = new JButton("");
		button.setPreferredSize(FIELD_DIMENSIONS);
		button.addActionListener(_event -> FieldAccess.from(getTarget()).makeMove());
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
		FieldAccess.from(getTarget()).getMarkingPlayer().ifPresent(player -> {
			final JComponent child = UiConstructors.boldLabel(player.toString(), LABEL_SIZE);
			BoardUi.fromContainer(getTarget()).replaceChild(getTarget().getIndex(), child);
		});
	}

	@Override
	public void notifyChanged(final int eventType, final int featureId) {
		if (eventType == Notification.SET && featureId == GamePackage.FIELD__MARK) {
			updateMark();
		}
	}
}
