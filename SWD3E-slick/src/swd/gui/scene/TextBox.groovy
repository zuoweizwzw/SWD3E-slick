package swd.gui.scene

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

import swd.gui.Paper
import swd.utils.FontLoader
import org.newdawn.slick.Color;
class TextBox extends Paper{

	String text="";
	Color color=Color.red;
	public void clear() {
		this.text="";
	}

	@Override
	public void customerRender(GameContainer container, StateBasedGame game,
			Graphics g) {
		// TODO Auto-generated method stub
		FontLoader.font24.drawStringWithColorControlled((int)(getX()),(int)( getY()), text);
		
		super.customerRender(container, game, g);
	}
			
			public void setText(String text)
			{
				this.text=text;
			}
			public void setColor(Color color)
			{
				this.color=color;
			}
}
