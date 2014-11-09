package swd.game.actions

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

import swd.game.action.Action
import swd.main.Main
import swd.states.FightState
import swd.states.SWDState
import swd.test.TestUtils
import swd.utils.Global;

class StartFightAction extends Action{

	
	@Override
	public void act(GameContainer container, StateBasedGame game, int delta) {
		// TODO Auto-generated method stub
		Global.game.addState(new FightState(TestUtils.generateFightModel()));
		Global.game.enterState(2);
		status=2;
	}

	public StartFightAction() {
		// TODO Auto-generated constructor stub
		
	}
}
