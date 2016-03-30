package com.upeng.commons.test.lang.encrypt;

import junit.framework.TestCase;

import com.upeng.commons.lang.encrypt.Base64;

public class Base64TestCase extends TestCase{
	
	public static void testDecode(){
		String name = "小垃圾";
		String base64Name = Base64.encode(name);
		TestCase.assertEquals(name, Base64.decode(base64Name));
	}
	
	public static void testEncode(){
		String name = "彭宙硕";
		TestCase.assertEquals("5b2t5a6Z56GV", Base64.encode(name,"utf-8"));
	}

}
