package swd.gui.fight

import swd.game.fight.RoleModel
import swd.graphics.Animation
import swd.gui.Label
import swd.gui.Paper

class FightStatePanel extends Paper{

	public void initData(RoleModel roleModel){
		
	Paper avatar=	this.findActorByName("avatar");
	avatar.setAnimation(new Animation(roleModel.fightAvatar));
	
	Paper p1=(Paper)this.findActorByName("hp_pro");
//	p1.getAnimation().getCurrentFrame().frameItems.get(0).img .texture.setRegionWidth(roleModel.hp*48/roleModel.hp_max);
	p1.getAnimation().getCurrentFrame().frameItems.get(0).width=roleModel.hp*48/roleModel.hp_max;
	Paper p2=(Paper)this.findActorByName("mp_pro");
//	p2.getAnimation().getCurrentFrame().frameItems.get(0).texture.setRegionWidth(roleModel.mp*48/roleModel.mp_max);
	p2.getAnimation().getCurrentFrame().frameItems.get(0).width=roleModel.mp*48/roleModel.mp_max;
	Paper p3=(Paper)this.findActorByName("energe_pro");
//	p3.getAnimation().getCurrentFrame().frameItems.get(0).texture.setRegionWidth(roleModel.energe*48/roleModel.energe_max);
	p3.getAnimation().getCurrentFrame().frameItems.get(0).width=roleModel.energe*48/roleModel.energe_max;
	Label name=(Label)this.findActorByName("name");
	name.setText(roleModel.name);
	
	}
}
