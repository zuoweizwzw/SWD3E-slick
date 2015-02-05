package swd.game.fight.actions

import swd.game.graphics.fight.FightRole

abstract class EventTrigger {

	public boolean end=false;
	public abstract void update();
	
}
