package swd.game.actions

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

import swd.game.action.Action
import swd.graphics.AnimatedActor
import swd.graphics.Animation
import swd.graphics.Sprite

class AnimationAction extends Action {

	AnimatedActor actor;
	Animation animation;
	@Override
	public void act(GameContainer container, StateBasedGame game, int delta) {
		// TODO Auto-generated method stub
		
	}
	
	public AnimationAction(Animation animation, AnimatedActor actor)
	{
		this.actor=actor;
		this.animation=animation;
	}

}
