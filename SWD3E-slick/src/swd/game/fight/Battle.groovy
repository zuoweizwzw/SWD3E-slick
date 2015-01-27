package swd.game.fight;

import java.util.ArrayList;

import swd.game.graphics.fight.FightRole;

public class Battle {

	public ArrayList<FightRole> allies=new ArrayList<FightRole>();
	public ArrayList<FightRole> enemies=new ArrayList<FightRole>();
	
	public FightRole getAllyByName(String name){
		for(FightRole fightRole: allies)
		{
			if(fightRole.getName().equals(name))
			{
				return fightRole;
			}
		}
		return null;
	}
}