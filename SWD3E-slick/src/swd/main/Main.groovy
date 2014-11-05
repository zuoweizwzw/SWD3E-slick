package swd.main

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame
import org.newdawn.slick.tests.GUITest;
import swd.states.SWDState
import swd.states.SceneState
import swd.utils.FontLoader;

class Main extends StateBasedGame{

	static main(args) {
		AppGameContainer container = new AppGameContainer(new Main());
		container.setTargetFrameRate(200);
		container.setDisplayMode(640,480,false);
		
		initApp();
		container.start();
	}

	@Override
	public void initStatesList(GameContainer container) throws SlickException {
		// TODO Auto-generated method stub
		this.addState(new SceneState());
	}
	public Main()
	{
		super("SWD3E");
	}
	
	static void initApp()
	{
		FontLoader.loadFont();
	}

}
