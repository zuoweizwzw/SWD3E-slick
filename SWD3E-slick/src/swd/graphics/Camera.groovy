package swd.graphics

import org.newdawn.slick.geom.Vector2f
import swd.states.SWDState

class Camera {

	public Vector2f location=new Vector2f();
	public void update(SWDState state)
	{
		state.sprites.setX(-location.x);
		state.sprites.setY(-location.y);
	}
	public void move(float x,float y)
	{
		this.location.add(x,y);
	}
}
