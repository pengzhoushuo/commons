package com.upeng.commons.test.lang.encrypt;

import java.io.UnsupportedEncodingException;

import com.upeng.commons.lang.encrypt.MD5;

import junit.framework.TestCase;

public class MD5TestCase extends TestCase {

	public void testEncode() throws UnsupportedEncodingException{
		String str = "abc";
		TestCase.assertEquals("900150983cd24fb0d6963f7d28e17f72", MD5.getHashString(str, "utf-8"));
		TestCase.assertEquals("0a40a90190da023ae7aa17771663a41e", MD5.getHashString("木子屋","gb2312"));
	}
}
