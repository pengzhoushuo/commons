package com.upeng.commons.test.text;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.upeng.commons.text.DateFormatUtils;

import junit.framework.TestCase;

public class DateFormatUtilsTestCase extends TestCase {

	public void testFormatDateFormatDateString() {
		Date d = new Date();
		TestCase.assertEquals("2009-12-12",DateFormatUtils.format(DateFormatUtils.getDefaultDateFormat(), null, "2009-12-12"));
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		TestCase.assertEquals(df.format(d), DateFormatUtils.format(df, d, "2009-10-10"));
	}

	public void testFormatDateFormatDate() {
		Date d = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		TestCase.assertEquals(df.format(d), DateFormatUtils.format(df, d));
	}

	public void testDefaultFormat() {
		Date d = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		TestCase.assertEquals(df.format(d), DateFormatUtils.defaultFormat(d));
	}

	@SuppressWarnings("deprecation")
	public void testParseDateFormatString() throws ParseException {
		String str = "2009-10-11";
		Date date = DateFormatUtils.parse(DateFormatUtils.getDefaultDateFormat(), str);
		TestCase.assertEquals(10 - 1, date.getMonth());
		TestCase.assertEquals(11, date.getDate());
		
		str = "2009-10-11 20:10:12";
		date = DateFormatUtils.parse(DateFormatUtils.getDefaultTimeFormat(), str);
		TestCase.assertEquals(10 - 1, date.getMonth());
		TestCase.assertEquals(11, date.getDate());
		
		TestCase.assertEquals(20, date.getHours());
		TestCase.assertEquals(10, date.getMinutes());
		TestCase.assertEquals(12, date.getSeconds());
		
		str = "dfdferer";
		try{
			DateFormatUtils.parse(DateFormatUtils.getDefaultTimeFormat(), str);
			TestCase.assertTrue(false);		
		}catch(ParseException e){
			TestCase.assertTrue(true);
		}
	}

	public void testParseDateFormatStringDate() {
		String str = "dfdferer";
		Date date = DateFormatUtils.parse(DateFormatUtils.getDefaultTimeFormat(), str, new Date());
		TestCase.assertTrue(new Date().getTime() - date.getTime() <= 100);
	}

}
