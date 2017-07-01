package util;

public class Logger {
	private static boolean isDebug = false;
	
	public static void log(SideType sourceSide, String msg, Object sourceObject){
		System.out.println(sourceSide+" : "+msg+" ["+sourceObject.getClass()+"]");
	}
	
	public static void log(SideType sourceSide, String msg, Exception e, Object sourceObject){
		System.out.println(sourceSide+" : "+msg+" ["+sourceObject.getClass()+"]" + "   #"+e.getMessage());
	}
	
	public static void debug(String msg){
		if( isDebug )
			System.out.println("		*"+msg+"*");
	}
	
	public static void setDebugMode(boolean toDebug){
		isDebug = toDebug;
	}
}
