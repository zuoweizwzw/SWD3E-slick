package swd.states

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import swd.game.fight.FightModel
import swd.game.graphics.fight.FightMap
import swd.utils.GUILoader
import swd.utils.Cache;
class FightState extends SWDState {

	FightModel model;
	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 2;
	}
	
	@Override
	public void enter(GameContainer container, StateBasedGame game)
			throws SlickException {
		// TODO Auto-generated method stub
		init();
	}

	private void init()
	{
		
		this.gui.addActor(Cache.controls.get("fightstateframe"));
		this.sprites.addActor(new FightMap(this.model.fightMapResID));
	}
	
	public FightState(FightModel model)
	{
		this.model=model;
	}
	
}
