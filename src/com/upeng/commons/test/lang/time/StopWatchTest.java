package com.upeng.commons.test.lang.time;

import com.upeng.commons.lang.time.StopWatch;

import junit.framework.TestCase;

public class StopWatchTest extends TestCase {

	public void testBegin() {
		StopWatch watch = new StopWatch();
		watch.begin();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		TestCase.assertTrue(watch.getInterval() - 1000 >= 0);
		watch.begin();
		TestCase.assertTrue(watch.getInterval() - 100 <= 0);
	}

	public void testGetInterval() {
		testBegin();
	}

}
