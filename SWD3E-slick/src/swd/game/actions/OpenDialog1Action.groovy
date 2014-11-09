package swd.game.actions

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

import swd.game.action.Action
import swd.graphics.Animation
import swd.gui.Paper
import swd.gui.scene.Dialog1
import swd.utils.FaceLoader;

class OpenDialog1Action extends Action{

	Dialog1 dialog;
	@Override
	public void act(GameContainer container, StateBasedGame game, int delta) {
		// TODO Auto-generated method stub
		if(status==0)
		{
			dialog.background.size.x=0;
			
			dialog.visible=true;
			dialog.face.setX((float)(0-dialog.face.size.x));
			status=1;
		}
		if(status==1)
		{
			dialog.background.size.x+=16;
			dialog.face.setX((float)(dialog.face.getX()+3.5f));
		}
		if(dialog.background.size.x>=640)
		{
			dialog.background.size.x=640;
			dialog.face.setX(-10);
			status=2;
		}
	}
	
	public OpenDialog1Action(Dialog1 dialog, String faceRes)
	{
		this.dialog=dialog;
		this.dialog.face.setAnimation(FaceLoader.faces.get(faceRes));
		
	}

}
