package com.upeng.commons.test.lang;

import com.upeng.commons.lang.ArrayUtils;

import junit.framework.TestCase;

public class ArrayUtilsTestCase extends TestCase {

	public void testToIntArrayIntegerArray() {
		Integer[] integerArray = new Integer[]{1,2,3,4};
		int[] intArray = {1,2,3,4};
		TestCase.assertEquals(intArray.length, ArrayUtils.toIntArray(integerArray).length);
		for(int i = 0; i<integerArray.length; i++){
			TestCase.assertEquals(intArray[i], ArrayUtils.toIntArray(integerArray)[i]);
		}
	}

	public void testToIntArrayStringArray() {
		String[] strArray = new String[]{"1","2","3","4"};
		int[] intArray = {1,2,3,4};
		TestCase.assertEquals(intArray.length, ArrayUtils.toIntArray(strArray).length);
		for(int i = 0; i<strArray.length; i++){
			TestCase.assertEquals(intArray[i], ArrayUtils.toIntArray(strArray)[i]);
		}
	}

	public void testToDoubleArrayStringArray() {
		String[] strArray = new String[]{"1","2","3","4"};
		double[] intArray = {1,2,3,4}; 
		TestCase.assertEquals(intArray.length, ArrayUtils.toDoubleArray(strArray).length);
		for(int i = 0; i<strArray.length; i++){
			TestCase.assertEquals(intArray[i], ArrayUtils.toDoubleArray(strArray)[i]);
		}
	}

	public void testToFloatArrayStringArray() {
		String[] strArray = new String[]{"1","2","3","4",null};
		float[] intArray = {1,2,3,4,0}; 
		TestCase.assertEquals(intArray.length, ArrayUtils.toFloatArray(strArray).length);
		for(int i = 0; i<strArray.length; i++){
			TestCase.assertEquals(intArray[i], ArrayUtils.toFloatArray(strArray)[i]);
		}
	}

	public void testToShortArrayStringArray() {
		String[] strArray = new String[]{"1","2","3","4"};
		short[] intArray = {1,2,3,4}; 
		TestCase.assertEquals(intArray.length, ArrayUtils.toShortArray(strArray).length);
		for(int i = 0; i<strArray.length; i++){
			TestCase.assertEquals(intArray[i], ArrayUtils.toShortArray(strArray)[i]);
		}
	}

	public void testToLongArrayStringArray() {
		String[] strArray = new String[]{"1","2","3","4"};
		long[] intArray = {1,2,3,4}; 
		TestCase.assertEquals(intArray.length, ArrayUtils.toLongArray(strArray).length);
		for(int i = 0; i<strArray.length; i++){
			TestCase.assertEquals(intArray[i], ArrayUtils.toLongArray(strArray)[i]);
		}
	}

	public void testToByteArrayStringArray() {
		String[] strArray = new String[]{"1","2","3","4"};
		byte[] intArray = {1,2,3,4}; 
		TestCase.assertEquals(intArray.length, ArrayUtils.toByteArray(strArray).length);
		for(int i = 0; i<strArray.length; i++){
			TestCase.assertEquals(intArray[i], ArrayUtils.toByteArray(strArray)[i]);
		}
	}

	public void testToBooleanArrayStringArray() {
		String[] strArray = new String[]{"1","0","true","false","True","FAse","TRUE","FALSE","3", "-1"};
		boolean[] intArray = {false, false, true, false, true, false, true, false, false, false}; 
		TestCase.assertEquals(intArray.length, ArrayUtils.toBooleanArray(strArray).length);
		for(int i = 0; i<strArray.length; i++){
			TestCase.assertEquals(intArray[i], ArrayUtils.toBooleanArray(strArray)[i]);
		}
	}

	public void testToCharArrayStringArray() {
		String[] strArray = new String[]{"1","2","3","4"};
		char[] intArray = {'1','2','3','4'}; 
		TestCase.assertEquals(intArray.length, ArrayUtils.toCharArray(strArray).length);
		for(int i = 0; i<strArray.length; i++){
			TestCase.assertEquals(intArray[i], ArrayUtils.toCharArray(strArray)[i]);
		}
		String[] strArray2 = new String[]{"1","2","3","41"};
		try{
			ArrayUtils.toCharArray(strArray2);
			TestCase.assertTrue(false);
		}catch(Exception e){
			TestCase.assertTrue(true);
		}
	}

