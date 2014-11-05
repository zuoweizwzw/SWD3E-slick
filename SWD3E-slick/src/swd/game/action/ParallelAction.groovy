package swd.game.action

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

class ParallelAction extends Action{

	public ArrayList<Action> actions=new ArrayList<Action>();
	@Override
	public void act(GameContainer container, StateBasedGame game, int delta) {
		// TODO Auto-generated method stub
		if(this.status==0) this.status=1;
		
	}

}
