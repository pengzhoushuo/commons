package com.upeng.commons.test.net;

import com.upeng.commons.net.URLUtils;

import junit.framework.TestCase;

public class URLUtilsTestCase extends TestCase {

	public void testEncodeStringString() {
		String str = "TestCase";
		TestCase.assertEquals(str, URLUtils.encode(str,"utf-8"));
		
		str = "单元测试";
		TestCase.assertEquals("%E5%8D%95%E5%85%83%E6%B5%8B%E8%AF%95", URLUtils.encode(str,"utf-8"));
		TestCase.assertEquals("%B5%A5%D4%AA%B2%E2%CA%D4", URLUtils.encode(str,"gb2312"));
		
		TestCase.assertEquals("%2B", URLUtils.encode("+","utf-8"));
		TestCase.assertEquals("%2B", URLUtils.encode("+","gb2312"));
	}

	public void testEncodeString() {
		String str = "TestCase";
		TestCase.assertEquals(str, URLUtils.encode(str,"utf-8"));
		
		str = "单元测试";
		TestCase.assertEquals("%E5%8D%95%E5%85%83%E6%B5%8B%E8%AF%95", URLUtils.encode(str));
	}

	public void testDecodeStringString() {
		String str = "TestCase";
		TestCase.assertEquals(str, URLUtils.encode(str,"utf-8"));
		
		TestCase.assertEquals(str, URLUtils.decode(URLUtils.encode(str,"gb2312"),"utf-8"));
		
		str = "单元测试";
		TestCase.assertEquals(str, URLUtils.decode(URLUtils.encode(str, "gb2312"),"gb2312"));
		TestCase.assertEquals("+", URLUtils.decode(URLUtils.encode("+", "gb2312"),"gb2312"));
	}

	public void testDecodeString() {
		String str = "TestCase";
		TestCase.assertEquals(str, URLUtils.encode(str,"utf-8"));
		TestCase.assertEquals(str, URLUtils.decode(URLUtils.encode(str)));
		
		str = "单元测试";
		TestCase.assertEquals(str, URLUtils.decode(URLUtils.encode(str)));
		TestCase.assertEquals("+", URLUtils.decode(URLUtils.encode("+")));
	}

	public void testIsUseHttpProtocol() {
		TestCase.assertFalse(URLUtils.isUseHttpProtocol("http"));
		TestCase.assertFalse(URLUtils.isUseHttpProtocol("http:"));
		TestCase.assertFalse(URLUtils.isUseHttpProtocol("http:/"));
		TestCase.assertFalse(URLUtils.isUseHttpProtocol("http:\\www"));
		TestCase.assertTrue(URLUtils.isUseHttpProtocol("http://www.a.com"));
		TestCase.assertTrue(URLUtils.isUseHttpProtocol("https://c.com"));
	}

	public void testAbsoluteUrl() {
		TestCase.assertEquals("http://www.peng.com/a/b/c.html",URLUtils.absoluteUrl("http://www.peng.cn", "http://www.peng.com", "http://www.peng.cn/a/b/c.html"));
	}

	public void testGetParameterValue() {
		TestCase.assertEquals("123", URLUtils.getParameterValue("abc", "http://www.peng.com?a=2&abc=123"));
		TestCase.assertEquals(null, URLUtils.getParameterValue("abc", "http://www.peng.com?a=2&zzz=123"));
	}

	public void testGetKeyValueListFromUrl() {
		TestCase.assertEquals(2, URLUtils.getKeyValueListFromUrl("http://www.peng.com?a=2&abc=123").size());
	}

}
