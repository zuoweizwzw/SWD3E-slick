package swd.game.actions

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;
import swd.utils.Cache;
import swd.utils.Mappings;
import swd.game.action.Action;
import swd.game.graphics.SceneActor;

class SceneActorStandAction extends Action{

	SceneActor actor;
	int direction;
	@Override
	public void act(GameContainer container, StateBasedGame game, int delta) {
		// TODO Auto-generated method stub
		if(this.status==0)
		{
			this.status=1;
			this.actor.setAnimation(Cache.sceneActorAnis.get(actor.roleID+"/stand_"+Mappings.getDirectionNameByInt(direction)));
			this.status=2;
		}
	}
	public SceneActorStandAction(SceneActor actor,int direction)
	{
		this.actor=actor;
		this.direction=direction;
	}

}
