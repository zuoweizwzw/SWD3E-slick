package swd.utils

import org.newdawn.slick.UnicodeFont
import org.newdawn.slick.font.effects.ColorEffect
import swd.font.SWDFont

public class FontLoader {

	public static SWDFont font18,font24;
	public static void loadFont()
	{
		font18 = new SWDFont(new UnicodeFont("c:/windows/fonts/simhei.ttf", 18, false, false));
		font24 = new SWDFont(new UnicodeFont("c:/windows/fonts/simhei.ttf", 20, false, false));
		
	 	font18.font.getEffects().add(new ColorEffect(java.awt.Color.white));
		font24.font.getEffects().add(new ColorEffect(java.awt.Color.white));
		
		font18.font.setDisplayListCaching(false);
		
	
	}
	public static void update()
	{
		font18.font.loadGlyphs();
		
		font24.font.loadGlyphs();
	}
}
