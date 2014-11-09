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
		img
		
	}
	public void draw(float x,float y, Color col)
	{
		img.draw((int)(x+offsetX), (int)(y+offsetY), col);
		
	}
}
