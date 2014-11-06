package swd.game.actions

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.geom.Vector2f
import org.newdawn.slick.state.StateBasedGame;

import swd.game.action.Action;
import swd.game.graphics.SceneActor;
import swd.states.SceneState;
import swd.utils.Cache;
import swd.utils.Mappings;
class SceneActorWalkAction extends Action{

	SceneActor actor;
	SceneState state;
	public int direction;
	public boolean stop=false;
	public Vector2f delta=new Vector2f();
	@Override
	public void act(GameContainer container, StateBasedGame game, int delta) {
		// TODO Auto-generated method stub
		if(stop) this.status=2;
		if(this.status==0)
		{
			this.status=1;
			println((actor.roleID+"/walk_"+Mappings.getDirectionNameByInt(direction)));
			this.actor.setAnimation(Cache.sceneActorAnis.get(actor.roleID+"/walk_"+Mappings.getDirectionNameByInt(direction)));
		}
		if(this.status==1)
		{
			Vector2f unit=Mappings.getDirectionVectorByDirection(direction);
			this.actor.move((float)unit.x/10, (float)unit.y/10);
		}
	}

	public SceneActorWalkAction(SceneActor actor, SceneState state,int direction)
	{
		this.actor=actor;
		this.state=state;
		this.direction=direction
	}
}
