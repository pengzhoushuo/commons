package com.upeng.commons.lang;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Number operation</p>
 * @author Lucky
 */
public class NumberUtils {

    /**
     * <p>Convert a <code>String</code> to an <code>int</code>, returning
     * <code>zero</code> if the conversion fails.</p>
     * @param str  the string to convert, may be null
     * @return the int represented by the string, or <code>zero</code> if
     * conversion fails
     */
    public static int toInt(String str) {
        return toInt(str, 0);
    }

    /**
     * <p>Convert a <code>String</code> to an <code>int</code>, returning a
     * default value if the conversion fails.</p>
     * 
     * <p>If the string is <code>null</code>, the default value is returned.</p>
     * 
     * @param str  the string to convert, may be null
     * @param defaultValue  the default value
     * @return the int represented by the string, or the default if conversion fails
     */
    public static int toInt(String str, int defaultValue) {
        if(str == null) {
            return defaultValue;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException nfe) {
            return defaultValue;
        }
    }
    
    /**
     * <p>Convert a <code>String</code> to an <code>int</code>, throw Exception instead of returning a int value
     * if the conversion fails.</p>
     * @param str
     * @return
     */
    public static int toIntStrict(String str){
    	 if(str == null) {
    		 throw new IllegalArgumentException("String 'null' can not parse to int");
         }
         try {
             return Integer.parseInt(str);
         } catch (NumberFormatException nfe) {
        	 throw new IllegalArgumentException(String.format("String '%s' can not parse to int", str));
         }
    }
    
    /**
     * <p>Convert a boolean to an int value</p>
     * @param b the boolean value to convert
     * @return 1 when b is true, else return 0.
     */
    public static int toInt(boolean b){
    	return b? BooleanUtils.NUM_TRUE :BooleanUtils.NUM_FALSE;
    }

    /**
     * <p>Convert a <code>String</code> to a <code>long</code>, returning
     * <code>zero</code> if the conversion fails.</p>
     * 
     * <p>If the string is <code>null</code>, <code>zero</code> is returned.</p>
     * 
     * @param str  the string to convert, may be null
     * @return the long represented by the string, or <code>0</code> if
     *  conversion fails
     */
    public static long toLong(String str) {
        return toLong(str, 0L);
    }

    /**
     * <p>Convert a <code>String</code> to a <code>long</code>, returning a
     * default value if the conversion fails.</p>
     * 
     * <p>If the string is <code>null</code>, the default value is returned.</p>
     * 
     * @param str  the string to convert, may be null
     * @param defaultValue  the default value
     * @return the long represented by the string, or the default if conversion fails
     */
    public static long toLong(String str, long defaultValue) {
        if (str == null) {
            return defaultValue;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException nfe) {
            return defaultValue;
        }
    }

    /**
     * <p>Convert a <code>String</code> to an <code>long</code>, throw Exception instead of returning a long value
     * if the conversion fails.</p>
     * @param str
     * @return
     */
    public static long toLongStrict(String str){
    	  if (str == null) {
    		  throw new IllegalArgumentException("String 'null' can not parse to Long object");
          }
          try {
              return Long.parseLong(str);
          } catch (NumberFormatException nfe) {
              throw new IllegalArgumentException(String.format("String '%s' can not parse to Long object", str));
          }
    }
    
    /**
     * <p>Convert a <code>String</code> to a <code>float</code>, returning
     * <code>0.0f</code> if the conversion fails.</p>
     * 
     * <p>If the string <code>str</code> is <code>null</code>,
     * <code>0.0f</code> is returned.</p>
     * 
     * @param str the string to convert, may be <code>null</code>
     * @return the float represented by the string, or <code>0.0f</code>
     * if conversion fails
     */
    public static float toFloat(String str) {
        return toFloat(str, 0.0f);
    }

    /**
     * <p>Convert a <code>String</code> to a <code>float</code>, returning a
     * default value if the conversion fails.</p>
     * 
     * <p>If the string <code>str</code> is <code>null</code>, the default
     * value is returned.</p>
     * 
     * @param str the string to convert, may be <code>null</code>
     * @param defaultValue the default value
     * @return the float represented by the string, or defaultValue
     * if conversion fails
     */
    public static float toFloat(String str, float defaultValue) {
      if (str == null) {
          return defaultValue;
      }     
      try {
          return Float.parseFloat(str);
      } catch (NumberFormatException nfe) {
          return defaultValue;
      }
    }

