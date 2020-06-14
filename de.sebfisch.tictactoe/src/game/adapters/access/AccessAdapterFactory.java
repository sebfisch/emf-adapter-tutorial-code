package game.adapters.access;

import game.util.GameAdapterFactory;

/**
 * Creates access adapters for game model instances.
 */
public class AccessAdapterFactory extends GameAdapterFactory {

	@Override
	public BoardAccess createBoardAdapter() {
		return new BoardAccess();
	}

	@Override
	public FieldAccess createFieldAdapter() {
		return new FieldAccess();
	}
}
