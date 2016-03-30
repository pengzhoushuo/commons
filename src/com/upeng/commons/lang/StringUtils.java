package com.upeng.commons.lang;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>String operation</p>
 * @author Lucky
 * 2:49:11 PM Sep 7, 2009 
 */
public class StringUtils {

	/**
	 * 	The empty String <code>""</code>.
	 */
	public static final String EMPTY = "";
	
	private static final String defaultCharset = Charsets.UTF_8;
	
    /**
     * <p>The maximum size to which the padding constant(s) can expand.</p>
     */
    private static final int PAD_LIMIT = 8192;
	
	/**
	 * <p>Checks if a String is empty ("") or null.</p>
	 * @param str the String to check, may be null 
	 * @return <code>true</code> if the String is empty or null
	 */
	public static boolean isEmpty(String str){
		return (str == null || str.length() < 1);
	}
	
	/**
	 * <p>Checks if a String is not empty ("") and not null.</p>
	 * @param str the String to check, may be null
     * @return <code>true</code> if the String is not empty and not null
	 */
	public static boolean isNotEmpty(String str){
		return !StringUtils.isEmpty(str);
	}
	
	/**
	 * <p>Checks if a String is whitespace, empty ("") or null.</p>
	 * @param str the String to check, may be null
	 * @return @return <code>true</code> if the String is null, empty or whitespace
	 */
	public static boolean isBlank(String str){
		if(str == null || str.length() < 1){
			return true;
		}
		int strLen = str.length();
		for(int i = 0; i < strLen; i++){
			if(Character.isWhitespace(str.charAt(i)) == false){
				return false;
			}
		}
		return true;
	}
	
