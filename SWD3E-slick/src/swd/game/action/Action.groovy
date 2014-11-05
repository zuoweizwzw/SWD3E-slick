package swd.game.action

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

abstract class Action {

	public int status=0;
	public abstract void act(GameContainer container, StateBasedGame game, int delta);
	public void start()
	{
		status=1;
	}
}
