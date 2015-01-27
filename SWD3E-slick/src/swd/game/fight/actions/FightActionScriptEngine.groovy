package swd.game.fight.actions

import swd.game.graphics.fight.FightRole;
import swd.utils.Cache;

class FightActionScriptEngine {

	public void walk(FightRole source, FightRole target)
	{
		source.addAction(new FightMoveAction(source,
			Cache.fightRoles.get( source.roleModel.resCode+"/fight/move_left"),
			target));
	}
	public void blink()
	{
		
	}
}
