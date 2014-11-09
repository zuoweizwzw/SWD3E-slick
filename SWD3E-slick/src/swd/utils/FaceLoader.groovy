package swd.utils

import org.newdawn.slick.Image
import swd.graphics.Animation
import swd.graphics.Frame
import swd.graphics.FrameItem

class FaceLoader {

	public static HashMap<String,Animation> faces=new HashMap<String, Animation>();
	public static void loadFaces()
	{
		File dir=new File(Config.resPath+"\\face\\scripts");
		File[] files=dir.listFiles();
		
		for(File file:files)
		{
			
			Animation ani=new Animation();
			
			try
			{
				BufferedReader br=new BufferedReader(new FileReader(file));
				String line="";
				while((line=br.readLine())!=null)
				{
					if(!line.equals("\r\n"))
					{
						if(line.indexOf("no")==0)
						{
							String no=line.split(":")[1];
							line=br.readLine();
							String role=line.split(":")[1];
							line=br.readLine();
							String name=line.split(":")[1];
							line=br.readLine();
							String img=line.split(":")[1];
							Frame f=new Frame();
							FrameItem fk=new FrameItem();
							fk.img=new Image((Config.resPath+"\\"+img));
							f.frameItems.add(fk);
							ani.addFrame(f);
							ani.autoUpdate=false;
							faces.put("face/"+role+"/"+no, ani);
							
							Animation anir=new Animation();
							Frame fr=new Frame();
							FrameItem fkr=new FrameItem();
							fkr.img=new Image(fk.img);
							
							
							
							
							fkr.img=fk.img.getFlippedCopy(true, false);;
							fr.frameItems.add(fkr);
							anir.addFrame(fr);;
							anir.autoUpdate=false;
							faces.put("face/"+role+"/"+no+"r", anir);
						}
					}
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}
