package game.adapters;

import game.util.GameAdapterFactory;

/**
 * Creates adapters for game model instances.
 */
public class UiAdapterFactory extends GameAdapterFactory {

	@Override
	public BoardUi createBoardAdapter() {
		return new BoardUi();
	}

	@Override
	public FieldUi createFieldAdapter() {
		return new FieldUi();
	}
}
