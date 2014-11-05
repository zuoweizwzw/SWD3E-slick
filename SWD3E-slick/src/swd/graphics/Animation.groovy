package swd.graphics

import java.util.ArrayList;

import org.lwjgl.Sys;
import org.newdawn.slick.Color;
import org.newdawn.slick.Image

class Animation {

	private ArrayList<Frame> frames = new ArrayList<Frame>();
	public int currentFrame=-1;
	private long nextChange = 0;
	private boolean stopped = false;
	private long lastUpdate;
	private boolean firstUpdate = true;
	private boolean autoUpdate = true;
	private boolean loop = true;
	
	public Animation()
	{
		
	}
	
	public Animation(String resPath)
	{
		Image img=new Image(resPath);
		FrameItem item=new FrameItem();
		item.img=img;
		Frame frame=new Frame();
		frame.duration=100;
		frame.frameItems.add(item);
		frames.add(frame);
		this.currentFrame=0;
	}
	
	private void nextFrame(long delta) {
		if (stopped) {
			return;
		}
		if (frames.size() == 0) {
			return;
		}
		
		nextChange -= delta;
		
		while (nextChange < 0 && (!stopped)) {
			
			if ((currentFrame == frames.size() - 1) && (!loop)) {
				stopped = true;
				break;
			}
			currentFrame = (currentFrame + 1) % frames.size();
			
			int realDuration = (int) (((Frame) frames.get(currentFrame)).duration);
			nextChange = nextChange + realDuration;
		}
	}
	
	public void draw(float x,float y,float width,float height, Color col) {
		if (frames.size() == 0) {
			return;
		}
		
		if (autoUpdate) {
			long now = getTime();
			long delta = now - lastUpdate;
			if (firstUpdate) {
				delta = 0;
				firstUpdate = false;
			}
			lastUpdate = now;
			nextFrame(delta);
		}
		
		Frame frame = (Frame) frames.get(currentFrame);
		frame.draw(x,y,width,height, col);
	}
	public void draw(float x,float y,Color col)
	{
		if (frames.size() == 0) {
			return;
		}
		
		if (autoUpdate) {
			long now = getTime();
			long delta = now - lastUpdate;
			if (firstUpdate) {
				delta = 0;
				firstUpdate = false;
			}
			lastUpdate = now;
			nextFrame(delta);
		}
		
		Frame frame = (Frame) frames.get(currentFrame);
		frame.draw(x,y, col);
	}
	
	public void update(long delta) {
		nextFrame(delta);
	}
	private long getTime() {
		return (Sys.getTime() * 1000) / Sys.getTimerResolution();
	}
	
	public int getWidth() {
		return ((Frame) frames.get(currentFrame)).getWidth();
	}
	
	public int getHeight() {
		return ((Frame) frames.get(currentFrame)).getHeight();
	}
}
