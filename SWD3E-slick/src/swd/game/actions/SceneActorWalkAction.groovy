package swd.game.actions

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

import swd.game.action.Action
import swd.game.graphics.SceneActor
import swd.states.SceneState

class SceneActorWalkAction extends Action{

	SceneActor actor;
	SceneState state;
	public int direction;
	@Override
	public void act(GameContainer container, StateBasedGame game, int delta) {
		// TODO Auto-generated method stub
		println("zuowei");
	}

	public SceneActorWalkAction(SceneActor actor, SceneState state,int direction)
	{
		this.actor=actor;
		this.state=state;
		this.direction=direction
	}
}
