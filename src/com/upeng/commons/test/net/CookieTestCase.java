package com.upeng.commons.test.net;

import com.upeng.commons.net.Cookie;

import junit.framework.TestCase;

public class CookieTestCase extends TestCase {

	public void testGetKey() {
		String str = "_user=deleted; expires=Mon, 24-Aug-2009 06:39:14 GMT; path=/; domain=.kaixin001.com";
		Cookie cookie = Cookie.fromStr(str);
		TestCase.assertEquals("_user", cookie.getName());
		TestCase.assertEquals("deleted", cookie.getValue());
		TestCase.assertEquals("Mon, 24-Aug-2009 06:39:14 GMT", cookie.getExpireDate());
		TestCase.assertEquals("/", cookie.getPath());
		TestCase.assertEquals(".kaixin001.com", cookie.getDomain());
		TestCase.assertEquals("name=_user,domain=.kaixin001.com,path=/", cookie.getKey());
	}

	public void testFromStr() {
		String str = "_user=deleted; expires=Mon, 24-Aug-2009 06:39:14 GMT; path=/; domain=.kaixin001.com";
		Cookie cookie = Cookie.fromStr(str);
		TestCase.assertEquals("_user", cookie.getName());
		TestCase.assertEquals("deleted", cookie.getValue());
		TestCase.assertEquals("Mon, 24-Aug-2009 06:39:14 GMT", cookie.getExpireDate());
		TestCase.assertEquals("/", cookie.getPath());
		TestCase.assertEquals(".kaixin001.com", cookie.getDomain());
	}

}
