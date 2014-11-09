package swd.font

import org.newdawn.slick.Color;
import org.newdawn.slick.UnicodeFont

class SWDFont {

	//用[FFFFFFFF]来控制颜色。用\n来控制行
	public UnicodeFont font;
	Color color=Color.white;
	public SWDFont(UnicodeFont font)
	{
		this.font=font;
	}
	
	private Color getColorFromDes(String colorDes)
	{
		String redDes=colorDes.substring(1, 3);
		int r=Integer.parseInt(redDes, 16);
		
		String greenDes=colorDes.substring(3, 5);
		int g=Integer.parseInt(greenDes, 16);
		
		String blueDes=colorDes.substring(5, 7);
		int b=Integer.parseInt(blueDes, 16);
		
		String alphaDes=colorDes.substring(7, 9);
		int a=Integer.parseInt(alphaDes, 16);
		
		Color color=new Color(r,g,b,a);
		return color;
		
	}
	
	
	
	public void drawStringWithColorControlled(float x, float y, String text)
	{
		StringBuffer orignal=new StringBuffer(text);
		StringBuffer display=new StringBuffer();
		
		int offsetX,offsetY=0;
		while(orignal.size()>0)
		{
			if(orignal.charAt(0)=='[')
			{
				String colorDes=orignal.subSequence(0, 10);
				
				color=getColorFromDes(colorDes);
				orignal.delete(0, 10);
				continue;
			}
			else if(orignal.charAt(0)=='\n')
			{
				offsetY++;
				offsetX=0;
				orignal.deleteCharAt(0);
			}
			else 
			{
				char c=orignal.charAt(0);
				orignal.deleteCharAt(0);
				
				font.drawString((int)(x+offsetX), (int)(y+font.getLineHeight()*offsetY), c.toString(),color);
				offsetX+=font.getWidth(c.toString());
				
			}
		}
	}
}
