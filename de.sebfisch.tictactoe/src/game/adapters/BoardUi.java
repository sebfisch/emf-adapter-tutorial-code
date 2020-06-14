package game.adapters;

import java.awt.GridLayout;
import java.util.NoSuchElementException;

import javax.swing.JComponent;
import javax.swing.JPanel;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;

import game.Board;

/**
 * Extends board model instances with user interface related operations.
 */
public class BoardUi implements Adapter {

	private static final int GRID_SIZE = 3;

	private Board board;
	private final JPanel panel;

	/**
	 * Provides access to the board UI registered with a board model instance.
	 *
	 * @param board board model instance
	 *
	 * @return board UI
	 *
	 * @throws NoSuchElementException if no board UI is registered
	 */
	public static BoardUi from(final Board board) {
		return board.eAdapters().stream() //
				.filter(BoardUi.class::isInstance) //
				.map(BoardUi.class::cast) //
				.findFirst().orElseThrow();
	}

	/**
	 * Constructs a board UI.
	 */
	public BoardUi() {
		panel = new JPanel();
		panel.setLayout(new GridLayout(GRID_SIZE, GRID_SIZE));
	}

	/**
	 * Provides access to the user interface component representing the associated
	 * board.
	 *
	 * @return board component
	 */
	public JComponent getComponent() {
		return panel;
	}

	/**
	 * Modifies the user interface component representing the board, replacing the
	 * child at the given index with the given component.
	 *
	 * @param index index of child component to replace
	 * @param child new child component
	 */
	public void replaceChild(final int index, final JComponent child) {
		panel.remove(index);
		panel.add(child, index);
		panel.revalidate();
		panel.repaint();
	}

	@Override
	public void notifyChanged(final Notification notification) {
	}

	@Override
	public Board getTarget() {
		return board;
	}

	@Override
	public void setTarget(final Notifier target) {
		if (target instanceof Board) {
			board = (Board) target;
			panel.removeAll();
			board.getFields().forEach(field -> panel.add(FieldUi.from(field).getUnmarkedComponent()));
		}
	}

	@Override
	public boolean isAdapterForType(final Object target) {
		return target instanceof Board;
	}
}
