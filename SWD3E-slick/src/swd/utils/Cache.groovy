package swd.utils

import swd.graphics.Animation
import swd.gui.Paper
import swd.script.SWDScript

class Cache {

	public static HashMap<String, Animation> sceneActorAnis=new HashMap<String,Animation> ();
	public static HashMap<String, Paper> controls=new HashMap<String, Paper>();
	public static HashMap<String,Animation>  fightMaps=new HashMap<String, Animation>();
	public static HashMap<String,Animation> fightRoles=new HashMap<String, Animation>();
	public static HashMap<String, SWDScript> scripts=new HashMap<String,SWDScript>();
}
