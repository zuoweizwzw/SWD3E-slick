package swd.gui

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.font.Glyph
import org.newdawn.slick.font.GlyphPage
import org.newdawn.slick.font.effects.ColorEffect
import org.newdawn.slick.font.effects.Effect
import org.newdawn.slick.font.effects.OutlineEffect
import org.newdawn.slick.font.effects.OutlineWobbleEffect
import org.newdawn.slick.font.effects.OutlineZigzagEffect
import org.newdawn.slick.state.StateBasedGame;
import org.omg.CORBA.ORB;

import java.awt.Color;

import swd.utils.FontLoader;

class Label extends Paper{

	String text="";
	int i=0;
	public void setText(String text) {
		this.text=text;
	}
	@Override
	public void customerRender(GameContainer container, StateBasedGame game,
			Graphics g) {

		FontLoader.font18.drawString(getX(), getY(),"[F77D84FF]"+ text,
//			null
			new OutlineZigzagEffect(2,java.awt.Color.black)
				);

		
	}

	public void getddd(){
	}
}
