package swd.utils

import org.newdawn.slick.Image
import swd.graphics.Animation
import swd.graphics.Frame
import swd.graphics.FrameItem

class SceneActorLoader {
	public static final HashMap<String,Animation> loadSceneActorAnis(String roleNum)
	{
		HashMap<String,Animation> anis=new HashMap<String,Animation>();
		
		File dir=new File(Config.resPath+"\\char\\"+roleNum+"\\anis");
		File[] files=dir.listFiles();
		for(File file:files)
		{
			Animation ani=new Animation();
			try
			{
				BufferedReader br=new BufferedReader(new FileReader(file));
				String code=br.readLine();
				String name=br.readLine();
				String mainOffset_str=br.readLine();
				ani.mainOffset.set(Integer.parseInt(mainOffset_str.split(",")[0]),Integer.parseInt(mainOffset_str.split(",")[1]));
				String centerPoint_str=br.readLine();
				ani.centerPoint.set(Integer.parseInt(centerPoint_str.split(",")[0]),480-Integer.parseInt(centerPoint_str.split(",")[1]));
				String colisBox_str=br.readLine();
				String colisBox_origin_str=colisBox_str.split(" ")[0];
				String colisBox_size_str=colisBox_str.split(" ")[1];
				ani.colisBox.setX(Integer.parseInt(colisBox_origin_str.split(",")[0]));
				ani.colisBox.setY(Integer.parseInt(colisBox_origin_str.split(",")[1]));
				ani.colisBox.setWidth(Integer.parseInt(colisBox_size_str.split(",")[0]));
				ani.colisBox.setHeight(Integer.parseInt(colisBox_size_str.split(",")[1]));
				int count=Integer.parseInt(br.readLine());
				ani.code=code;
				ani.name=name;
				for(int i=0;i<count;i++)
				{
					Frame frame=new Frame();
					frame.duration=Float.parseFloat(br.readLine())*1000;
					int keyCount=Integer.parseInt(br.readLine());
					for(int j=0;j<keyCount;j++)
					{
						FrameItem item=new FrameItem();
						String[] strs=br.readLine().split(" ");
						String fileName=strs[0];
						item.img=new Image(Config.resPath+"\\"+fileName);
						ani.mainOffset.y=item.img.getHeight()-Integer.parseInt(mainOffset_str.split(",")[1]);
						if(strs.length==3)
						{
							boolean flip=Boolean.parseBoolean(strs[2]);
							if(flip) item.img=item.img.getFlippedCopy(true, false);
						}
						
						int offsetX=-ani.mainOffset.x;
						int offsetY=-ani.mainOffset.y;
						item.offsetX=offsetX;
						item.offsetY=offsetY;
						frame.frameItems.add(item);
					}
					ani.addFrame(frame);
				}
				println("::"+name);
				anis.put(name, ani);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return anis;
	}
}
