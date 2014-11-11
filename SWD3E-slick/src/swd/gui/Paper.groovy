package swd.gui

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Vector2f
import org.newdawn.slick.state.StateBasedGame;

import swd.game.action.Actor
import swd.game.action.Group
import swd.graphics.Animation
import org.newdawn.slick.Color;

class Paper extends Group{

	public Animation animation;
	public Vector2f size=new Vector2f();
	public boolean visible=true;
	public void update(GameContainer container, StateBasedGame game, int delta)
	{
		if(animation!=null) animation.update(delta);
		this.act(container,game,delta);
	}
	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) {
		// TODO Auto-generated method stub
		if(!visible) return;
		
		if(animation!=null) 
		{
			animation.draw(this.location.x, this.location.y, Color.white);
		}
		customerRender(container,game,g);
		super.render(container, game, g);
		
	}
	
	public void customerRender(GameContainer container, StateBasedGame game, Graphics g)
	{
		
	}
	
	public Paper(String resPath)
	{
		this.setAnimation(new Animation(resPath));
	}
	
	public Paper()
	{
		
	}
	
	public void setAnimation(Animation animation)
	{
		this.animation=animation;
		if(animation.frames.size()>0)
		{
			this.size.x=animation.frames.get(0).frameItems.get(0).img.getWidth();
			this.size.y=animation.frames.get(0).frameItems.get(0).img.getHeight();
		}
	}
	
	public Animation getAnimation()
	{
		return this.animation;
	}
	
	
}
