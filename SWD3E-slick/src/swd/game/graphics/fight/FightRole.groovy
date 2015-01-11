package swd.game.graphics.fight

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

import swd.game.fight.RoleModel
import swd.graphics.Sprite
import swd.utils.Cache

class FightRole extends Sprite{

	public RoleModel roleModel;
	public int index;
	public int direction=0;//0Ïò×ó,1ÏòÓÒ
	public FightRole(RoleModel model) {
		// TODO Auto-generated constructor stub
		this.roleModel=model;
		this.setAnimation(Cache.fightRoles.get(model.resCode+"/fight/stand_left"));
		
	}
	
	public int readCurrentLeftAlign()
	{
		if(getAnimation()!=null)
		{
			if(direction==0) return (Integer)getAnimation().userData.get("leftAlign");
			else if(direction==1) return -(Integer)getAnimation().userData.get("leftAlign")
		}
		else return 0;
	}
	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) {
		// TODO Auto-generated method stub
		super.render(container, game, g);
		if(direction==0)g.drawRect((float)(getX()+readCurrentLeftAlign()), 
			(float)(getY()+this.getAnimation().getFrames().get(0).frameItems.get(0).offsetY),
			 (float)(this.getWidth()+this.getAnimation().getFrames().get(0).frameItems.get(0).offsetX-readCurrentLeftAlign()),
			 this.getHeight());
		 else if(direction==1)
		 {
			 g.drawRect((float)(getX()+this.getAnimation().getFrames().get(0).frameItems.get(0).offsetX),
				 (float)(getY()+this.getAnimation().getFrames().get(0).frameItems.get(0).offsetY),
				  (float)(-this.getAnimation().getFrames().get(0).frameItems.get(0).offsetX+readCurrentLeftAlign()),
				  this.getHeight());
		 }
	}
}
