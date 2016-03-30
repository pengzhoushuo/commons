package com.upeng.commons.test.lang.time;

import java.util.Date;

import com.upeng.commons.lang.time.TimeUnit;

import junit.framework.TestCase;

public class TimeUnitTestCase extends TestCase {

	public void testAddDayInt() {
		Date date = new Date();
		TestCase.assertTrue(TimeUnit.addDay(1).getTime() - (date.getTime() + 24 * 3600 * 1000) >= 0);
	}

	public void testAddDayDateInt() {
		Date date = new Date();
		TestCase.assertTrue(TimeUnit.addDay(date, 1).getTime() - (date.getTime() + 24 * 3600 * 1000) == 0);
	}

	public void testAddHourInt() {
		Date date = new Date();
		TestCase.assertTrue(TimeUnit.addHour(1).getTime() - (date.getTime() + 3600 * 1000) == 0);
	}

	public void testAddHourDateInt() {
		Date date = new Date();
		TestCase.assertTrue(TimeUnit.addHour(date, 1).getTime() - (date.getTime() + 3600 * 1000) == 0);
	}

	public void testAddMinuteInt() {
		Date date = new Date();
		TestCase.assertTrue(TimeUnit.addMinute(1).getTime() - (date.getTime() + 60 * 1000) == 0);
	}

	public void testAddMinuteDateInt() {
		Date date = new Date();
		TestCase.assertTrue(TimeUnit.addMinute(date, 1).getTime() - (date.getTime() + 60 * 1000) == 0);
	}

	public void testAddSecondInt() {
		Date date = new Date();
		TestCase.assertTrue(TimeUnit.addSecond(1).getTime() - (date.getTime() + 1000) == 0);
	}

	public void testAddSecondDateInt() {
		Date date = new Date();
		TestCase.assertTrue(TimeUnit.addSecond(date, 1).getTime() - (date.getTime() +1000) == 0);
	}
}
