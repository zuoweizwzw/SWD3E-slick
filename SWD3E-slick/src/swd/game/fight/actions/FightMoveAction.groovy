package swd.game.fight.actions

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.geom.Vector2f
import org.newdawn.slick.state.StateBasedGame;

import swd.game.action.Action
import swd.game.graphics.fight.FightRole
import swd.graphics.Animation

class FightMoveAction extends Action{

	FightRole fightRole;
	FightRole target;
	Animation animation;
	private Vector2f distance;
	private Vector2f unit;
	private step=0;
	@Override
	public void act(GameContainer container, StateBasedGame game, int delta) {
		// TODO Auto-generated method stub
		if(status==0)
		{
			this.fightRole.setAnimation(animation);
			animation.reset();
			step=animation.getTotalDuration();
			animation.setAutoUpdate(false);
			int orignalx=this.fightRole.getX()+ this.fightRole.getAnimation().userData.get("leftAlign");
			int targetx=target.getX()-this.target.getAnimation().userData.get("leftAlign");
			int deltay=target.getY()-fightRole.getY();
			distance=new Vector2f(targetx-orignalx,deltay);
			unit=distance.divNew((float)(step-5));
			println(fightRole.getAnimation());
			status=1;
		}
		if(status==1)
		{
			step-=delta;
			if(step<=0) 
			{
				status=2;
				return;
			}
			
			animation.update(delta);
			fightRole.move(unit.mulNew(delta).x, unit.mulNew(delta).y);
			
		}
	}
	
	public FightMoveAction(FightRole fightRole, Animation animation, FightRole target)
	{
		this.fightRole=fightRole;
		this.target=target;
		this.animation=animation;
	}
	
	

}
