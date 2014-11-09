package swd.states

import java.awt.event.MouseAdapter;

import org.lwjgl.input.Mouse
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input
import org.newdawn.slick.MouseListener
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f
import org.newdawn.slick.state.StateBasedGame;
import swd.game.action.Action
import swd.game.action.Group
import swd.game.actions.CloseDialog1Action
import swd.game.actions.OpenDialog1Action
import swd.game.actions.SceneActorStandAction;
import swd.game.actions.SceneActorWalkAction;
import swd.game.actions.ShowDialogTextAction
import swd.game.actions.StartFightAction
import swd.game.actions.WaitMouseClickAction
import swd.game.graphics.SceneActor
import swd.graphics.Sprite
import swd.graphics.map.SceneMap
import swd.gui.Paper
import swd.gui.scene.Dialog1
import swd.utils.MapLoader;
import swd.utils.Mappings;
import swd.utils.Global
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
		initGUI();
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
		addSceneActor(cjc);
	}
	@Override
	public void keyReleased(int key, char c) {
		// TODO Auto-generated method stub
		Global.game.getContainer()
	}
	
	@Override
	public void keyPressed(int key, char c) {
		// TODO nerated method stub
//		this.gui.findActorByName("gui/dialog1").addAction(new OpenDialog1Action(this.gui.findActorByName("gui/dialog1"),"face/001/1r"));
//		this.gui.findActorByName("gui/dialog1").addAction(new ShowDialogTextAction(this.gui.findActorByName("gui/dialog1").textBox,"陈靖仇","[FFFFFFFF]我是天才是左为11111\n[FFFFFFFF]神经病一个啊啊我就是我"));
//		this.gui.findActorByName("gui/dialog1").addAction(new WaitMouseClickAction());
//		this.gui.findActorByName("gui/dialog1").addAction(new CloseDialog1Action(this.gui.findActorByName("gui/dialog1")));
		
//		Global.game.addState(new FightState());
		
		this.sprites.addAction(new StartFightAction());
		
		
	}
	@Override
	public void mousePressed(int button, int x, int y) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseReleased(int button, int x, int y) {
		// TODO Auto-generated method stub
		if(button==1)
		{
			if(sceneStatus!=0) return;
			SceneActor actor=getSceneActor("sceneActor/001");
			
			if(actor.getActions().size()>0&&actor.getActions().get(0) instanceof SceneActorWalkAction)
			{
				actor.getActions().get(0).stop=true;
				
			}
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
		
		if(input.isMouseButtonDown(1))
			{
				SceneActor actor=getSceneActor("sceneActor/001");
				Vector2f mouse=new Vector2f(Mouse.getX(),480-Mouse.getY());
				Vector2f delta=mouse.copy().sub(actor.getCenterPoint());
				
				int direction=Mappings.getDirectionByVector(delta);
				if(direction==-1) return;
				if(actor.getActions().size()==0)
				{
					if(delta.length()<32) return;
					actor.addAction(new SceneActorWalkAction(actor,this,direction));
					
				}
				else if(actor.getActions().get(0) instanceof SceneActorWalkAction)
				{
					if(delta.length()<32)
					{
						actor.getActions().get(0).stop=true;
					}
					if(actor.getActions().get(0).direction!=direction)
					{
						
						actor.getActions().get(0).changeDirection(direction);
					}
				}
				
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
	
	private void initGUI()
	{
		this.gui.addActor(new Dialog1());
		this.gui.findActorByName("gui/dialog1").visible=false;
		
	}
	
	
}
