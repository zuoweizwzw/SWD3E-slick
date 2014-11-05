package swd.graphics

import org.newdawn.slick.Color;
import org.newdawn.slick.Image

class FrameItem {

	public boolean main;
	public Image img;
	public float offsetX;
	public float offsetY;
	public void draw(float x,float y,float width,float height, Color col)
	{
		img.draw(x+offsetX, y+offsetY, width, height, col);
		
	}
	public void draw(float x,float y, Color col)
	{
		img.draw((float)(x+offsetX), (float)(y+offsetY), col);
		
	}
}
