package swd.utils

import org.newdawn.slick.Image
import swd.graphics.Animation
import swd.graphics.Frame
import swd.graphics.FrameItem

class FightMapLoader {

	//直接填地图ID号如1-1
	public static void loadFightMap(String resID)
	{
		File file=new File(Config.resPath+"\\map2\\scripts\\"+resID+".txt");
		try
		{
		BufferedReader br=new BufferedReader(new FileReader(file));
		String line;
		line=br.readLine();
		String code=line;
		
		String name=br.readLine();
		String imgRes=br.readLine();
		Animation animation=new Animation();
		Frame frame=new Frame();
		FrameItem key=new FrameItem();
		key.img=new Image((Config.resPath+"\\"+imgRes));
		frame.frameItems.add(key);
		animation.addFrame(frame);
		animation.autoUpdate=false;
		animation.setName(name);
		Cache.fightMaps.put(code, animation);		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
		
	}
}
