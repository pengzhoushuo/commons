package com.upeng.commons.cache;

/**
 * KeyUtils
 * @author Lucky
 */
public class KeyUtils {

	/**
	 * generate key
	 * @param mark 
	 * @param columns
	 * @return
	 */
	public static String genKey(String mark, String... columns){
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<columns.length; i++){
			if(i > 0){
				sb.append(mark);
			}
			sb.append(columns[i]);
		}
		return sb.toString();
	}
}
