package kr.ac.gachon.util;

public class StringUtil {

	public static String toKor(String value){
		if(value == null){
			return null;
		}
		try{
			return new String(value.getBytes("8859_1"), "utf-8");
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
}
