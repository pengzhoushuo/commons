package com.upeng.commons.test.lang;

import java.util.Calendar;
import java.util.Date;

import com.upeng.commons.lang.DateUtils;

import junit.framework.TestCase;

public class DateUtilsTestCase extends TestCase {

	public void testAdd() {
		Date d = new Date();
		Date d2 = DateUtils.add(d, 1, Calendar.HOUR);
		TestCase.assertTrue(d2.getTime() - d.getTime() >= 3600*1000);
	}

	public void testAddYear() {
		Date d = new Date();
		Date d2 = DateUtils.addYear(d, 1);
		TestCase.assertTrue(d2.getTime() - d.getTime() >= 365 * 24 * 3600*1000);
	}

	public void testAddMonth() {
		Date d = new Date();
		Date d2 = DateUtils.addMonth(d, 1);
		TestCase.assertTrue(d2.getTime() - d.getTime() >= 28 * 24 * 3600*1000);
	}

	public void testAddDate() {
		Date d = new Date();
		Date d2 = DateUtils.addDate(d, 1);
		TestCase.assertTrue(d2.getTime() - d.getTime() >= 1 * 24 * 3600*1000);
	}

	public void testAddHour() {
		Date d = new Date();
		Date d2 = DateUtils.addHour(d, 1);
		TestCase.assertTrue(d2.getTime() - d.getTime() >= 3600*1000);
	}

	public void testAddMinute() {
		Date d = new Date();
		Date d2 = DateUtils.addMinute(d, 1);
		TestCase.assertTrue(d2.getTime() - d.getTime() >= 60*1000);
	}

	public void testAddSecond() {
		Date d = new Date();
		Date d2 = DateUtils.addSecond(d, 1);
		TestCase.assertTrue(d2.getTime() - d.getTime() >= 1000);;
	}

	public void testToCalendar() {
		Date d = new Date();
		TestCase.assertEquals(d.getTime(),DateUtils.toCalendar(d).getTimeInMillis());
	}

	public void testToDateCalendar() {
		Calendar c = Calendar.getInstance();
		TestCase.assertEquals(DateUtils.toDate(c).getTime(), c.getTimeInMillis());
	}

	@SuppressWarnings("deprecation")
	public void testBuildDateIntIntInt() {
		int year = 1985;
		int month = 4;
		int date = 27;
		int hour = 0;
		int minute = 0;
		int second = 0;
		Date d = DateUtils.buildDate(year, month, date);
		TestCase.assertEquals(85, d.getYear());
		TestCase.assertEquals(month-1, d.getMonth());
		TestCase.assertEquals(date, d.getDate());
		TestCase.assertEquals(hour, d.getHours());
		TestCase.assertEquals(minute, d.getMinutes());
		TestCase.assertEquals(second, d.getSeconds());
	}

	@SuppressWarnings("deprecation")
	public void testBuildDateIntIntIntIntIntInt() {
		int year = 1985;
		int month = 4;
		int date = 27;
		int hour = 0;
		int minute = 0;
		int second = 0;
		Date d = DateUtils.buildDate(year, month, date, hour, minute, second);
		TestCase.assertEquals(85, d.getYear());
		TestCase.assertEquals(month-1, d.getMonth());
		TestCase.assertEquals(date, d.getDate());
		TestCase.assertEquals(hour, d.getHours());
		TestCase.assertEquals(minute, d.getMinutes());
		TestCase.assertEquals(second, d.getSeconds());
	}

	@SuppressWarnings("deprecation")
	public void testToDateString() {
		String str1 = "1985-04-27";
		Date d1 = DateUtils.toDate(str1);
		TestCase.assertEquals(85, d1.getYear());
		TestCase.assertEquals(4-1, d1.getMonth());
		TestCase.assertEquals(27, d1.getDate());
		
		String str2 = "1985-04-27 11:10:10";
		Date d2 = DateUtils.toDate(str2);
		TestCase.assertEquals(85, d2.getYear());
		TestCase.assertEquals(4-1, d2.getMonth());
		TestCase.assertEquals(27, d2.getDate());
		TestCase.assertEquals(11, d2.getHours());
		TestCase.assertEquals(10, d2.getMinutes());
		TestCase.assertEquals(10, d2.getSeconds());
		
		String str3 = "198zzzfdf27";
		try{
			DateUtils.toDate(str3);
			TestCase.assertTrue(false);
		}catch(Exception e){
			TestCase.assertTrue(true);
		}
	}

	@SuppressWarnings("deprecation")
	public void testGetOnlyDate() {
		Date currentDate = new Date();
		Date date = DateUtils.getOnlyDate();
		TestCase.assertEquals(currentDate.getYear(), date.getYear());
		TestCase.assertEquals(currentDate.getMonth(), date.getMonth());
		TestCase.assertEquals(currentDate.getDate(), date.getDate());
		TestCase.assertEquals(0, date.getHours());
		TestCase.assertEquals(0, date.getMinutes());
		TestCase.assertEquals(0, date.getSeconds());
	}

}
