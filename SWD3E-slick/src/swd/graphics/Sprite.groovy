package swd.graphics

import org.newdawn.slick.Color
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f
import org.newdawn.slick.state.StateBasedGame;
import swd.game.action.Actor

class Sprite extends Actor implements AnimatedActor{
	private Animation animation;
	public Vector2f size=new Vector2f();
	public void update(GameContainer container, StateBasedGame game, int delta)
	{
		if(animation!=null) animation.update(delta);
		this.act(container,game,delta);
	}
	
	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) {
		// TODO Auto-generated method stub
		super.render(container, game, g);
		if(animation!=null) animation.draw(this.location.x, this.location.y, Color.white);
	}
	
	public Sprite(String resPath,boolean res)
	{
		this.animation=new Animation(resPath);
	}
	
	public Sprite()
	{
		
	}
	
	public void setAnimation(Animation animation)
	{
		this.animation=animation;
	}
	
	public Vector2f getCenterPoint()
	{
		if(animation!=null)
		{
			return animation.centerPoint.copy().add(animation.mainOffset).copy().add(new Vector2f(this.getX(),this.getY()));
		}
	}
	
	public Animation getAnimation()
	{
		return this.animation;
	}

	public int getWidth()
	{
		if(this.animation!=null)
		{
			return animation.getFrames().get(0).frameItems.get(0).img.getWidth();
		}
	}
	
	public int getHeight()
	{
		if(this.animation!=null)
		{
			return animation.getFrames().get(0).frameItems.get(0).img.getHeight();
		}
	}
	
	
	
}