	public void testToIntArrayString() {
		String str = "1,2,3,4";
		int[] intArray = {1,2,3,4};
		TestCase.assertEquals(intArray.length, ArrayUtils.toIntArray(str).length);
		for(int i = 0; i<intArray.length; i++){
			TestCase.assertEquals(intArray[i], ArrayUtils.toIntArray(str)[i]);
		}
		String str2 = "[1,2,3,4]";
		TestCase.assertEquals(intArray.length, ArrayUtils.toIntArray(str2).length);
		for(int i = 0; i<intArray.length; i++){
			TestCase.assertEquals(intArray[i], ArrayUtils.toIntArray(str2)[i]);
		}
	}

	public void testToStringArray() {
		String str = "1,2,3,44";
		String[] intArray = {"1","2","3","44"};
		TestCase.assertEquals(intArray.length, ArrayUtils.toStringArray(str).length);
		for(int i = 0; i<intArray.length; i++){
			TestCase.assertEquals(intArray[i], ArrayUtils.toStringArray(str)[i]);
		}
		String str2 = "[1,2,3,44]";
		TestCase.assertEquals(intArray.length, ArrayUtils.toStringArray(str2).length);
		for(int i = 0; i<intArray.length; i++){
			TestCase.assertEquals(intArray[i], ArrayUtils.toStringArray(str2)[i]);
		}
	}

	public void testToDoubleArrayString() {
		String str = "1,2,3,44";
		double[] intArray = {1,2,3,44};
		TestCase.assertEquals(intArray.length, ArrayUtils.toDoubleArray(str).length);
		for(int i = 0; i<intArray.length; i++){
			TestCase.assertEquals(intArray[i], ArrayUtils.toDoubleArray(str)[i]);
		}
		String str2 = "[1,2,3,44]";
		TestCase.assertEquals(intArray.length, ArrayUtils.toDoubleArray(str2).length);
		for(int i = 0; i<intArray.length; i++){
			TestCase.assertEquals(intArray[i], ArrayUtils.toDoubleArray(str2)[i]);
		}
	}

	public void testToLongArrayString() {
		String str = "1,2,3,44";
		long[] intArray = {1,2,3,44};
		TestCase.assertEquals(intArray.length, ArrayUtils.toLongArray(str).length);
		for(int i = 0; i<intArray.length; i++){
			TestCase.assertEquals(intArray[i], ArrayUtils.toLongArray(str)[i]);
		}
		String str2 = "[1,2,3,44]";
		TestCase.assertEquals(intArray.length, ArrayUtils.toLongArray(str2).length);
		for(int i = 0; i<intArray.length; i++){
			TestCase.assertEquals(intArray[i], ArrayUtils.toLongArray(str2)[i]);
		}
	}

	public void testToShortArrayString() {
		String str = "1,2,3,44";
		short[] intArray = {1,2,3,44};
		TestCase.assertEquals(intArray.length, ArrayUtils.toShortArray(str).length);
		for(int i = 0; i<intArray.length; i++){
			TestCase.assertEquals(intArray[i], ArrayUtils.toShortArray(str)[i]);
		}
		String str2 = "[1,2,3,44]";
		TestCase.assertEquals(intArray.length, ArrayUtils.toShortArray(str2).length);
		for(int i = 0; i<intArray.length; i++){
			TestCase.assertEquals(intArray[i], ArrayUtils.toShortArray(str2)[i]);
		}
	}

	public void testToByteArrayString() {
		String str = "1,2,3,44";
		byte[] intArray = {1,2,3,44};
		TestCase.assertEquals(intArray.length, ArrayUtils.toByteArray(str).length);
		for(int i = 0; i<intArray.length; i++){
			TestCase.assertEquals(intArray[i], ArrayUtils.toByteArray(str)[i]);
		}
		String str2 = "[1,2,3,44]";
		TestCase.assertEquals(intArray.length, ArrayUtils.toByteArray(str2).length);
		for(int i = 0; i<intArray.length; i++){
			TestCase.assertEquals(intArray[i], ArrayUtils.toByteArray(str2)[i]);
		}
	}

	public void testToFloatArrayString() {
		String str = "1,2,3,44";
		float[] intArray = {1,2,3,44};
		TestCase.assertEquals(intArray.length, ArrayUtils.toFloatArray(str).length);
		for(int i = 0; i<intArray.length; i++){
			TestCase.assertEquals(intArray[i], ArrayUtils.toFloatArray(str)[i]);
		}
		String str2 = "[1,2,3,44]";
		TestCase.assertEquals(intArray.length, ArrayUtils.toFloatArray(str2).length);
		for(int i = 0; i<intArray.length; i++){
			TestCase.assertEquals(intArray[i], ArrayUtils.toFloatArray(str2)[i]);
		}
	}

