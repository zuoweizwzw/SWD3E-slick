package swd.game.graphics.fight

import swd.game.fight.RoleModel
import swd.graphics.Sprite
import swd.utils.Cache

class FightRole extends Sprite{

	public RoleModel roleModel;
	public int index;
	public FightRole(RoleModel model) {
		// TODO Auto-generated constructor stub
		this.roleModel=roleModel;
		this.setAnimation(Cache.fightRoles.get(model.resCode+"/fight/stand_left"));
		
	}
}
