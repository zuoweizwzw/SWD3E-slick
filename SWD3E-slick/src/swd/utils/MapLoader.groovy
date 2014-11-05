package swd.utils

import swd.graphics.Sprite
import swd.graphics.map.SceneMap

class MapLoader {

	public static SceneMap loadSceneMap(String mapNum)
	{
		SceneMap map=new SceneMap(mapNum);
		
		map.background.addActor(new Sprite(Config.resPath+"\\huge\\"+mapNum+"\\"+mapNum+".png"));
		
		File controlsConfig=new File(Config.resPath+"\\huge\\"+mapNum+"\\"+mapNum+"_match.txt");
		
		
		try
		{
		BufferedReader br=new BufferedReader(new FileReader(controlsConfig));
		String line="";
		while((line=br.readLine())!=null)
		{
			if(line.indexOf("-")>=0)
			{
				String controlNum=line.split(" ")[0];
				String[] offsets=line.split(" ")[1].split(",");
				int x=Integer.parseInt(offsets[0]);
				int y=Integer.parseInt(offsets[1]);
				Sprite control=new Sprite(Config.resPath+"\\huge\\"+mapNum+"\\"+controlNum+".png");
				control.setX(x);
				
				control.setY(480-y-control.animation.getHeight());
				control.setName(controlNum);
				map.masks.addActor(control);
			}
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return map;
	}
}
