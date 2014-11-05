package swd.states

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import swd.graphics.map.SceneMap
import swd.utils.MapLoader;

class SceneState extends SWDState{

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public void enter(GameContainer container, StateBasedGame game)
	throws SlickException {
		// TODO Auto-generated method stub
		this.loadMap("1-1");
//		this.loadRoles();
	}
	private void loadMap(String mapID)
	{
		SceneMap map=MapLoader.loadSceneMap("1-1");
		this.sprites.addActor(map);
	}
}
