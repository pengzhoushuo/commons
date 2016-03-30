package com.upeng.commons.text;
/**
 * <p>Display class for ignore null</p>
 * @author Lucky
 *
 */
public class Display {

	/**
	 * <p>If object is null return defaultString</p>
	 * @param object
	 * @param defaultString
	 * @return
	 */
	public static String display(Object object, String defaultString){
		if(null == object){
			return defaultString;
		}else{
			return object.toString();
		}
	}
	
	/**
	 * <p>If object is null return blank string</p>
	 * @param object
	 * @return
	 */
	public static String display(Object object){
		return display(object, "");
	}
}
