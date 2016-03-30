package com.upeng.commons.test.lang.encrypt;

import junit.framework.TestCase;

import com.upeng.commons.lang.encrypt.DES;

public class DESTestCase extends TestCase{

	public static void testDecode( ){
		String key="abceegga";
		String value="小垃圾";
		String sText = DES.encode(key, value);
		TestCase.assertEquals(value, DES.decode(key, sText));
	}
	
	public static void testEncode( ){
		String key="abceegga";
		String value="小垃圾";
		String sText = DES.encode(key, value);
		TestCase.assertNotSame(value, sText);
		
	}
}
