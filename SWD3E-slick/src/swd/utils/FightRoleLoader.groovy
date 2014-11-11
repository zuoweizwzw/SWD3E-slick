package swd.utils

import org.newdawn.slick.Image
import org.newdawn.slick.geom.Vector2f
import swd.graphics.Animation
import swd.graphics.Frame
import swd.graphics.FrameItem

class FightRoleLoader {

	public static void loadFightRole(String roleID){
		File dir=new File(Config.resPath+"\\char\\"+roleID+"\\fight");
		for(File file:dir.listFiles())
		{
			try
			{
				Animation animation=new Animation();
				BufferedReader br=new BufferedReader(new FileReader(file));
				String line;
				line=br.readLine();
				String code=line;
				String id=br.readLine();
				String foot_str=br.readLine();
				int offsetX=Integer.parseInt(foot_str.split(",")[0]);
				int offsetY=Integer.parseInt(foot_str.split(",")[1]);
				animation.mainOffset=new Vector2f(offsetX, offsetY);
				int leftAlign=Integer.parseInt(br.readLine());
				int length=Integer.parseInt(br.readLine());
				
				
				for(int i=1;i<length+1;i++)
				{
					Frame frame=new Frame();
					float duration=Float.parseFloat(br.readLine());
					frame.duration=duration*1000;
					int keyNum=Integer.parseInt(br.readLine());
					for(int j=0;j<keyNum;j++)
					{
						FrameItem key=new FrameItem();
						
						String imgRes=br.readLine();
						key.img=new Image((Config.resPath+"\\"+imgRes));
						frame.frameItems.add(key);
					}
					animation.addFrame(frame);
				}
				Cache.fightRoles.put(id, animation);
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}
