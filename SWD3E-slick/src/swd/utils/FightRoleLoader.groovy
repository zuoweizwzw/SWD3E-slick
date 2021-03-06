package swd.utils

import org.newdawn.slick.Image
import org.newdawn.slick.geom.Vector2f
import swd.graphics.Animation
import swd.graphics.Frame
import swd.graphics.FrameItem
import swd.script.SWDScript

class FightRoleLoader {

	public static void loadFightRole(String roleID){
		File dir=new File(Config.resPath+"\\char\\"+roleID+"\\fight");
		for(File file:dir.listFiles()) {

			if(file.isDirectory()) {
				if(file.getName().indexOf("scripts")>=0) {
					
					loadFightScripts(roleID,file);
				}
			}

			else {

				if(!file.getName().split("\\.")[1].equals("ani")) continue;
				try {
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
					animation.userData.put("leftAlign", leftAlign);
					int length=Integer.parseInt(br.readLine());

					for(int i=1;i<length+1;i++) {
						Frame frame=new Frame();
						float duration=Float.parseFloat(br.readLine());
						frame.duration=duration*1000;
						int keyNum=Integer.parseInt(br.readLine());
						for(int j=0;j<keyNum;j++) {
							FrameItem key=new FrameItem();

							String imgRes=br.readLine();

							key.img=new Image((Config.resPath+"\\"+imgRes.split(" ")[0]));
							key.offsetX=-animation.mainOffset.x;
							key.offsetY=-key.img.getHeight()+animation.mainOffset.y;
							if(imgRes.split(" ").length==2) {
								boolean flip=Boolean.parseBoolean(imgRes.split(" ")[1]);
								if(flip) {
									key.img=key.img.getFlippedCopy(true, false);
									key.offsetX=-key.img.getWidth()+animation.mainOffset.x;
								}
							}
							frame.frameItems.add(key);
						}
						animation.addFrame(frame);
					}
					Cache.fightRoles.put(id, animation);
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	private static void loadFightScripts(String roleID, File dir) {
		for(File file:dir.listFiles()) {

			BufferedReader br=new BufferedReader(new FileReader(file));
			String line="";
			SWDScript script=new SWDScript();
			line=br.readLine();
			String code=line;

			while((line=br.readLine())!=null) {
				script.scripts.add(line);
			}
			Cache.scripts.put(code, script);
		}
	}
}
