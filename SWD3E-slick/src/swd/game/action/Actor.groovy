package swd.game.action

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Vector2f
import org.newdawn.slick.state.StateBasedGame;

abstract class Actor {

	SequenceAction rootAction=new Sequence();
	Actor parent;
	private String name="";
	protected Vector2f location=new Vector2f();
	public void addAction(Action action)
	{
		if(rootAction.status==2) rootAction.status=0;
		rootAction.addAction(action);
	}
	public void act(GameContainer container, StateBasedGame game, int delta)
	{
		if(rootAction!=null) rootAction.act(container, game,delta);
		
	}
	public void render(GameContainer container, StateBasedGame game, Graphics g)
	{
		
	}
	public void setX(float x)
	{
		this.location.x=x;
	}
	public void setY(float y)
	{
		this.location.y=y;
	}
	public void setName(String name)
	{
		this.name=name;
	}
	public float getX()
	{
		return this.location.x;
	}
	public float getY()
	{
		return this.location.y;
	}
	public void setParent(Actor parent){
		this.parent=parent;
	}
	
	public Vector2f getScreenLocation()
	{
		if(parent!=null)
		{
			return parent.getScreenLocation().copy().add(new Vector2f(getX(),getY()));
		}
		else return new Vector2f(getX(),getY());
	}
}
