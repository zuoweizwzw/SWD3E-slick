package swd.states

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState
import org.newdawn.slick.state.StateBasedGame;
import swd.game.action.SequenceAction
import swd.graphics.Sprites
import swd.graphics.map.SceneMap
import swd.gui.GUI
import swd.utils.FontLoader;
abstract class  SWDState extends BasicGameState{

	Sprites sprites=new Sprites();
	GUI gui=new GUI();
	SequenceAction rootAction=new Sequence();
	@Override
	public void init(GameContainer container, StateBasedGame game)
	throws SlickException {
		// TODO Auto-generated method stub
	}

	
	
	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
	throws SlickException {
		// TODO Auto-generated method stub

		sprites.render(container, game, g);
		gui.render(container, game, g);

	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
	throws SlickException {

		this.rootAction.act(container,game,delta);
		sprites.act(container, game, delta);
		gui.act(container, game, delta);
		FontLoader.update();
	}

	
}
