package swd.game.action

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

class Group extends Actor{

	public ArrayList<Actor> children=new ArrayList<Actor>();
	public void addActor(Actor actor)
	{
		this.children.add(actor);
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
		children.each {
			it.render(container, game, g);
		}
	}
	
}
