package swd.graphics.map

import swd.game.action.Group

class SceneMap extends Group{

	String mapID="";
	Group background=new Group();
	Group roleGroup=new Group();
	Group masks=new Group();
	public SceneMap(String mapID)
	{
		this.mapID=mapID;
		this.addActor(background);
		this.addActor(roleGroup);
		this.addActor(masks);
	}
}
