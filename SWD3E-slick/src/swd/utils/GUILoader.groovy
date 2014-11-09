package swd.utils

import org.newdawn.slick.util.xml.XMLElement
import org.newdawn.slick.util.xml.XMLParser;
import swd.graphics.Animation
import swd.gui.Paper

class GUILoader {

	public static Paper loadControls()
	{
		XMLParser parser = new XMLParser();
		
		try
		{
		XMLElement root=parser.parse("gui",new FileInputStream(Config.resPath+"\\gui\\scripts\\1_slick.xml"));
		int count=root.getChildren().size();
		
		for(int i=0;i<count;i++)
		{
			XMLElement controlElement=root.getChildren().get(i);
			if(!controlElement.getName().equals("control")) continue;
			Paper paper=loadControl(controlElement);
			Cache.controls.put(paper.getName(), paper);
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public static Paper loadControl(XMLElement controlElement) throws Exception
	{
		String type=controlElement.getAttribute("type");
		Class c=Class.forName(type);
		Paper paper=(Paper) c.newInstance();
		paper.setName(controlElement.getAttribute("id"));
		if("size" in controlElement.getAttributeNames())
		{
		String size_str=controlElement.getAttribute("size");
		paper.size.set (Float.parseFloat(size_str.split(",")[0]), Float.parseFloat(size_str.split(",")[1]));
		}
		if("location" in controlElement.getAttributeNames())
		{
		String location_str=controlElement.getAttribute("location");
		paper.setLocation(Float.parseFloat(location_str.split(",")[0]), Float.parseFloat(location_str.split(",")[1]));
		}
		int count=controlElement.getChildren().size();
		for(int i=0;i<count;i++)
		{
			XMLElement element=controlElement.getChildren().get(i);
			if(element.getName().equals("img"))
			{
				String path=element.getAttribute("src");
				Animation animation=new Animation(Config.resPath+"\\"+path);
				paper.setAnimation(animation);
				
			}
			if(element.getName().equals("control"))
			{
				Paper child=loadControl(element);
				paper.addActor(child);
			}
		}
		return paper;
	}
}
