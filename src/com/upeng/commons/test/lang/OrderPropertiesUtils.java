package com.upeng.commons.test.lang;

import java.io.IOException;

import junit.framework.TestCase;

import com.upeng.commons.lang.OrderedProperties;

public class OrderPropertiesUtils extends TestCase {

	public void testKeyArray() throws IOException {
		OrderedProperties p = new OrderedProperties();
		p.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("system.properties"));
		TestCase.assertNotNull(p.keyArray());
	}

	public void testKeyList() throws IOException {
		OrderedProperties p = new OrderedProperties();
		p.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("system.properties"));
		TestCase.assertNotNull(p.keyList());
	}

}
