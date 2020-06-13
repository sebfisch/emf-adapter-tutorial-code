package app;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import game.Board;

/**
 * Implements a graphical user interface for playing the game.
 */
public class TicTacToe {

	/**
	 * Runs the game.
	 * 
	 * @param args command line arguments are ignored
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new TicTacToe().show());
	}

	private static final String WINDOW_TITLE = "Tic Tac Toe";

	private static JFrame emptyWindow(String title) {
		final JFrame frame = new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		return frame;
	}

	private Board board;
	private JFrame window;

	/**
	 * Creates a graphical user interface for the game.
	 */
	public TicTacToe() {
		board = GameHelpers.emptyBoard();
		window = emptyWindow(WINDOW_TITLE);
		window.getContentPane().add(GameHelpers.boardComponent(board));
	}

	/**
	 * Displays a window for playing the game.
	 */
	public void show() {
		window.pack();
		window.setVisible(true);
	}
}
