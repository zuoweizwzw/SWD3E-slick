package swd.graphics

import org.newdawn.slick.Color;
import org.newdawn.slick.Image

class FrameItem {

	public boolean main;
	public Image img;
	public float offsetX;
	public float offsetY;
	public float width=-1;
	public float height=-1;
	public void draw(float x,float y,float width,float height, Color col)
	{
		img.draw(x+offsetX, y+offsetY, width, height, col);
		
		
	}
	public void draw(float x,float y, Color col)
	{
		if(width==-1) width=img.getWidth();
		if(height==-1) height=img.getHeight();
		img.draw((int)(x+offsetX), (int)(y+offsetY), width,height, col);
		
	}
}
