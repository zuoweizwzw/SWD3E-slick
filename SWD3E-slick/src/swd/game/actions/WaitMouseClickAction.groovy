package swd.game.actions

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.MouseListener
import org.newdawn.slick.state.StateBasedGame;

import swd.game.action.Action
import swd.utils.Global

class WaitMouseClickAction extends Action implements MouseListener{

	boolean mouseClicked=false;
	@Override
	public void act(GameContainer container, StateBasedGame game, int delta) {
		// TODO Auto-generated method stub
		if(status==0)
		{
			Global.game.getContainer().getInput().addMouseListener(this);
			this.status=1;
		}
		if(status==1)
		{
			if(mouseClicked) 
			{
				this.status=2;
				Global.game.getContainer().getInput().removeMouseListener(this);
			}
		}
	}
	@Override
	public void setInput(Input input) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean isAcceptingInput() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public void inputEnded() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void inputStarted() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseWheelMoved(int change) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseClicked(int button, int x, int y, int clickCount) {
		// TODO Auto-generated method stub
		this.mouseClicked=true;
	}
	@Override
	public void mousePressed(int button, int x, int y) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(int button, int x, int y) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseMoved(int oldx, int oldy, int newx, int newy) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseDragged(int oldx, int oldy, int newx, int newy) {
		// TODO Auto-generated method stub
		
	}

}
