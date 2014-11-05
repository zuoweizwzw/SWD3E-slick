package swd.utils

import org.newdawn.slick.UnicodeFont
import org.newdawn.slick.font.effects.ColorEffect

public class FontLoader {

	public static UnicodeFont font18,font24;
	public static void loadFont()
	{
		font18 = new UnicodeFont("c:/windows/fonts/simhei.ttf", 48, false, false);
		font24 = new UnicodeFont("c:/windows/fonts/simhei.ttf", 24, false, false);
		
		font18.getEffects().add(new ColorEffect(java.awt.Color.white));
		
	
	}
	public static void update()
	{
		font18.loadGlyphs();
		font24.loadGlyphs();
	}
}
