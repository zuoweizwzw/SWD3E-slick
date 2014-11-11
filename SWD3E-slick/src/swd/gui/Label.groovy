package swd.gui

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.font.effects.OutlineEffect
import org.newdawn.slick.state.StateBasedGame;
import java.awt.Color;

import swd.utils.FontLoader;

class Label extends Paper{

	String text="";
	public void setText(String text) {
		this.text=text;
	}
	@Override
	public void customerRender(GameContainer container, StateBasedGame game,
			Graphics g) {
		
		OutlineEffect effect=new OutlineEffect(2,java.awt.Color.black);
		FontLoader.font18.font .getEffects().add(effect);
		println(FontLoader.font18.font.getEffects().size());
		FontLoader.font18.drawStringWithColorControlled(getX(), getY(), text);
		FontLoader.font18.font.getEffects().remove(effect);
		
		println(FontLoader.font18.font.getEffects().size());
	}
			
	public void getddd(){
		
	}
}
