package swd.game.fight.actions

import swd.game.fight.MagicModel
import swd.game.fight.SkillModel
import swd.game.graphics.fight.FightRole
import swd.states.FightState
import swd.utils.Cache;

class FightActionsMng {

	public FightState fightState;
	public ArrayList<EventTrigger> triggers=new ArrayList<EventTrigger>();
	public void playAttack(FightRole source, FightRole target, SkillModel skill)
	{
		source.startAction(new FightMoveAction(source,source.getAnimation("move"),
			target));
		FightAttackAction attack=new FightAttackAction(source,source.getAnimation("attack1"),
			target);
		source.addAction(attack);
		source.addAction(new FightBackAction(source,source.getAnimation("back")));
		source.addAction(new FightAnimationAction(source,source.getAnimation("stand")).setLoop(true));
		AttackEventTrigger trigger=new AttackEventTrigger(attack,target,skill.hitframes);
		this.triggers.add(trigger);
	}
	
	public void playCast(FightRole source, FightRole target, MagicModel magic)
	{
		
	}
	
	public void update()
	{
		for(int i=0;i<triggers.size();i++)
		{
			EventTrigger trigger=triggers.get(i);
			if(!trigger.end)
			{
				trigger.update();
			}
			else
			{
				triggers.remove(trigger);
			}
		}
	}
	
	public FightActionsMng(FightState fightState)
	{
		this.fightState=fightState;
	}
}
