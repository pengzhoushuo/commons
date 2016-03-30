package com.upeng.commons.test.beans;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import junit.framework.TestCase;

import com.upeng.commons.beans.StringConvertUtils;
import com.upeng.commons.lang.DateUtils;

public class StringConvertUtilsTestCase extends TestCase{

	@SuppressWarnings("unchecked")
	public void testConvertStringToObject() throws ParseException {
		
		//normal
		String str1 = "1234";
		TestCase.assertEquals(StringConvertUtils.convertStringToObject(str1, int.class), new Integer(1234));
		TestCase.assertEquals(StringConvertUtils.convertStringToObject(str1, long.class), new Long(1234));
		TestCase.assertEquals((short)StringConvertUtils.convertStringToObject(str1, short.class), (short)(1234));

		String str2 = "123.4"; 
		TestCase.assertEquals(StringConvertUtils.convertStringToObject(str2, float.class), new Float(123.4));
		TestCase.assertEquals(StringConvertUtils.convertStringToObject(str2, double.class), new Double(123.4));
		
		String str3 = "true";
		String str4 = "false";
		TestCase.assertEquals((boolean)StringConvertUtils.convertStringToObject(str3, boolean.class), true);
		TestCase.assertEquals((boolean)StringConvertUtils.convertStringToObject(str4, boolean.class), false);
		
		String str5 = "c";
		TestCase.assertEquals((char)StringConvertUtils.convertStringToObject(str5,char.class), 'c');
		
		String str6 = "123abc";
		TestCase.assertEquals(StringConvertUtils.convertStringToObject(str6,String.class), str6);
		
		String str7 = "2010-6-19";
		Date expDate = DateUtils.buildDate(2010, 6, 19);
		TestCase.assertSame(expDate.compareTo(((Date)StringConvertUtils.convertStringToObject(str7, Date.class))),0);
		
		String str8 = "2010-6-19 11:11:11";
		Date expDate2 = DateUtils.buildDate(2010, 6, 19, 11, 11, 11);
		TestCase.assertSame(expDate2.compareTo(((Date)StringConvertUtils.convertStringToObject(str8, Date.class))),0);
		
		String str9 = "12, 13,15 ,19";
		List<String> expected = new ArrayList<String>();
		expected.add("12");
		expected.add("13");
		expected.add("15");
		expected.add("19");
		List<String> acual = (List<String>)StringConvertUtils.convertStringToObject(str9, List.class);
		for(int i=0; i<expected.size(); i++){
			assertEquals(acual.get(i), expected.get(i));
		}
		
		String str10 = "111";
		assertEquals((byte)111, (byte)StringConvertUtils.convertStringToObject(str10, Byte.class));
		StringConvertUtils.convertStringToObject(str10, Byte.class);
		//exception
		try{
			StringConvertUtils.convertStringToObject(str2, Integer.class);
			assertFalse(true);
		}catch(Exception e){
			assertEquals(e.getMessage().startsWith("String"),true);
		}
		
		try{
			StringConvertUtils.convertStringToObject("1", Boolean.class);
			assertFalse(true);
		}catch(Exception e){
			assertEquals(e.getMessage().startsWith("String"),true);
		}
		
		try{
			StringConvertUtils.convertStringToObject("11", Character.class);
			assertFalse(true);
		}catch(Exception e){
			assertEquals(e.getMessage().startsWith("String"),true);
		}
	}
}
