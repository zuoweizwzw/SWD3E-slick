package swd.states

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import swd.graphics.Sprite
import swd.graphics.map.SceneMap
import swd.utils.MapLoader;
import swd.utils.SceneActorLoader;

class SceneState extends SWDState{

	public int sceneStatus=0;
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
		cjc.setAnimation(SceneActorLoader.loadSceneActorAnis("001").get("001/stand_left"));
		cjc.setLocation(320,240);
		
		this.sprites.addActor(cjc);
	}
	@Override
	public void keyReleased(int key, char c) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(int button, int x, int y) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void analogKeydown(Input input) {
		// TODO Auto-generated method stub
		if(this.sceneStatus==0)
		{
			
		}
	}
	@Override
	public void analogMouseDown(Input input) {
		// TODO Auto-generated method stub
		if(input.isMouseButtonDown(0))
			{
				println("dd");
				
			}
	}
	
	
}
