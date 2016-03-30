package com.upeng.commons.test.collections;

import junit.framework.TestCase;

import com.upeng.commons.collections.CountMap;

public class CountMapTestCase extends TestCase{

	public void testPut() {
		CountMap<String> counter = new CountMap<String>();
		TestCase.assertEquals(0,counter.put("peng"));
		TestCase.assertEquals(0,counter.put("zhou"));
		TestCase.assertEquals(0,counter.put("shuo"));
		TestCase.assertEquals(1,counter.put("peng"));
		TestCase.assertEquals(2,counter.put("peng"));
	}

	public void testGet() {
		CountMap<String> counter = new CountMap<String>();
		TestCase.assertEquals(0,counter.put("peng"));
		TestCase.assertEquals(1,counter.get("peng"));
		TestCase.assertEquals(0,counter.put("zhou"));
		TestCase.assertEquals(1,counter.get("zhou"));
		TestCase.assertEquals(0,counter.put("shuo"));
		TestCase.assertEquals(1,counter.get("shuo"));
		TestCase.assertEquals(1,counter.put("peng"));
		TestCase.assertEquals(2,counter.get("peng"));
		TestCase.assertEquals(2, counter.get("peng"));
		TestCase.assertEquals(1, counter.get("zhou"));
	}

}
