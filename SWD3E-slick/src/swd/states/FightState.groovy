package swd.states

import org.codehaus.groovy.tools.shell.Shell
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import swd.game.action.Group
import swd.game.fight.FightModel
import swd.game.fight.RoleModel
import swd.game.fight.actions.FightActionScriptEngine
import swd.game.fight.actions.FightAnimationAction
import swd.game.fight.actions.FightAttackAction
import swd.game.fight.actions.FightMoveAction
import swd.game.graphics.fight.FightMap
import swd.game.graphics.fight.FightRole
import swd.gui.Paper
import swd.gui.fight.FightStatePanel
import swd.script.SWDShell
import swd.utils.GUILoader
import swd.utils.Cache;
class FightState extends SWDState {

	FightModel model;
	SWDShell fightShell;
	
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
			fightRole.origin.set(520,180+i*100);
			fightRole.setLocation(520,180+i*100);
			fightRole.addAction(new FightAnimationAction(fightRole,
				Cache.fightRoles.get( fightRole.roleModel.resCode+"/fight/prepare_left")));
			fightRole.addAction(new FightAnimationAction(fightRole,
				Cache.fightRoles.get( fightRole.roleModel.resCode+"/fight/stand_left")).setLoop(true));
			FightStatePanel panel=(FightStatePanel)Cache.controls.get("fightstateframe").findActorByName("fightstatepanel"+(i+1));
			panel.initData(model);
//			this.sprites.addActor(fightRole);
			this.allies.addActor(fightRole);
			i++;
		}
		i=0
		
		for(RoleModel model: this.model.enemies)
		{
			FightRole fightRole=new FightRole(model);
			fightRole.index=i;
			fightRole.direction=1;
			fightRole.origin.set(120, 180+i*100);
			fightRole.setLocation(120, 180+i*100);
			fightRole.addAction(new FightAnimationAction(fightRole,
				Cache.fightRoles.get( fightRole.roleModel.resCode+"/fight/stand_left")).setLoop(true));
//			this.sprites.addActor(fightRole);
			this.enemies.addActor(fightRole);
		}
		this.sprites.addActor(allies);
		this.sprites.addActor(enemies);
	}
	
	public FightState(FightModel model)
	{
		this.model=model;
		fightShell=new SWDShell();
		fightShell.setVariable("actions", new FightActionScriptEngine());
	}
	
	@Override
	public void keyPressed(int key, char c) {
		// TODO Auto-generated method stub
		FightRole source=(FightRole)this.allies.getActor(0);
		
		FightRole target=(FightRole)this.enemies.getActor(0);
		
//		fightShell.setVariable("source", source);
//		fightShell.setVariable("target", target);
//		
		source.startAction(new FightMoveAction(source,
			Cache.fightRoles.get( source.roleModel.resCode+"/fight/move_left"),
			target));
		source.addAction(new FightAttackAction(source,
			Cache.fightRoles.get( source.roleModel.resCode+"/fight/attack1_left"),
			target));
//		fightShell.execute(Cache.scripts.get(source.roleModel.resCode+"/fight/script/move"));
	}
}
