package swd.states

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import swd.game.fight.FightModel
import swd.game.fight.RoleModel
import swd.game.fight.actions.FightMoveAction
import swd.game.graphics.fight.FightMap
import swd.game.graphics.fight.FightRole
import swd.gui.Paper
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
			fightRole.index=i;
			fightRole.direction=0;
			fightRole.setLocation(520,180+i*100);
			FightStatePanel panel=(FightStatePanel)Cache.controls.get("fightstateframe").findActorByName("fightstatepanel"+(i+1));
			panel.initData(model);
			this.sprites.addActor(fightRole);
			i++;
		}
		i=0
		
		for(RoleModel model: this.model.enemies)
		{
			FightRole fightRole=new FightRole(model);
			fightRole.index=i;
			fightRole.direction=1;
			fightRole.setLocation(120, 180+i*100);
			this.sprites.addActor(fightRole);
		}
	}
	
	public FightState(FightModel model)
	{
		this.model=model;
	}
	
	@Override
	public void keyPressed(int key, char c) {
		// TODO Auto-generated method stub
		FightRole source=(FightRole)this.sprites.getActor(1);
		FightRole target=(FightRole)this.sprites.getActor(3);
		source.addAction(new FightMoveAction(source,
			Cache.fightRoles.get( source.roleModel.resCode+"/fight/move_left"),
			target));
	}
}
