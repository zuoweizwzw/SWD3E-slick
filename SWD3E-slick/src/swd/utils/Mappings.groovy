package swd.utils

import org.newdawn.slick.geom.Vector2f
import swd.states.SWDState

class Mappings {
	public static String getDirectionNameByInt(int direction)
	{
		if(direction==0) return "up";
		if(direction==1) return "rightup";
		if(direction==2) return "right";
		if(direction==3) return "rightdown";
		if(direction==4) return "down";
		if(direction==5) return "leftdown";
		if(direction==6) return "left";
		if(direction==7) return "leftup";
		else return null;
	}
	public static Vector2f getDirectionVectorByDirection(int direction)
	{
		if(direction==0) return new Vector2f(0,-1);
		if(direction==1) return new Vector2f(1,-1);
		if(direction==2) return new Vector2f(1,0);
		if(direction==3) return new Vector2f(1,1);
		if(direction==4) return new Vector2f(0,1);
		if(direction==5) return new Vector2f(-1,1);
		if(direction==6) return new Vector2f(-1,0);
		if(direction==7) return new Vector2f(-1,-1);
		else return new Vector2f(0,0);
	}
	
	public static int getDirectionByVector(Vector2f vector)
	{
		double length=vector.length();
		double asinx=Math.asin(vector.x/length);
		double acosy=Math.acos(vector.y/length);
		double asiny=Math.asin(-vector.y/length);
		double acosx=Math.acos(vector.x/length);
		double angle20=20*Math.PI/180;
		double angle65=65*Math.PI/180;
		double angle25=25*Math.PI/180;
		
//		if(vector.isZero()) return 0;
		if(asinx>-angle20&&asinx<angle20&&vector.y<0) return 0;
		else if(asiny>angle25&&asiny<angle65&&vector.x>0) return 1;
		else if(asiny>-angle20&&asiny<angle20&&vector.x>0) return 2;
		else if(asiny>-angle65&&asiny<-angle25&&vector.x>0) return 3;
		else if(asinx>-angle20&&asinx<angle20&&vector.y>0) return 4;
		else if(asiny>-angle65&&asiny<-angle25&&vector.x<0) return 5;
		else if(asiny>-angle20&&asiny<angle20&&vector.x<0) return 6;
		else if(asiny>angle25&&asiny<angle65&&vector.x<0) return 7;
		else return -1;
	}
	
	public static int getDirectionByNormalVector(Vector2f v)
	{
		if(v.x==0&&v.y<0) return 0;
		else if(v.x>0&&v.y<0) return 1;
		else if(v.x>0&&v.y==0) return 2;
		else if(v.x>0&&v.y>0) return 3;
		else if(v.x==0&&v.y>0) return 4;
		else if(v.x<0&&v.y>0) return 5;
		else if(v.x<0&&v.y==0) return 6;
		else if(v.x<0&&v.y<0) return 7;
		else return -1;
	}
	
	public static Vector2f screenToState(Vector2f screenVec,SWDState state)
	{
		
		return screenVec.copy().add(state.camera);
	}
}
