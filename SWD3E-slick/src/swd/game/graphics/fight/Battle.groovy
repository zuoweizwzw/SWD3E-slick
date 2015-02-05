package swd.game.graphics.fight;

import java.util.ArrayList;


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
	
	public FightRole getEnemyByName(String name){
		for(FightRole fightRole: enemies)
		{
			if(fightRole.getName().equals(name))
			{
				return fightRole;
			}
		}
		return null;
	}
	
	public void addAlly(FightRole fightRole)
	{
		this.allies.add(fightRole);
	}
	
	public void addEnemy(FightRole fightRole)
	{
		this.enemies.add(fightRole);
	}
}