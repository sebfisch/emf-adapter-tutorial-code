package app;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import game.Board;

/**
 * Implements a graphical user interface for playing the game.
 */
public class TicTacToeApp {
	
	/**
	 * Runs the game.
	 * 
	 * @param args command line arguments are ignored
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new TicTacToeApp().show());
	}
	
	private static final String WINDOW_TITLE = "Tic Tac Toe";

	private static JFrame emptyWindow() {
		final JFrame frame = new JFrame(WINDOW_TITLE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		return frame;
	}

	private Board board;
	private JFrame window;
	
	/**
	 * Creates a graphical user interface for the game.
	 */
	public TicTacToeApp() {
		board = GameHelpers.emptyBoard();
		window = emptyWindow();
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
