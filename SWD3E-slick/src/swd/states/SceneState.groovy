package swd.states

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import swd.graphics.Sprite
import swd.graphics.map.SceneMap
import swd.utils.MapLoader;
import swd.utils.SceneActorLoader;

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
		this.loadRoles();
	}
	private void loadMap(String mapID)
	{
		SceneMap map=MapLoader.loadSceneMap("1-1");
		this.sprites.addActor(map);
	}
	
	private void loadRoles()
	{
		Sprite cjc=new Sprite();
		cjc.setAnimation(SceneActorLoader.loadSceneActorAnis("001").get("001/walk_leftdown"));
		cjc.setY(480);
		this.sprites.addActor(cjc);
	}
}
