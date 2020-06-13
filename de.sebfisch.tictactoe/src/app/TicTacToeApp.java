package app;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * This class implements a graphical user interface for playing Tic Tac Toe.
 */
public class TicTacToeApp {
	
	/**
	 * Runs the Game.
	 * 
	 * @param args command line arguments are ignored
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new TicTacToeApp().show());
	}
	
	private static final String WINDOW_TITLE = "Tic Tac Toe";
	
	private JFrame frame;
	
	/**
	 * Creates a graphical user interface for the game.
	 */
	public TicTacToeApp() {
		frame = new JFrame(WINDOW_TITLE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * Displays a window for playing the game.
	 */
	public void show() {
		frame.pack();
		frame.setVisible(true);
	}
}
