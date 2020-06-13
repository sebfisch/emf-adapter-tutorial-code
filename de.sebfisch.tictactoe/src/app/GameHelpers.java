package app;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Optional;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import game.Board;
import game.Field;
import game.GameFactory;
import game.Mark;
import game.Player;

/**
 * Provides static methods operating on game model instances.
 */
public class GameHelpers {

	/**
	 * Creates an board where no player has marked fields yet. The player X is the
	 * one to play first.
	 * 
	 * @return model instance representing an empty board
	 */
	static Board emptyBoard() {
		final Board board = GameFactory.eINSTANCE.createBoard();
		board.setCurrentPlayer(Player.X);
		for (int index = 0; index < 9; index++) {
			board.getFields().add(emptyField(index));
		}
		return board;
	}

	/**
	 * Creates an empty field with the given index.
	 * 
	 * @param index index of the field
	 * 
	 * @return empty field
	 */
	static Field emptyField(int index) {
		final Field field = GameFactory.eINSTANCE.createField();
		field.setIndex(index);
		field.setMark(null);
		return field;
	}

	/**
	 * Creates a mark for the given player.
	 * 
	 * @param player player to show on the mark
	 * 
	 * @return mark for given player.
	 */
	static Mark markFor(Player player) {
		final Mark mark = GameFactory.eINSTANCE.createMark();
		mark.setPlayer(player);
		return mark;
	}

	/**
	 * Creates a user interface for the given board.
	 * 
	 * The fields of the board are displayed in a grid. They contain the marks of
	 * the players who have marked them previously or a button for the current
	 * player to mark them.
	 * 
	 * @param board model instance representing the board
	 * 
	 * @return component representing the given board
	 */
	static Component boardComponent(Board board) {
		final JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3, 3));
		board.getFields().forEach(field -> panel.add(fieldComponent(field, panel)));
		return panel;
	}

	/**
	 * Creates a user interface for a field on the board.
	 * 
	 * If the field is marked, the result is a label with the marking player's name.
	 * If it is not marked, the result is a button that can be used to mark the
	 * given field with the current player.
	 * 
	 * @param field     field model instance
	 * @param container grid to modify when the field is marked with the created
	 *                  button
	 * 
	 * @return component
	 */
	static Component fieldComponent(Field field, Container container) {
		final Component component = getMarkingPlayer(field) //
				.map(player -> markedFieldComponent(player)) //
				.orElseGet(() -> unmarkedFieldComponent(field, container));
		component.setPreferredSize(new Dimension(100, 100));
		return component;
	}

	/**
	 * Provides access to the player who marked the given field.
	 * 
	 * @param field field to access player from
	 * 
	 * @return marking player or empty if field is not marked
	 */
	static Optional<Player> getMarkingPlayer(Field field) {
		return Optional.ofNullable(field.getMark()).map(Mark::getPlayer);
	}

	/**
	 * Creates a component representing a player who marked a field.
	 * 
	 * @param player player to show on the created component
	 * @return component showing the given player
	 */
	static Component markedFieldComponent(Player player) {
		final JLabel label = new JLabel(player.toString(), SwingConstants.CENTER);
		label.setFont(new Font(label.getFont().getName(), Font.PLAIN, 90));
		return label;
	}

	/**
	 * Creates a component representing an unmarked field.
	 * 
	 * It can be clicked to mark the given field with the current player.
	 * 
	 * @param field     field to create a component for
	 * @param container container to modify when given field is marked
	 * 
	 * @return component representing unmarked field
	 */
	static Component unmarkedFieldComponent(Field field, Container container) {
		final JButton button = new JButton("");
		button.addActionListener(_event -> markFieldAt(container, field.getIndex(), makeMoveAt(field)));
		return button;
	}

	/**
	 * Modifies the board to reflect a move of the current player on the given
	 * field.
	 * 
	 * @param field field to make a move at
	 * 
	 * @return player that made the move
	 */
	public static Player makeMoveAt(Field field) {
		Board board = field.getBoard();
		Player player = board.getCurrentPlayer();
		field.setMark(markFor(player));
		board.setCurrentPlayer(Player.X.equals(player) ? Player.O : Player.X);
		return player;
	}

	/**
	 * Modifies the given container. The child at the given index is replace with a
	 * mark for the given player.
	 * 
	 * @param container container to replace component in
	 * @param index     index of child to replace
	 * @param player    player to create a mark for
	 */
	static void markFieldAt(Container container, int index, Player player) {
		container.remove(index);
		container.add(markedFieldComponent(player), index);
		container.revalidate();
		container.repaint();
	}
}
