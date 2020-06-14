package app;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import constructors.GameConstructors;
import constructors.UiConstructors;
import game.Board;
import game.adapters.BoardUi;

/**
 * Implements a graphical user interface for playing the game.
 */
public class TicTacToe {

	/**
	 * Runs the game.
	 *
	 * @param args command line arguments are ignored
	 */
	public static void main(final String[] args) {
		SwingUtilities.invokeLater(() -> new TicTacToe().show());
	}

	private static final String WINDOW_TITLE = "Tic Tac Toe";

	private final Board board;
	private final JFrame window;

	/**
	 * Creates a graphical user interface for the game.
	 */
	public TicTacToe() {
		board = GameConstructors.emptyBoard();
		window = UiConstructors.emptyWindow(WINDOW_TITLE);
		window.getContentPane().add(BoardUi.from(board).getComponent());
	}

	/**
	 * Displays a window for playing the game.
	 */
	public void show() {
		window.pack();
		window.setVisible(true);
	}
}
