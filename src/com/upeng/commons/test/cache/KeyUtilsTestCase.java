package com.upeng.commons.test.cache;

import com.upeng.commons.cache.KeyUtils;

import junit.framework.TestCase;

public class KeyUtilsTestCase extends TestCase {
	
	public void testGenKey(){
		TestCase.assertEquals("1$3$2$ccz", KeyUtils.genKey("$", "1","3","2","ccz"));
	}

}
