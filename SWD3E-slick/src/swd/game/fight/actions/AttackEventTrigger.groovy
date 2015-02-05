package swd.game.fight.actions

import swd.game.graphics.fight.FightRole
import swd.utils.Cache;
class AttackEventTrigger extends EventTrigger{

	public FightRole target;
	public FightAttackAction action;
	public int lastFrame=-1;
	public String[] triggerFrames;
	
	public void update()
	{
		int currentFrame=action.getCurrentAnimationFrame();
		if(currentFrame==lastFrame)
		{
			return;
		}
		else if(currentFrame==lastFrame+1)
		{
			lastFrame++;
			if(lastFrame.toString() in triggerFrames)
			{
				target.startAction(new FightAnimationAction(target,target.getAnimation("hurt")));
				target.addAction(new FightAnimationAction(target,target.getAnimation("stand")).setLoop(true));
				
				
				
			}
			
			
			if(lastFrame.toString().equals(triggerFrames[triggerFrames.length-1]))
			{
				this.end=true;
			}
		}
	}
	
	public AttackEventTrigger(FightAttackAction action,FightRole target,String[] triggerFrames)
	{
		this.action=action;
		this.target=target;
		this.triggerFrames=triggerFrames;
	}
}
