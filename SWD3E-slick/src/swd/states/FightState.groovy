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
import swd.game.fight.actions.FightActionsMng
import swd.game.fight.actions.FightAnimationAction
import swd.game.fight.actions.FightAttackAction
import swd.game.fight.actions.FightBackAction
import swd.game.fight.actions.FightMoveAction
import swd.game.graphics.fight.Battle
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
	Battle battle;
	FightActionsMng mng;
	
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
		battle=new Battle();		
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
			this.sprites.addActor(fightRole);
			this.battle.addAlly(fightRole);
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
				Cache.fightRoles.get( fightRole.roleModel.resCode+"/fight/stand_right")).setLoop(true));
			this.sprites.addActor(fightRole);
			this.battle.addEnemy(fightRole);
		}
		
	}
	
	public FightState(FightModel model)
	{
		this.model=model;
		fightShell=new SWDShell();
		
		mng=new  FightActionsMng(this);
		fightShell.setVariable("actions", new FightActionScriptEngine());
	}
	
	@Override
	public void keyPressed(int key, char c) {
		// TODO Auto-generated method stub
		FightRole source=(FightRole)this.battle.getAllyByName("001");
		
		FightRole target=(FightRole)this.battle.getEnemyByName("003");
		
		mng.playAttack(source, target, source.roleModel.skills.get("001/attack1"));
	}

	@Override
	public void customerUpdate(GameContainer container, StateBasedGame game,
			int delta) {
		// TODO Auto-generated method stub
		this.mng.update();
	}
}
