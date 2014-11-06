package swd.game.graphics

import swd.graphics.Sprite

class SceneActor extends Sprite{

	public String roleID="";
	public  SceneActor(String roleID)
	{
		this.roleID=roleID;
		this.setName("sceneActor/"+roleID);
	}
}
