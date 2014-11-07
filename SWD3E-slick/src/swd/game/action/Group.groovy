package swd.game.action

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

class Group extends Actor{

	public ArrayList<Actor> children=new ArrayList<Actor>();
	public void addActor(Actor actor)
	{
		this.children.add(actor);
		actor.setParent(this);
	}
	public void act(GameContainer container, StateBasedGame game, int delta)
	{
		super.act(container, game, delta);
		children.each {
			it.act(container, game, delta);
		}
	}
	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) {
		// TODO Auto-generated method stub
		super.render(container, game, g);
		g.translate(this.getX(), this.getY());
		children.each {
			it.render(container, game, g);
		}
		g.translate(-this.getX(), -this.getY());
			}
	
	public Actor getActor(int i)
	{
		return children.get(i);
	}
	
	public Actor findActorByName(String name)
	{
		for(Actor actor:children) {
			if(actor.getName().equals(name))
			{
				return actor;
			}
		}
		return null;
	}
	public Actor findActorByNameDeep(String name)
	{
		Actor target=null;
		for(Actor actor:children) {
			
			
			if(actor.getName().equals(name))
			{
				target=actor;
				return target;
			}
			
			if(actor instanceof Group)
			{
				Group group=(Group)actor;
				target= group.findActorByNameDeep(name);
				if(target!=null) return target;
			}
		}
		return target;
	}
	
}
