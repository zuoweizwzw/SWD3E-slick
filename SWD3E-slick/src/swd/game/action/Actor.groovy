package swd.game.action

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Vector2f
import org.newdawn.slick.state.StateBasedGame;

public abstract class Actor {

	SequenceAction rootAction=new Sequence();
	
	Actor parent;
	private String name="";
	public Vector2f location=new Vector2f();
	
	public void addAction(Action action)
	{
		if(rootAction.status==2) rootAction.status=0;
		rootAction.addAction(action);
	}
	
	//删除所有动作并开始新的动作
	public void startAction(Action action)
	{
		rootAction.startAction(action);
	}
	
	public ArrayList<Action> getActions()
	{
		return rootAction.actions;
	}
	
	public void addActions(Action... actions)
	{
		this.rootAction.addActions(actions);
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
	
	public String getName()
	{
		return this.name;
	}
	
	public void setLocation(float x, float y)
	{
		this.location.set(x, y);
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
	public void removeAction(int i)
	{
		this.rootAction.actions.remove(i);
	}
	
	public void move(float x,float y)
	{
		this.location.add(x, y);
	}
	
	public Vector2f getScreenLocation(Vector2f vec)
	{
		if(parent!=null)
		{
			return parent.getScreenLocation().copy().add(new Vector2f(vec.x,vec.y));
		}
		else return new Vector2f(vec.x,vec.y);
	}
}
