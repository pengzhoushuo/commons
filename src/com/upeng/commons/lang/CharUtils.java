/**
 * 
 */
package com.upeng.commons.lang;

/**
 * <p>Char operation</p>
 * @author Lucky
 *
 */
public class CharUtils {

	/**
	 * <p>Check whether char array contains input char</p>
	 * @param c
	 * @param cs
	 * @return
	 */
	public static boolean inArray(char c, char... cs){
		if(cs == null){
			return false;
		}
		for(char ch : cs){
			if(ch == c) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * <p>Check whether char array not contains input char</p>
	 * @param c
	 * @param cs
	 * @return
	 */
	public static boolean notInArray(char c, char... cs){
		return !CharUtils.inArray(c, cs);
	}
	
	public static char toChar(String str){
		if(str.length() < 2){
			return str.charAt(0);
		}else{
			throw new IllegalArgumentException(String.format("String %s can not convert to a Character", str));
		}
	}
	
	/**
	 * <p>Check whether appointing char is Chinese character</p>
	 * @param c
	 * @return
	 */
    public static boolean isChinese(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION) {
            return true;
        }
        return false;
    }
 
    /**
     * <p>Check whether appointing string contains Chinese character</p>
     * @param str
     * @return
     */
    public static boolean isContinsChineseChar(String str) {
        char[] ch = str.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            char c = ch[i];
            if (isChinese(c)) {
                return true;
            }
        }
        return false;
    }
}
