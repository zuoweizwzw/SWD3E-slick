package swd.gui.scene

import swd.gui.Paper;
import org.newdawn.slick.Color;
class Dialog1 extends Paper{

	public ColorPaper background;
	public Paper face=new Paper();
	public TextBox textBox=new TextBox(); 
	
	public Dialog1()
	{
		this.background=new ColorPaper(new Color(0,0,1,0.4f));
		this.background.size.set(640, 140);
		this.setLocation(0, 340);
		face.setLocation(0, -20);
		textBox.setX(140);
		this.addActor(background);
		this.addActor(face);
		this.addActor(textBox);
		this.setName("gui/dialog1");
	}
}
