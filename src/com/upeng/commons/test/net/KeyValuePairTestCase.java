package com.upeng.commons.test.net;

import com.upeng.commons.net.KeyValuePair;

import junit.framework.TestCase;

public class KeyValuePairTestCase extends TestCase {

	public void testKeyValuePair() {
		KeyValuePair kvp = new KeyValuePair();
		TestCase.assertNull(kvp.getKey());
		TestCase.assertNull(kvp.getValue());
	}

	public void testKeyValuePairStringString() {
		KeyValuePair kvp = new KeyValuePair("abc","def");
		TestCase.assertEquals("abc",kvp.getKey());
		TestCase.assertEquals("def", kvp.getValue());
	}

	public void testFormString() {
		String str = "abc=def";
		KeyValuePair kvp = KeyValuePair.formString(str);
		TestCase.assertEquals("abc",kvp.getKey());
		TestCase.assertEquals("def", kvp.getValue());
		
		str = "http://www.baidu.com?zzz=3456";
		kvp = KeyValuePair.formString(str);
		TestCase.assertEquals("zzz",kvp.getKey());
		TestCase.assertEquals("3456", kvp.getValue());
		
		str = "zzzz";
		kvp = KeyValuePair.formString(str);
		TestCase.assertEquals("zzzz",kvp.getKey());
		TestCase.assertEquals("", kvp.getValue());
	}

}
