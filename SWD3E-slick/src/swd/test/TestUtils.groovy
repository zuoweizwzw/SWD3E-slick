package swd.test

import swd.game.fight.FightModel
import swd.game.fight.RoleModel
import swd.utils.Config;
class TestUtils {

	
	
	public static RoleModel generateRoleModel(String resID)
	{
		RoleModel model=new RoleModel();
		model.gameID=resID+"/1";
		model.resCode=resID;
		
		if(resID.equals("001"))
		{
		model.name="�¾���";
		model.description="��Ϸ����";
		model.hp=1200;
		model.hp_max=1600;
		model.mp=200;
		model.mp_max=400;
		model.energe=10;
		model.energe_max=200;
		model.fightAvatar=Config.resPath+"\\gui\\75-1.png";
		}
		if(resID.equals("002"))
		{
			model.name="��Сѩ";
			model.description="��Ϸ����";
			model.hp=1200;
			model.hp_max=1600;
			model.mp=400;
			model.mp_max=400;
			model.energe=100;
			model.energe=200;
		}
		return model;
	}
	public static FightModel generateFightModel()
	{
		FightModel model=new FightModel();
		model.allies.add(generateRoleModel("001"));
		model.fightMapResID="fightmap/1-1";
		return model;
	}
}
