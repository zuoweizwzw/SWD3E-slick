package swd.gui.scene

import org.newdawn.slick.Color
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

import swd.gui.Paper

class ColorPaper extends Paper {

	public Color color;
	@Override
	public void customerRender(GameContainer container, StateBasedGame game, Graphics g) {
		// TODO Auto-generated method stub
		
		Color old=g.getColor();
		g.setColor(color);
		g.fillRect(this.getX(), this.getY(), this.size.x, this.size.y);
		g.setColor(old);
		
	}
	
	public ColorPaper(Color color)
	{
		this.color=color;
	}
	
}
