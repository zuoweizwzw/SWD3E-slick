package swd.game.actions

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

import swd.game.action.Action
import swd.gui.scene.Dialog1;

class CloseDialog1Action extends Action{

	Dialog1 dialog;
	@Override
	public void act(GameContainer container, StateBasedGame game, int delta) {
		// TODO Auto-generated method stub
		if(status==0)
		{
			dialog.textBox.clear();
			status=1;
		}
		if(status==1)
		{
			dialog.background.size.x-=16;
			dialog.face.setX((float)(dialog.face.getX()-3.5f));
			if(dialog.background.size.x<=0)
			{
				dialog.background.size.x=0;
				dialog.face.setX(-160);
				dialog.visible=true;
				status=2;
				return;
			}
		}
	}
	
	public CloseDialog1Action(Dialog1 dialog)
	{
		this.dialog=dialog;
	}

}
