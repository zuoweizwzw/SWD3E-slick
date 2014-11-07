package swd.gui.scene

import swd.gui.Paper;
import org.newdawn.slick.Color;
class Dialog1 extends Paper{

	public ColorPaper background; 
	
	public Dialog1()
	{
		this.background=new ColorPaper(new Color(1,0,0,0.5f));
		this.background.size.set(640, 140);
		this.setLocation(0, 340);
		this.addActor(background);
		this.setName("gui/dialog1");
	}
}
