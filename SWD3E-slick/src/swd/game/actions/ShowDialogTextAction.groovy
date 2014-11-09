package swd.game.actions

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

import swd.game.action.Action
import swd.gui.scene.TextBox

class ShowDialogTextAction extends Action{

	StringBuffer text;
	String speakerName="";
	TextBox textBox;
	StringBuffer displayText;
	int count=0;
	@Override
	public void act(GameContainer container, StateBasedGame game, int delta) {
		// TODO Auto-generated method stub
		if(status==0)
		{
			count=0;
			textBox.clear();
			displayText=new StringBuffer("[FF0000FF]"+speakerName+":\n");
			
			this.status=1;
		}
		if(status==1)
		{
			if(count<=50)
			{
				count+=delta;
				return;
			}
			else
			{
				char c=text.charAt(0);
				if(c=='[')
				{
					String colorDes=text.substring(0, 11);
					displayText.append(colorDes);
					text.delete(0, 11);
					textBox.setText(displayText.toString());
					count=0;
				}
				else
				{
				displayText.append(c);
				textBox.setText(displayText.toString());
				text.deleteCharAt(0);
				count=0;
				}
				
				if(text.size()==0)
				{
					status=2;
				}
			}
			
		}
	}
	public ShowDialogTextAction(TextBox textBox,String speakerName,String text)
	{
		this.textBox=textBox;
		this.speakerName=speakerName;
		this.text=new StringBuffer(text);
	} 
	
	

}
