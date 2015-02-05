package swd.game.fight.actions;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

import swd.game.action.Action;
import swd.game.graphics.fight.FightRole;
import swd.graphics.Animation;

public class FightAnimationAction extends Action{

	FightRole fightRole;
	Animation animation;
	boolean loop=false;
	@Override
	public void act(GameContainer container, StateBasedGame game, int delta) {
		// TODO Auto-generated method stub
		if(status==0)
		{
			this.fightRole.setAnimation(animation);
			animation.reset();
			animation.setLoop(loop);
			animation.setAutoUpdate(false);
			status=1;
			
		}
		if(status==1)
		{
			if(loop)
			{
				
			}
			else
			{
				if(animation.isStopped())
			{
				this.status=2;
			}
			}
			animation.update(delta);
		}
	}
	
	public FightAnimationAction(FightRole fightRole, Animation animation) {
		// TODO Auto-generated constructor stub
		this.animation=animation;
		this.fightRole=fightRole;
	}
	
	public FightAnimationAction setLoop(boolean loop)
	{
		this.loop=loop;
		return this;
	}

}
