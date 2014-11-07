package swd.states

import java.awt.event.MouseAdapter;

import org.lwjgl.input.Mouse
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f
import org.newdawn.slick.state.StateBasedGame;
import swd.game.action.Action
import swd.game.action.Group
import swd.game.actions.SceneActorStandAction
import swd.game.actions.SceneActorWalkAction
import swd.game.graphics.SceneActor
import swd.graphics.Sprite
import swd.graphics.map.SceneMap
import swd.utils.MapLoader;
import swd.utils.Mappings;
import swd.utils.SceneActorLoader;
import swd.utils.Mappings;
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
		SceneActor cjc=new SceneActor("001");
		
		cjc.setAnimation(SceneActorLoader.loadSceneActorAnis("001").get("001/stand_left"));
		cjc.setLocation(320,240);
		cjc.addActions(new SceneActorWalkAction(cjc,this,1),new SceneActorStandAction(cjc,1));
		addSceneActor(cjc);
	}
	@Override
	public void keyReleased(int key, char c) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void keyPressed(int key, char c) {
		// TODO Auto-generated method stub
		Action action=this.sprites.findActorByNameDeep("sceneActor/001").rootAction.getAction(0);
		if(action instanceof SceneActorWalkAction)
		{
			action.stop=true;
		}
	}
	@Override
	public void mousePressed(int button, int x, int y) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseReleased(int button, int x, int y) {
		// TODO Auto-generated method stub
		SceneActor actor=getSceneActor("sceneActor/001");
		
		if(actor.getActions().size()>0&&actor.getActions().get(0) instanceof SceneActorWalkAction)
		{
			println(actor.getActions().get(0));
			actor.getActions().get(0).stop=true;
			actor.addAction(new SceneActorStandAction(actor,actor.getActions().get(0).direction));
			
		}
	}
	
	@Override
	public void analogKeydown(Input input) {
		// TODO Auto-generated method stub
		if(this.sceneStatus==0)
		{
			if(input.isKeyDown(Input.KEY_LSHIFT))
			{
				
			}
		}
	}
	@Override
	public void analogMouseDown(Input input) {
		// TODO Auto-generated method stub
		if(sceneStatus!=0) return;
		
		if(input.isMouseButtonDown(0))
			{
				SceneActor actor=getSceneActor("sceneActor/001");
				Vector2f mouse=new Vector2f(Mouse.getX(),480-Mouse.getY());
				Vector2f delta=mouse.copy().sub(new Vector2f(actor.getX(),actor.getY()));
				int direction=Mappings.getDirectionByVector(delta);
				if(actor.getActions().size()==0)
				{
					actor.addAction(new SceneActorWalkAction(actor,this,direction));
				}
				
//				moveSceneActor(actor);
			}
	}
	
	public void addSceneActor(SceneActor actor)
	{
		Group roleGroup=this.sprites.findActorByName("group/map").findActorByName("group/roles");
		roleGroup.addActor(actor);
	}
	
	public SceneActor getSceneActor(String name)
	{
		Group roleGroup=this.sprites.findActorByName("group/map").findActorByName("group/roles");
		return roleGroup.findActorByName(name);
	}
	private void moveSceneActor()
	{
		
	}
	
	
}
