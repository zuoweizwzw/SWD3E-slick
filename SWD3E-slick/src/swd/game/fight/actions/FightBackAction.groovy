package swd.game.fight.actions;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import swd.game.action.Action;
import swd.game.graphics.fight.FightRole
import swd.graphics.Animation

public class FightBackAction extends Action{

	public FightRole source;
	public Animation animation;
	private Vector2f distance;
	private Vector2f unit;
	private step=0;
	
	@Override
	public void act(GameContainer container, StateBasedGame game, int delta) {
		// TODO Auto-generated method stub
		if(status==0)
		{
			this.source.setAnimation(animation);
			animation.reset();
			step=animation.getTotalDuration();
			animation.setAutoUpdate(false);
			int orignalx;
			int targetx;
			orignalx=source.getX();
			if(source.direction==0)
			{
				targetx=520;
			}
			else
			{
				targetx=120;
			}
			int orignaly;
			int targety;
			orignaly=source.getY();
			targety=180+source.index*100;
			distance=new Vector2f(targetx-orignalx,targety-orignaly);
			unit=distance.divNew((float)(step));
			status=1;
			
		}
		if(status==1)
		{
			step-=delta;
			if(step<=0)
			{
				if(source.direction==0)
				{
					source.setLocation(520, 180+source.index*100);
				}
				else
				{
					source.setLocation(120, 180+source.index*100);
				}
				status=2;
				return;
			}
			
			animation.update(delta);
			source.move(unit.mulNew(delta).x, unit.mulNew(delta).y);
			
		}
	}
	
	public FightBackAction(FightRole source, Animation animation)
	{
		this.source=source;
		this.animation=animation;
	}

}
