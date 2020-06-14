package app;

import java.awt.Font;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

/**
 * Provides static methods to construct user interface objects.
 */
class UiConstructors {

	/**
	 * Constructs an empty window with the given title.
	 *
	 * @param title window title
	 *
	 * @return window object
	 */
	static JFrame emptyWindow(final String title) {
		final JFrame frame = new JFrame(title);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setResizable(false);
		return frame;
	}

	/**
	 * Constructs a bold label with the given font size.
	 *
	 * @param text text to show on the label
	 * @param size font size to use for the label
	 *
	 * @return label component
	 */
	static JComponent boldLabel(final String text, final int size) {
		final JLabel label = new JLabel(text, SwingConstants.CENTER);
		label.setFont(new Font(label.getFont().getName(), Font.BOLD, size));
		return label;
	}
}