	public void testToBooleanArrayString() {
		String str = "1,2,3,44,true,false,TRUE,FALSE,TruE,FalsE";
		boolean[] intArray = {false,false,false,false,true,false,true,false,true,false};
		TestCase.assertEquals(intArray.length, ArrayUtils.toBooleanArray(str).length);
		for(int i = 0; i<intArray.length; i++){
			TestCase.assertEquals(intArray[i], ArrayUtils.toBooleanArray(str)[i]);
		}
		String str2 = "[1,2,3,44,true,false,TRUE,FALSE,TruE,FalsE]";
		TestCase.assertEquals(intArray.length, ArrayUtils.toBooleanArray(str2).length);
		for(int i = 0; i<intArray.length; i++){
			TestCase.assertEquals(intArray[i], ArrayUtils.toBooleanArray(str2)[i]);
		}
	}

	public void testToCharArrayString() {
		String str = "1,2,3,4";
		char[] intArray = {'1','2','3','4'};
		TestCase.assertEquals(intArray.length, ArrayUtils.toCharArray(str).length);
		for(int i = 0; i<intArray.length; i++){
			TestCase.assertEquals(intArray[i], ArrayUtils.toCharArray(str)[i]);
		}
		String str2 = "[1,2,3,4]";
		TestCase.assertEquals(intArray.length, ArrayUtils.toCharArray(str2).length);
		for(int i = 0; i<intArray.length; i++){
			TestCase.assertEquals(intArray[i], ArrayUtils.toCharArray(str2)[i]);
		}
		String str3 = "[1,2,3,44]";
		try{
			 ArrayUtils.toCharArray(str3);
			TestCase.assertTrue(false);
		}catch(Exception e){
			TestCase.assertTrue(true);
		}
	}

	public void testIndexOf() {
		String[] source = new String[]{"XZ","SZ","GZ"};
		String target = "GZ";
		TestCase.assertEquals(2, ArrayUtils.indexOf(source, target));
		TestCase.assertEquals(-1, ArrayUtils.indexOf(source, "abc"));
	}

	public void testLastIndexOf() {
		String[] source = new String[]{"GZ","SZ","cZ"};
		String target = "GZ";
		TestCase.assertEquals(0, ArrayUtils.lastIndexOf(source, target));
		TestCase.assertEquals(-1, ArrayUtils.lastIndexOf(source, "abc"));
		TestCase.assertEquals(-1, ArrayUtils.lastIndexOf(source, null));
	}

	public void testContact() {
		Object[] source = new String[]{"GZ","SZ","cZ"};
		Object[] source2 = new String[]{"GZ","SZ","cZ"};
		TestCase.assertEquals(source.length + source2.length, ArrayUtils.contact(source, source2).length);
		for(int i=0; i<source.length + source2.length; i++){
			if(i < source.length){
				TestCase.assertEquals(source[i], ArrayUtils.contact(source, source2)[i]);
			}else{
				TestCase.assertEquals(source[i - source.length], ArrayUtils.contact(source, source2)[i]);
			}
		}
	}
	
	public void testReverse(){
		Integer[] source = new Integer[]{1,3,2,4,5,6};
		ArrayUtils.reverse(source);
		for(int i : source){
			TestCase.assertEquals(6, source[0].intValue());;
			TestCase.assertEquals(5, source[1].intValue());;
			TestCase.assertEquals(4, source[2].intValue());;
			TestCase.assertEquals(2, source[3].intValue());;
			TestCase.assertEquals(3, source[4].intValue());;
			TestCase.assertEquals(1, source[5].intValue());;
		}
		Integer[] source2 = new Integer[]{1,3,2,4,5,6,7};
		ArrayUtils.reverse(source2);
		for(int i : source){
			TestCase.assertEquals(7, source2[0].intValue());;
			TestCase.assertEquals(6, source2[1].intValue());;
			TestCase.assertEquals(5, source2[2].intValue());;
			TestCase.assertEquals(4, source2[3].intValue());;
			TestCase.assertEquals(2, source2[4].intValue());;
			TestCase.assertEquals(3, source2[5].intValue());;
			TestCase.assertEquals(1, source2[6].intValue());;
		}
		ArrayUtils.reverse(null);
		ArrayUtils.reverse(new Integer[]{});
	}

	public void testToDateArray(){
		String str = "[2011-7-21,2011-7-21 10:21:30]";
		TestCase.assertEquals(2, ArrayUtils.toDateArray(str).length);
	}
}
