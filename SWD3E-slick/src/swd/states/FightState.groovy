package swd.states

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import swd.game.fight.FightModel
import swd.game.fight.RoleModel
import swd.game.graphics.fight.FightMap
import swd.game.graphics.fight.FightRole
import swd.gui.fight.FightStatePanel
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
		int i=0;
		for(RoleModel model:this.model.allies)
		{
			FightRole fightRole=new FightRole(model);
			fightRole.setLocation(200,200);
			FightStatePanel panel=(FightStatePanel)Cache.controls.get("fightstateframe").findActorByName("fightstatepanel"+(i+1));
			panel.initData(model);
			this.sprites.addActor(fightRole);
			i++;
		}
	}
	
	public FightState(FightModel model)
	{
		this.model=model;
	}
	
}
