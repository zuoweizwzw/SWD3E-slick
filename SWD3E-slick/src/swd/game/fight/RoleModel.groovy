package swd.game.fight;

import java.util.ArrayList;

import swd.game.graphics.fight.FightRole;

public class RoleModel {

	public FightRole fightRole;
	
	
	public String gameID="";
	public String resCode="";
	public String name="";
	public String description="";
	public int level;
	public int hp;
	public int hp_max;
	public int mp;
	public int mp_max;
	public int energe;
	public int energe_max;
	public int exp;
	public int exp_max;
	public ArrayList<String> magics=new ArrayList<String>();
	public String fightAvatar="";
}
