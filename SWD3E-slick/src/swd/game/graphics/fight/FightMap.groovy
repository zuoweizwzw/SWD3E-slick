package swd.game.graphics.fight

import swd.graphics.Sprite;
import swd.utils.Cache;
class FightMap extends Sprite{

	public FightMap(String mapID) {
		// TODO Auto-generated constructor stub
		this.setAnimation(Cache.fightMaps.get(mapID));
		
		this.setLocation(0, 0);
	}
}
