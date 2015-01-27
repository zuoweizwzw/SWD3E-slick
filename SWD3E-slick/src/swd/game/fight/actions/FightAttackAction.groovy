package swd.game.fight.actions;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

import swd.game.action.Action;
import swd.game.graphics.fight.FightRole;
import swd.graphics.Animation;

public class FightAttackAction extends Action {

	FightRole fightRole;
	FightRole target;
	Animation animation;
	@Override
	public void act(GameContainer container, StateBasedGame game, int delta) {
		// TODO Auto-generated method stub
		if(status==0)
		{
			this.fightRole.setAnimation(animation);
			animation.reset();
			animation.setLoop(false);
			animation.setAutoUpdate(false);
			status=1;
		}
		if(status==1)
		{
			if(animation.getCurrentFrameIndex()==animation.getFrames().size()-1)
			{
				this.status=2;
			}
			animation.update(delta);
		}
	}
	
	public FightAttackAction(FightRole fightRole, Animation animation, FightRole target)
	{
		this.fightRole=fightRole;
		this.target=target;
		this.animation=animation;
	}

}
