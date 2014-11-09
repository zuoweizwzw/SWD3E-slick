package swd.main

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tests.GUITest;
import swd.states.FightState
import swd.states.SWDState;
import swd.states.SceneState;
import swd.utils.Cache;
import swd.utils.FaceLoader;
import swd.utils.FightMapLoader
import swd.utils.FightRoleLoader
import swd.utils.FontLoader;
import swd.utils.Global;
import swd.utils.SceneActorLoader
import swd.utils.GUILoader;
class Main extends StateBasedGame{

	static main(args) {
		Main main=new Main();
		Global.game=main;
		AppGameContainer container = new AppGameContainer(main);
		container.setTargetFrameRate(200);
		container.setDisplayMode(640,480,false);
		
		
		container.start();
	}

	@Override
	public void initStatesList(GameContainer container) throws SlickException {
		// TODO Auto-generated method stub
		initApp();
		
		this.addState(new SceneState());
		this.addState(new FightState());
	}
	public Main()
	{
		super("SWD3E");
	}
	
	static void initApp()
	{
		FightMapLoader.loadFightMap("1-1");
		FightRoleLoader.loadFightRole("001");
		FontLoader.loadFont();
		Cache.sceneActorAnis.putAll(SceneActorLoader.loadSceneActorAnis("001"));
		FaceLoader.loadFaces();
		GUILoader.loadControls();
	}
	

	
}
