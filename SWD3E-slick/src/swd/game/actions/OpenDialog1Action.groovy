package swd.game.actions

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

import swd.game.action.Action
import swd.gui.scene.Dialog1

class OpenDialog1Action extends Action{

	Dialog1 dialog;
	@Override
	public void act(GameContainer container, StateBasedGame game, int delta) {
		// TODO Auto-generated method stub
		if(status==0)
		{
			dialog.background.size.x=0;
			dialog.visible=true;
			status=1;
		}
		if(status==1)
		{
			dialog.background.size.x+=15;
		}
		if(dialog.background.size.x>=640)
		{
			dialog.background.size.x=640;
			status==2;
		}
	}
	
	public OpenDialog1Action(Dialog1 dialog)
	{
		this.dialog=dialog;
	}

}
