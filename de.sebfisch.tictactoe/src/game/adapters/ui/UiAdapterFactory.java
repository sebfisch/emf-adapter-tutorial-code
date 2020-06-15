package game.adapters.ui;

import game.util.GameAdapterFactory;

/**
 * Creates user interface adapters for game model instances.
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
