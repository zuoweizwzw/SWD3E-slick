package swd.graphics

import org.newdawn.slick.Color;

class Frame {

	 public ArrayList<FrameItem> frameItems=new ArrayList<FrameItem>();
	 public int duration;
	 public void draw(float x,float y,float width,float height, Color col)
	 {
		 frameItems.each {
			 it.draw(x, y, width, height, col);
		 };
	 }
	 
	 public void draw(float x,float y,Color col)
	 {
		 frameItems.each {
			 it.draw(x, y,  col);
		 };
	 }
	 
	 public int getWidth()
	 {
		 return getMain().img.getWidth();
	 }
	 
	 public int getHeight()
	 {
		 return getMain().img.getHeight();
	 }
	 
	 public FrameItem getMain()
	 {
		 if(frameItems.size()==1) return frameItems.get(0);
		 else
		 {
			 
		 }
	 }
}