	/**
	 * <p>Checks if a String is not empty (""), not null and not whitespace only.</p>
	 * @param str
	 * @return  <code>true</code> if the String is
	 *  not empty and not null and not whitespace
	 */
	public static boolean isNotBlank(String str){
		return !StringUtils.isBlank(str);
	}
	/**
	 * <p>Checks if a String can parse to Int</p>
	 * @param str The String to Check
	 * @return
	 */
	public static boolean isIntNumString(String str){
		if(str == null){
			return false;
		}
		try{
			Integer.parseInt(str);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	/**
	 * <p>Checks if a String can parse to Number</p>
	 * @param str The String to Check
	 * @return
	 */
	public static boolean isNumString(String str){
		if(str == null){
			return false;
		}
		try{
			Double.parseDouble(str);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	/**
	 * <p><Convert String to its Upper case/p>
	 * @param str the String to convert
	 * @return <code>String of upper case</code>
	 */
	public static String toUppderCase(String str){
		if(str == null || str.length() < 1){
			return str;
		}else{
			return str.toUpperCase();
		}
	}
	
	/**
	 * <p>Convert String to its Lower case</p>
	 * @param str the String to convert
	 * @return <code>String of lower case</code>
	 */
	public static String toLowerCase(String str){
		if(str == null || str.length() < 1){
			return str;
		}else{
			return str.toLowerCase();
		}
	}
	
	/**
	 * <p>Checks if a String is in a String List, case sensitive</p>
	 * @param strToCheck String to check
	 * @param strList String List 
	 * @return <code>true</code>if strToCheck is in strList,<code>false</code>otherwise
	 */
	public static boolean isInList(String strToCheck, String... strList){
		return isInList(strToCheck, false, strList);
	}
	
	/**
	 * <p>Checks if a String is in a String List by appointing ignoreCase for case insensitive or sensitive</p>
	 * @param strToCheck String to check
	 * @param ignoreCase whether ignore the case
	 * @param strList String List 
	 * @return <code>true</code>if strToCheck is in strList,<code>false</code>otherwise
	 */
	public static boolean isInList(String strToCheck, boolean ignoreCase, String ... strList){
		for(String str : strList){
			if(ignoreCase && str.equalsIgnoreCase(strToCheck)){
				return true;
			}else if(!ignoreCase && str.equals(strToCheck)){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * <p>Check if prefix starts with source</p>
	 * @param source source string
	 * @param prefix prefix string to check
	 * @return <code>true</code>if source string starts with prefix string
	 */
	public static boolean startsWithIgnoreCase(String source, String prefix){
		if(source != null && prefix != null){
			if(source.startsWith(prefix)){
				return true;
			}else{
				return (StringUtils.toLowerCase(source)).startsWith(StringUtils.toLowerCase(prefix));
			}
		}
		return false;
	}
	
	/**
	 * <p>Check if prefix starts with source</p>
	 * @param source source string
	 * @param prefix prefix string to check
	 * @param toOffset start position of source string
	 * @return
	 */
	public static boolean startsWithIgnoreCase(String source, String prefix , int toOffset){
		if(source != null && prefix != null){
			if(source.startsWith(prefix , toOffset)){
				return true;
			}else{
				return (StringUtils.toLowerCase(source)).startsWith(StringUtils.toLowerCase(prefix), toOffset);
			}
		}
		return false;
	
	}
	
	/**
	 * <p>Check if prefix starts with source</p>
	 * @param source source string
	 * @param prefix prefix string to check
	 * @return <code>true</code> if source string starts with prefix string
	 */
	public static boolean startsWith(String source, String prefix){
		if(source != null && prefix != null){
			if(source.startsWith(prefix)){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * <p>Check if prefix starts with source</p>
	 * @param source source string
	 * @param prefix prefix string to check
	 * @param toOffset start position of source string
	 * @return
	 */
	public static boolean startsWith(String source, String prefix , int toOffset){
		if(source != null && prefix != null){
			if(source.startsWith(prefix , toOffset)){
				return true;
			}
		}
		return false;
	
	}
	
	/**
	 * <p>eq String.getBytes("utf-8"), Exception insensitive</p>
	 * @param str input string
	 * @return bytes
	 */
	public static byte[] getBytes(String str){
		try {
			return str.getBytes(defaultCharset);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	/**
	 * <p>Convert int to String</p>
	 * @param i
	 * @return
	 */
	public static String toString(int i){
		return i + EMPTY;
	}
	
	/**
	 * <p>Convert double to String</p>
	 * @param d
	 * @return
	 */
	public static String toString(double d){
		return d + EMPTY;
	}
	
	/**
	 * <p>Convert float to String</p>
	 * @param f
	 * @return
	 */
	public static String toString(float f){
		return f + EMPTY;
	}
	
	/**
	 * <p>Convert long to String</p>
	 * @param l
	 * @return
	 */
	public static String toString(long l){
		return l + EMPTY;
	}
	
	/**
	 * <p>Convert boolean to String</p>
	 * @param b
	 * @return
	 */
	public static String toString(boolean b){
		return b + EMPTY;
	}
	
	/**
	 * <p>Convert char to String</p>
	 * @param c
	 * @return
	 */
	public static String toString(char c){
		return c + EMPTY;
	}

	/**
	 * <p>Convert byte[] to Hex String</p>
	 * @param src source byte[]
	 * @return
	 */  
	public static String toHexString(byte[] src){
	    StringBuilder stringBuilder = new StringBuilder();
	    if (src == null || src.length <= 0) {
	        return null;
	    }
	    for (int i = 0; i < src.length; i++) {
	        int v = src[i] & 0xFF;
	        String hv = Integer.toHexString(v);
	        if (hv.length() < 2) {
	            stringBuilder.append(0);
	        }
	        stringBuilder.append(hv);
	    }
	    return stringBuilder.toString();
	}
	
	/**
	 * <p>If input String is null return defaultValue, else return input String</p>
	 * @param str
	 * @param defaultValue
	 * @return
	 */
	public static String toString(String str, String defaultValue){
		if(str == null){
			return defaultValue;
		}
		return str;
	}
	
	/**
	 * <p>Convert Integer List<Integer> to String List<String></p>
	 * @param intList the Integer list to convert
	 * @return
	 */
	public static List<String> toStringList(List<Integer> intList){
		List<String> strList = new ArrayList<String>();
		for(int i : intList){
			strList.add(StringUtils.toString(i));
		}
		return strList;
	}
	
	/**
	 * <p>Convert Integer Array to String Array</p>
	 * @param intArray
	 * @return
	 */
	public static String[] toStringArray(int[] intArray){
		int length = intArray.length;
		String[] strArray = new String[length];
		for(int i = 0; i < length; i++){
			strArray[i] = StringUtils.toString(intArray[i]);
		}
		return strArray;
	}
	
	/**
	 * <p>Check whether source string contains appointing check string</p>
	 * <p>if source is null return false</p>
	 * @param source the source string 
	 * @param strToCheck the string to check
	 * @return <code>true</code> if source contains strToCheck
	 */
	public static boolean contains(String source, String strToCheck){
		if(source != null){
			return source.contains(strToCheck);
		}
		return false;
	}
	
	/**
	 * String str = "abc\\#def#ghj 	#kkk # lll #3456\\##\\#\\#\\##09";
	 * String[] strs = split(str);
	 * result:
	 * abc#def
	 * ghj
	 * kkk
	 * lll
	 * 3456#
	 * ###
	 * 09
	 * <p>Split input string to a string array, use split char flag '#' and ignore blank</p>
	 * @param source the source string to split
	 * @return
	 */
	public static String[] split(String source){
		return split(source, '#', true);
	}
	
	/**
	 * String str = "abc\\#def#ghj 	#kkk # lll #3456\\##\\#\\#\\##09";
	 * String[] strs = split(str,'#',true);
	 * result:
	 * abc#def
	 * ghj
	 * kkk
	 * lll
	 * 3456#
	 * ###
	 * 09
	 * <p>Split input string to a string array</p>
	 * @param source the source string to split
	 * @param splitChar split char flag
	 * @param ignoreBlank weather use trim for each element
	 * @return
	 */
	public static String[] split(String source, char splitChar, boolean ignoreBlank){
		char[] chars = source.toCharArray();
		char escapeChar = '\\';
		StringBuilder sb = new StringBuilder();
		boolean ifRecSplitChar = false;
		List<String> strList = new ArrayList<String>();
		for(char c : chars){
			if(!ifRecSplitChar && c == splitChar){
				ifRecSplitChar = false;
				if(ignoreBlank){
					strList.add(sb.toString().trim());
				}else{
					strList.add(sb.toString());
				}
				sb = new StringBuilder();
			}else{
				if(c == escapeChar){
					ifRecSplitChar = true;
				}else{
					sb.append(c);
					ifRecSplitChar = false;
				}
			}
		}
		if(ignoreBlank){
			strList.add(sb.toString().trim());
		}else{
			strList.add(sb.toString());
		}
		return strList.toArray(new String[]{});
	}
	
	/**
	 * <p>Check whether all character of input string is upper case</p>
	 * @param str
	 * @return
	 */
	public static boolean isUpperCase(String str){
		if(StringUtils.isNotBlank(str)){
			char[] cs = str.toCharArray();
			for(char c : cs){
				if(Character.isLowerCase(c)){
					return false;
				}
			}
			return true;
		}else{
			return true;
		}
	}
	
	/**
	 * <p>Check whether all character of input string is lower case</p>
	 * @param str
	 * @return
	 */
	public static boolean isLowerCase(String str){
		if(StringUtils.isNotBlank(str)){
			char[] cs = str.toCharArray();
			for(char c : cs){
				if(Character.isUpperCase(c)){
					return false;
				}
			}
			return true;
		}else{
			return true;
		}
	}
	
	/**
	 * Convert a String first letter to Upper case
	 * etc. 'abc' to 'Abc', 'ABC' to 'ABC', '' to '', 'a' to 'A'  
	 * <p></p>
	 * @param str
	 * @return
	 */
	public static String firstLetterUpper(String str){
		if(StringUtils.isBlank(str)){
			return str;
		}else if(str.length() == 1){
			return StringUtils.EMPTY + Character.toUpperCase(str.charAt(0));
		}else{
			char headerChar = str.charAt(0);
			return Character.toUpperCase(headerChar) + str.substring(1);
		}
	
	}
	
	/**
	 * Convert a String first letter to Lower case
	 * <p></p>
	 * @param str
	 * @return
	 */
	public static String firstLetterLower(String str){
		if(StringUtils.isBlank(str)){
			return str;
		}else if(str.length() == 1){
			return StringUtils.EMPTY + Character.toLowerCase((str.charAt(0)));
		}else{
			char headerChar = str.charAt(0);
			return Character.toLowerCase(headerChar) + str.substring(1);
		}
	
	}
	
	/**
	 * <p>Split an inputString to string array, each string item length is segLen, the last item no included</p>
	 * @param sourceStr source string to split
	 * @param segLen each segment length
	 * @return
	 */
	  public static String[] getSegments(String sourceStr, int segLen){
		   int len = sourceStr.length();
		   if(len < segLen){
			   return new String[]{sourceStr};
		   }else{
			   int segNum = len / segLen + 1;
			   if(len % segLen ==0){
				   segNum = len / segLen;
			   }
			   String[] result = new String[segNum];
			   for(int i=0; i<segNum; i++){
				  
				   result[i] = subString(sourceStr, i * segLen, (i+1) * segLen);
			   }
			   return result;
		   }
	   }
	   
	  /**
	   * <p>String.subString extension, ignore IndexOutBoundsException</p>
	   * @param sourceStr
	   * @param fromIndex
	   * @param toIndex
	   * @return
	   */
	   public static String subString(String sourceStr, int fromIndex, int toIndex){
		   int len = sourceStr.length();
		   if(toIndex > len){
			   return sourceStr.substring(fromIndex, len);
		   }else{
			   return sourceStr.substring(fromIndex, toIndex);
		   }
	   }
	   
	  /**
	   * <p>String.length extension, ignore NullPointerException</p>
	   * @param sourceStr
	   * @param fromIndex
	   * @param toIndex
	   * @return
	   */
	   public static int length(String str){
		   if(StringUtils.isEmpty(str)){
			   return 0;
		   }else{
			   return str.length();
		   }
	   }
	   
	   /**
	    * <p>Display first part string by appointing max length, the remains use appointing omit string instead</p>
	    * etc. omitString("loveyou", 2, "##") = lo##
	    * @param source
	    * @param maxLength
	    * @param omitStr
	    * @return
	    */
	   public static String omitString(String source, int maxLength, String omitStr){
		   if(StringUtils.length(source) < maxLength){
			   return source;
		   }else{
			   return StringUtils.subString(source, 0, maxLength) + omitStr;
		   }
	   }
	   
	   /**
	    * <p>Display first part string by appointing max length, the remains use '...' instead</p>
	    * etc. omitString("loveyou", 2) = lo...
	    * @param source
	    * @param maxLength
	    * @return
	    */
	   public static String omitString(String source, int maxLength){
		   return StringUtils.omitString(source, maxLength, "...");
	   }
	   
	   /**
	    * <p>Get sub string before a appointing string, not including the appoint string <p>
	    * @param source
	    * @param str
	    * @return
	    */
	   public static String substringBefore(String source, String str){
		   Assert.notNull(source, "source string most not be null");
		   if(str == null){
			   return source;
		   }else if(StringUtils.EMPTY.equals(str)){
			   return StringUtils.EMPTY;
		   }
		   int index = source.indexOf(str);
		   if(index == -1){
			   return StringUtils.EMPTY;
		   }
		   return subString(source, 0, index);
	   }
	   
	   /**
	    * <p>Get sub string after a appointing string, not including the appoint string <p>
	    * @param source
	    * @param str
	    * @return
	    */
	   public static String substringAfter(String source, String str){
		   if(source == null){
			   return null;
		   }
		   if(str == null){
			   return StringUtils.EMPTY;
		   }else if(StringUtils.EMPTY.equals(str)){
			   return source;
		   }
		   int index = source.indexOf(str);
		   if(index == -1){
			   return StringUtils.EMPTY;
		   }
		   return subString(source, index+1, source.length());
	   }
	   
	   /**
	    * <p>Description: Checks if a String can parse to Date<p>
	    * <p>The pattern of String must be yyyy-MM-dd or yyyy-MM-dd hh:mm:ss</p>
	    * @param str
	    * @return
	    */
	   public static boolean isDateString(String str){
		   try{
			   DateUtils.toDate(str);
			   return true;
		   }catch(Exception e){
		   }
		   return false;
	   }
	   
	   /**
		 * <p>Check if appointing string ends with appointing suffix</p>
		 * @param source source string
		 * @param suffix suffix string
		 * @return <code>true</code>if source string ends with suffix string
		 */
		public static boolean endsWithIgnoreCase(String source, String suffix){
			if(source != null && suffix != null){
				if(source.endsWith(suffix)){
					return true;
				}else{
					return (StringUtils.toLowerCase(source)).endsWith(StringUtils.toLowerCase(suffix));
				}
			}
			return false;
		}
		
		 /**
	     * <p>Returns padding using the specified delimiter repeated
	     * to a given length.</p>
	     *
	     * <pre>
	     * StringUtils.padding(0, 'e')  = ""
	     * StringUtils.padding(3, 'e')  = "eee"
	     * StringUtils.padding(-2, 'e') = IndexOutOfBoundsException
	     * </pre>
	     *
	     * <p>Note: this method doesn't not support padding with
	     * <a href="http://www.unicode.org/glossary/#supplementary_character">Unicode Supplementary Characters</a>
	     * as they require a pair of <code>char</code>s to be represented.
	     * If you are needing to support full I18N of your applications
	     * consider using {@link #repeat(String, int)} instead. 
	     * </p>
	     *
	     * @param repeat  number of times to repeat delim
	     * @param padChar  character to repeat
	     * @return String with repeated character
	     * @throws IndexOutOfBoundsException if <code>repeat &lt; 0</code>
	     * @see #repeat(String, int)
	     */
	    private static String padding(int repeat, char padChar) throws IndexOutOfBoundsException {
	        if (repeat < 0) {
	            throw new IndexOutOfBoundsException("Cannot pad a negative amount: " + repeat);
	        }
	        final char[] buf = new char[repeat];
	        for (int i = 0; i < buf.length; i++) {
	            buf[i] = padChar;
	        }
	        return new String(buf);
	    }
	    
		/**
	     * <p>Repeat a String <code>repeat</code> times to form a
	     * new String.</p>
	     *
	     * <pre>
	     * StringUtils.repeat(null, 2) = null
	     * StringUtils.repeat("", 0)   = ""
	     * StringUtils.repeat("", 2)   = ""
	     * StringUtils.repeat("a", 3)  = "aaa"
	     * StringUtils.repeat("ab", 2) = "abab"
	     * StringUtils.repeat("a", -2) = ""
	     * </pre>
	     *
	     * @param str  the String to repeat, may be null
	     * @param repeat  number of times to repeat str, negative treated as zero
	     * @return a new String consisting of the original String repeated,
	     *  <code>null</code> if null String input
	     */
	    public static String repeat(String str, int repeat) {
	        // Performance tuned for 2.0 (JDK1.4)

	        if (str == null) {
	            return null;
	        }
	        if (repeat <= 0) {
	            return EMPTY;
	        }
	        int inputLength = str.length();
	        if (repeat == 1 || inputLength == 0) {
	            return str;
	        }
	        if (inputLength == 1 && repeat <= PAD_LIMIT) {
	            return padding(repeat, str.charAt(0));
	        }

	        int outputLength = inputLength * repeat;
	        switch (inputLength) {
	            case 1 :
	                char ch = str.charAt(0);
	                char[] output1 = new char[outputLength];
	                for (int i = repeat - 1; i >= 0; i--) {
	                    output1[i] = ch;
	                }
	                return new String(output1);
	            case 2 :
	                char ch0 = str.charAt(0);
	                char ch1 = str.charAt(1);
	                char[] output2 = new char[outputLength];
	                for (int i = repeat * 2 - 2; i >= 0; i--, i--) {
	                    output2[i] = ch0;
	                    output2[i + 1] = ch1;
	                }
	                return new String(output2);
	            default :
	                StringBuffer buf = new StringBuffer(outputLength);
	                for (int i = 0; i < repeat; i++) {
	                    buf.append(str);
	                }
	                return buf.toString();
	        }
	    }
	    
	    /**
	     * <p>Repeat a String <code>repeat</code> times to form a
	     * new String, with a String separator injected each time. </p>
	     *
	     * <pre>
	     * StringUtils.repeat(null, null, 2) = null
	     * StringUtils.repeat(null, "x", 2)  = null
	     * StringUtils.repeat("", null, 0)   = ""
	     * StringUtils.repeat("", "", 2)     = ""
	     * StringUtils.repeat("", "x", 3)    = "xxx"
	     * StringUtils.repeat("?", ", ", 3)  = "?, ?, ?"
	     * </pre>
	     *
	     * @param str        the String to repeat, may be null
	     * @param separator  the String to inject, may be null
	     * @param repeat     number of times to repeat str, negative treated as zero
	     * @return a new String consisting of the original String repeated,
	     *  <code>null</code> if null String input
	     */
	    public static String repeat(String str, String separator, int repeat) {
	        if(str == null || separator == null) {
	            return repeat(str, repeat);
	        } else {
	            // given that repeat(String, int) is quite optimized, better to rely on it than try and splice this into it
	            String result = repeat(str + separator, repeat);
	            return removeEnd(result, separator);
	        }
	    }
	    
	    /**
	     * <p>Removes a substring only if it is at the end of a source string,
	     * otherwise returns the source string.</p>
	     *
	     * <p>A <code>null</code> source string will return <code>null</code>.
	     * An empty ("") source string will return the empty string.
	     * A <code>null</code> search string will return the source string.</p>
	     *
	     * <pre>
	     * StringUtils.removeEnd(null, *)      = null
	     * StringUtils.removeEnd("", *)        = ""
	     * StringUtils.removeEnd(*, null)      = *
	     * StringUtils.removeEnd("www.domain.com", ".com.")  = "www.domain.com"
	     * StringUtils.removeEnd("www.domain.com", ".com")   = "www.domain"
	     * StringUtils.removeEnd("www.domain.com", "domain") = "www.domain.com"
	     * StringUtils.removeEnd("abc", "")    = "abc"
	     * </pre>
	     *
	     * @param str  the source String to search, may be null
	     * @param remove  the String to search for and remove, may be null
	     * @return the substring with the string removed if found,
	     *  <code>null</code> if null String input
	     * @since 2.1
	     */
	    public static String removeEnd(String str, String remove) {
	        if (isEmpty(str) || isEmpty(remove)) {
	            return str;
	        }
	        if (str.endsWith(remove)) {
	            return str.substring(0, str.length() - remove.length());
	        }
	        return str;
	    }
}