    /**
     * <p>Convert a <code>String</code> to a <code>float</code>, throw IllegalArgumentException
     * if the conversion fails.</p>
     * <p></p>
     * @param str
     * @return
     */
    public static float toFloatStrict(String str) {
        if (str == null) {
        	throw new IllegalArgumentException("String 'null' can not parse to Float object");
        }     
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException nfe) {
        	throw new IllegalArgumentException(String.format("String '%s' can not parse to Float object", str));
        }
      }
    
    /**
     * <p>Convert a <code>String</code> to a <code>double</code>, returning
     * <code>0.0d</code> if the conversion fails.</p>
     * 
     * <p>If the string <code>str</code> is <code>null</code>,
     * <code>0.0d</code> is returned.</p>
     * 
     * @param str the string to convert, may be <code>null</code>
     * @return the double represented by the string, or <code>0.0d</code>
     * if conversion fails
     */
    public static double toDouble(String str) {
        return toDouble(str, 0.0d);
    }

    /**
     * <p>Convert a <code>String</code> to a <code>double</code>, returning a
     * default value if the conversion fails.</p>
     * 
     * <p>If the string <code>str</code> is <code>null</code>, the default
     * value is returned.</p>
     * 
     * @param str the string to convert, may be <code>null</code>
     * @param defaultValue the default value
     * @return the double represented by the string, or defaultValue
     *  if conversion fails
     */
    public static double toDouble(String str, double defaultValue) {
      if (str == null) {
          return defaultValue;
      }
      try {
          return Double.parseDouble(str);
      } catch (NumberFormatException nfe) {
          return defaultValue;
      }
    }
    
    /**
     * <p>Convert a <code>String</code> to a <code>double</code>, throw IllegalArgumentException
     * if the conversion fails.</p>
     *
     * <p></p>
     * @param str
     * @return
     */
    public static double toDoubleStrict(String str) {
        if (str == null) {
        	throw new IllegalArgumentException("String 'null' can not parse to Double object");
        }
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
        	throw new IllegalArgumentException(String.format("String '%s' can not parse to Double object", str));
        }
      }
    
    /**
     * <p>Convert a <code>String</code> to a <code>short</code>, returning
     * <code>0</code> if the conversion fails.</p>
     * 
     * <p>If the string <code>str</code> is <code>null</code>,
     * <code>0</code> is returned.</p>
     * 
     * @param str
     * @return
     * @since 2.0
     */
    public static short toShort(String str){
    	short s = 0;
    	return toShort(str, s);
    }
    
    /**
     * <p>Convert a <code>String</code> to a <code>short</code>, returning a
     * default value if the conversion fails.</p>
     * 
     * <p>If the string <code>str</code> is <code>null</code>, the default
     * value is returned.</p>
     * 
     * @param str
     * @param defaultValue
     * @return
     * @since 2.0
     */
    public static short toShort(String str, short defaultValue){
    	 if (str == null) {
             return defaultValue;
         }
         try {
             return Short.parseShort(str);
         } catch (NumberFormatException nfe) {
             return defaultValue;
         }
    }
    
    /**
     * <p>Convert a <code>String</code> to a <code>short</code>, throw IlleaglArgumentException
     * if the conversion fails.
     * 
     * @param str
     * @return
     */
    public static short toShortStrict(String str){
   	 if (str == null) {
   		throw new IllegalArgumentException("String 'null' can not parse to Short object");
        }
        try {
            return Short.parseShort(str);
        } catch (NumberFormatException nfe) {
        	throw new IllegalArgumentException(String.format("String '%s' can not parse to Short object", str));
        }
   }
    
    /**
     * <p>Convert a <code>String</code> to a <code>BigDecimal</code>, returning
     * <code>0</code> if the conversion fails.</p>
     * 
     * <p>If the string <code>str</code> is <code>null</code>,
     * <code>0</code> is returned.</p>
     * 
     * @param str
     * @return
     * @since 2.0
     */
    public static BigDecimal toBigDecimal(String str){
    	try{
    		return new BigDecimal(str);
    	}catch(NumberFormatException nfe){
    		return new BigDecimal(0);
    	}
    }
    
    /**
     * <p>Convert a <code>String</code> to a <code>BigDecimal</code>, returning a
     * default value if the conversion fails.</p>
     * 
     * <p>If the string <code>str</code> is <code>null</code>, the default
     * value is returned.</p>
     * 
     * @param str
     * @param defaultValue
     * @return
     * @since 2.0
     */
    public static BigDecimal toBigDecimal(String str, BigDecimal defaultValue){
    	try{
    		return new BigDecimal(str);
    	}catch(NumberFormatException nfe){
    		return defaultValue;
    	}
    }
    
    /**
     * <p>Convert a <code>String</code> to a <code>BigDecimal</code>, throw IllegalArgumentException
     * if the conversion fails.</p>
     * 
     * @param str
     * @return
     */
    public static BigDecimal toBigDecimalStrict(String str){
    	try{
    		return new BigDecimal(str);
    	}catch(NumberFormatException nfe){
    		throw new IllegalArgumentException(String.format("String '%s' can not parse to BidDecimal object", str));
    	}
    }
    
    /**
     * <p>Convert a <code>String</code> to a <code>BigInteger</code>, returning
     * <code>0</code> if the conversion fails.</p>
     * 
     * <p>If the string <code>str</code> is <code>null</code>,
     * <code>0</code> is returned.</p>
     * 
     * @param str
     * @return
     * @since 2.0
     */
    public static BigInteger toBigInteger(String str){
    	try{
    		return new BigInteger(str);
    	}catch(NumberFormatException nfe){
    		return new BigInteger("0");
    	}
    }
    
    /**
     * <p>Convert a <code>String</code> to a <code>BigInteger</code>, returning a
     * default value if the conversion fails.</p>
     * 
     * <p>If the string <code>str</code> is <code>null</code>, the default
     * value is returned.</p>
     * 
     * @param str
     * @param defaultValue
     * @return
     * @since 2.0
     */
    public static BigInteger toBigInteger(String str, BigInteger defaultValue){
    	try{
    		return new BigInteger(str);
    	}catch(NumberFormatException nfe){
    		return defaultValue;
    	}
    }
    
   /**
    * <p>Convert a <code>String</code> to a <code>BigInteger</code>, throw IllegalArgumentException
    * if the conversion fails.</p>
    * @param str
    * @return
    */
    public static BigInteger toBigIntegerStrict(String str){
    	try{
    		return new BigInteger(str);
    	}catch(NumberFormatException nfe){
    		throw new IllegalArgumentException(String.format("String '%s' can not parse to BigInteger object", str));
    	}
    }
    
    /**
     * <p>Convert a <code>String</code> to a <code>byte</code>, returning
     * <code>0</code> if the conversion fails.</p>
     * 
     * <p>If the string <code>str</code> is <code>null</code>,
     * <code>0</code> is returned.</p>
     * 
     * @param str
     * @return
     * @since 2.0
     */
    public static byte toByte(String str){
    	try{
    		return new Byte(str);
    	}catch(NumberFormatException nfe){
    		return new Byte("0");
    	}
    }
    
    /**
     * <p>Convert a <code>String</code> to a <code>byte</code>, returning a
     * default value if the conversion fails.</p>
     * 
     * <p>If the string <code>str</code> is <code>null</code>, the default
     * value is returned.</p>
     * 
     * @param str
     * @param defaultValue
     * @return
     * @since 2.0
     */
    public static byte toByte(String str, byte defaultValue){
    	try{
    		return new Byte(str);
    	}catch(NumberFormatException nfe){
    		return defaultValue;
    	}
    }
    
   /**
    * <p>Convert a <code>String</code> to a <code>byte</code>, throw IllegalArgumentException
    * if the conversion fails.</p>
    * @param str
    * @return
    */
    public static byte toByteStrict(String str){
    	try{
    		return new Byte(str);
    	}catch(NumberFormatException nfe){
    		throw new IllegalArgumentException(String.format("String '%s' can not parse to Byte object", str));
    	}
    }
    
    /**
     * <p>Returns the minimum value in an long array.</p>
     * 
     * @param array  an array, must not be null or empty
     * @return the minimum value in the array
     * @throws IllegalArgumentException if <code>array</code> is <code>null</code>
     * @throws IllegalArgumentException if <code>array</code> is empty
     */
    public static long min(long... array) {
        // Validates input
        if (array == null) {
            throw new IllegalArgumentException("The Array must not be null");
        } else if (array.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty.");
        }
    
        // Finds and returns min
        long min = array[0];
        for (long l : array) {
            if (l < min) {
                min = l;
            }
        }
        return min;
    }

    /**
     * <p>Returns the minimum value in an int array.</p>
     * 
     * @param array  an array, must not be null or empty
     * @return the minimum value in the array
     * @throws IllegalArgumentException if <code>array</code> is <code>null</code>
     * @throws IllegalArgumentException if <code>array</code> is empty
     */
    public static int min(int... array) {
        // Validates input
        if (array == null) {
            throw new IllegalArgumentException("The Array must not be null");
        } else if (array.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty.");
        }
    
        // Finds and returns min
        int min = array[0];
        for (int i : array) {
            if (i < min) {
                min = i;
            }
        }
        return min;
    }
    
    /**
     * <p>Returns the minimum value in an int array.</p>
     * 
     * @param array  an array, must not be null or empty
     * @return the minimum value in the array
     * @throws IllegalArgumentException if <code>array</code> is <code>null</code>
     * @throws IllegalArgumentException if <code>array</code> is empty
     */
    public static int minInt(int... array) {
    	return min(array);
    }

    /**
     * <p>Returns the minimum value in an short array.</p>
     * 
     * @param array  an array, must not be null or empty
     * @return the minimum value in the array
     * @throws IllegalArgumentException if <code>array</code> is <code>null</code>
     * @throws IllegalArgumentException if <code>array</code> is empty
     */
    public static short min(short... array) {
        // Validates input
        if (array == null) {
            throw new IllegalArgumentException("The Array must not be null");
        } else if (array.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty.");
        }
    
        // Finds and returns min
        short min = array[0];
        for (short s : array) {
            if (s < min) {
                min = s;
            }
        }
        return min;
    }

    /**
     * <p>Returns the minimum value in an byte array.</p>
     * 
     * @param array  an array, must not be null or empty
     * @return the minimum value in the array
     * @throws IllegalArgumentException if <code>array</code> is <code>null</code>
     * @throws IllegalArgumentException if <code>array</code> is empty
     */
    public static byte min(byte... array) {
        // Validates input
        if (array == null) {
            throw new IllegalArgumentException("The Array must not be null");
        } else if (array.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty.");
        }
    
        // Finds and returns min
        byte min = array[0];
        for (byte b : array) {
            if (b < min) {
                min = b;
            }
        }
        return min;
    }

     /**
     * <p>Returns the minimum value in an double array.</p>
     * 
     * @param array  an array, must not be null or empty
     * @return the minimum value in the array
     * @throws IllegalArgumentException if <code>array</code> is <code>null</code>
     * @throws IllegalArgumentException if <code>array</code> is empty
     */
    public static double min(double... array) {
        // Validates input
        if (array == null) {
            throw new IllegalArgumentException("The Array must not be null");
        } else if (array.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty.");
        }
    
        // Finds and returns min
        double min = array[0];
        for (double d : array) {
            if (Double.isNaN(d)) {
                return Double.NaN;
            }
            if (d < min) {
                min = d;
            }
        }
        return min;
    }

    /**
     * <p>Returns the minimum value in an float array.</p>
     * 
     * @param array  an array, must not be null or empty
     * @return the minimum value in the array
     * @throws IllegalArgumentException if <code>array</code> is <code>null</code>
     * @throws IllegalArgumentException if <code>array</code> is empty
     */
    public static float min(float... array) {
        // Validates input
        if (array == null) {
            throw new IllegalArgumentException("The Array must not be null");
        } else if (array.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty.");
        }
    
        // Finds and returns min
        float min = array[0];
        for (float f : array) {
            if (Float.isNaN(f)) {
                return Float.NaN;
            }
            if (f < min) {
                min = f;
            }
        }
        return min;
    }

    /**
     * <p>Returns the maximum value in an long array.</p>
     * 
     * @param array  an array, must not be null or empty
     * @return the minimum value in the array
     * @throws IllegalArgumentException if <code>array</code> is <code>null</code>
     * @throws IllegalArgumentException if <code>array</code> is empty
     */
    public static long max(long... array) {
        // Validates input
        if (array == null) {
            throw new IllegalArgumentException("The Array must not be null");
        } else if (array.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty.");
        }

        // Finds and returns max
        long max = array[0];
        for (long l : array) {
            if (l > max) {
                max = l;
            }
        }
        return max;
    }

    /**
     * <p>Returns the maximum value in an int array.</p>
     * 
     * @param array  an array, must not be null or empty
     * @return the minimum value in the array
     * @throws IllegalArgumentException if <code>array</code> is <code>null</code>
     * @throws IllegalArgumentException if <code>array</code> is empty
     */
    public static int max(int... array) {
        // Validates input
        if (array == null) {
            throw new IllegalArgumentException("The Array must not be null");
        } else if (array.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty.");
        }
    
        // Finds and returns max
        int max = array[0];
        for (int i : array) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    /**
     * <p>Returns the maximum value in an int array.</p>
     * 
     * @param array  an array, must not be null or empty
     * @return the minimum value in the array
     * @throws IllegalArgumentException if <code>array</code> is <code>null</code>
     * @throws IllegalArgumentException if <code>array</code> is empty
     */
    public static int maxInt(int... array) {
    	return max(array);
    }
    
    /**
     * <p>Returns the maximum value in an short array.</p>
     * 
     * @param array  an array, must not be null or empty
     * @return the minimum value in the array
     * @throws IllegalArgumentException if <code>array</code> is <code>null</code>
     * @throws IllegalArgumentException if <code>array</code> is empty
     */
    public static short max(short... array) {
        // Validates input
        if (array == null) {
            throw new IllegalArgumentException("The Array must not be null");
        } else if (array.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty.");
        }
    
        // Finds and returns max
        short max = array[0];
        for (short s : array) {
            if (s > max) {
                max = s;
            }
        }
        return max;
    }

    /**
     * <p>Returns the maximum value in an byte array.</p>
     * 
     * @param array  an array, must not be null or empty
     * @return the minimum value in the array
     * @throws IllegalArgumentException if <code>array</code> is <code>null</code>
     * @throws IllegalArgumentException if <code>array</code> is empty
     */
    public static byte max(byte... array) {
        // Validates input
        if (array == null) {
            throw new IllegalArgumentException("The Array must not be null");
        } else if (array.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty.");
        }
    
        // Finds and returns max
        byte max = array[0];
        for (byte b : array) {
            if (b > max) {
                max = b;
            }
        } 
        return max;
    }

    /**
     * <p>Returns the maximum value in an double array.</p>
     * 
     * @param array  an array, must not be null or empty
     * @return the minimum value in the array
     * @throws IllegalArgumentException if <code>array</code> is <code>null</code>
     * @throws IllegalArgumentException if <code>array</code> is empty
     */
    public static double max(double... array) {
        // Validates input
        if (array== null) {
            throw new IllegalArgumentException("The Array must not be null");
        } else if (array.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty.");
        }
    
        // Finds and returns max
        double max = array[0];
        for (double d : array) {
            if (Double.isNaN(d)) {
                return Double.NaN;
            }
            if (d > max) {
                max = d;
            }
        }  
        return max;
    }

    /**
     * <p>Returns the maximum value in an float array.</p>
     * 
     * @param array  an array, must not be null or empty
     * @return the minimum value in the array
     * @throws IllegalArgumentException if <code>array</code> is <code>null</code>
     * @throws IllegalArgumentException if <code>array</code> is empty
     */
    public static float max(float... array) {
        // Validates input
        if (array == null) {
            throw new IllegalArgumentException("The Array must not be null");
        } else if (array.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty.");
        }

        // Finds and returns max
        float max = array[0];
        for (float f : array) {
            if (Float.isNaN(f)) {
                return Float.NaN;
            }
            if (f > max) {
                max = f;
            }
        }
        return max;
    }
    
    /**
     * <p>Convert String[] to int[]</p>
     * @param strs string array
     * @return
     */
    public static int[] toIntArray(String[] strs){
    	if(strs == null){
    		throw new IllegalArgumentException("string array must not be null");
    	}
    	int length = strs.length;
    	int[] ints = new int[length];
    	for(int i=0; i<length; i++){
    		ints[i] = Integer.parseInt(strs[i]);
    	}
    	return ints;
    }
    
    /**
     * <p>Convert String List to integer List</p>
     * @param strList string list
     * @return
     */
    public static List<Integer> toIntList(List<String> strList){
    	if(strList == null){
    		throw new IllegalArgumentException("string array must not be null");
    	}
    	List<Integer> intList = new ArrayList<Integer>();
    	for(String str : strList){
    		intList.add(Integer.parseInt(str));
    	}
    	return intList;
    }
    
    /**
     * <p>Description: Convert a number string to Chinese upper case<p>
     * @param value
     * @return
     */
    public static String toUpper(String value){
    	if(StringUtils.isBlank(value)){
    		throw new IllegalArgumentException("value must not be null");
    	}
		// 校验参数value精度及最大值，不允许超过指定数值
		double max = 9999999999d;
		double dvalue = toDoubleStrict(value);
		if(dvalue > max){
			throw new IllegalArgumentException("value must less than " + max);
		}
		// 将参数value转换为大十进制，防止数值转换时，出现舍入问题
		BigDecimal d = new BigDecimal(value);
		BigDecimal d2 = new BigDecimal("100");

		// 定义相关段内，段名及数字翻译
		char[] hunit = { '拾', '佰', '仟' };
		char[] vunit = { '万', '亿' };
		char[] digit = { '零', '壹', '贰', '叁', '肆', '伍', '陆', '柒', '捌', '玖' };
		long midVal = 0;
		String valStr = "";
		String head = "";
		String rail = "";

		// 对只有小数部分进行特殊处理
		if (d.compareTo(new BigDecimal("1")) < 0) {
			head = "0";
			rail = d.multiply(new BigDecimal("100")).compareTo(
					new BigDecimal("10")) < 0 ? "0"
					+ (d.multiply(d2).toString()) : d.multiply(d2).toString();
		} else {
			midVal = d.multiply(new BigDecimal("100")).longValue();
			valStr = String.valueOf(midVal);
			head = valStr.substring(0, valStr.length() - 2);
			rail = valStr.substring(valStr.length() - 2);
		}

		String prefix = "";
		String suffix = "";

		// 处理小数部分
		if (rail.equals("00")) {
			suffix = "整";
		} else {
			suffix = digit[rail.charAt(0) - '0'] + "角"
					+ digit[rail.charAt(1) - '0'] + "分";
		}

		// 处理整数部分
		char[] chDig = head.toCharArray();
		char zero = '0';
		byte zeroSerNum = 0;

		// 对整数部分循环处理
		for (int i = 0; i < chDig.length; i++) {
			int idx = (chDig.length - i - 1) % 4;
			int vidx = (chDig.length - i - 1) / 4;

			// 如段（即个十百千为一个段）内相邻的零的个数大于1，也只显示一个零
			if (chDig[i] == '0') {
				zeroSerNum++;
				if (zero == '0') {
					zero = digit[0];
				}
				if (idx == 0 && vidx > 0 && zeroSerNum < 4) {
					prefix += vunit[vidx - 1];
					zero = '0';
				}
				continue;
			}
			zeroSerNum = 0;
			if (zero != '0') {
				prefix += zero;
				zero = '0';
			}
			prefix += digit[chDig[i] - '0'];
			if (idx > 0){
				prefix += hunit[idx - 1];
			}
			if (idx == 0 && vidx > 0) {
				prefix += vunit[vidx - 1];
			}
		}

		if (prefix.length() > 0){
			prefix += '圆';
		}
		return prefix + suffix;
    }
    
    public static String trimZero(String num){
    	if(StringUtils.contains(num, ".")){
    		int startIndex = num.lastIndexOf('.');
    		char[] cs = num.toCharArray();
	    	int endIndex = cs.length - 1;
	    	for(int i=cs.length-1; i>startIndex; i--){
	    		if('0'==cs[i]){
	    			endIndex = i;
	    		}else{
	    			break;
	    		}
	    	}
    		if(endIndex == startIndex + 1){//.0
    			endIndex = startIndex;
    		}
    		if(num.endsWith(".") || num.endsWith("0")|| endIndex < cs.length -1){
    			return num.substring(0,endIndex);
    		}else{
    			return num;
    		}
    	}
    	return num;
    }
}
