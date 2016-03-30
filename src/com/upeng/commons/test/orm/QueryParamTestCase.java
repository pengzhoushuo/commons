package com.upeng.commons.test.orm;

import junit.framework.TestCase;

public class QueryParamTestCase extends TestCase {

	public void testGetWhereCaseSql() throws Exception{
		CommentQueryParam param = new CommentQueryParam();
		TestCase.assertEquals("",param.getWhereCaseSql());
		param.set_se_title("just test case");
		TestCase.assertEquals(" WHERE title=?", param.getWhereCaseSql());
		param.set_ne_type("10");
		TestCase.assertEquals(" WHERE title=? AND type=?", param.getWhereCaseSql());
		param.set_dnl_createDate("2011-05-17 20:07:02");
		TestCase.assertEquals(" WHERE title=? AND createDate>=? AND type=?", param.getWhereCaseSql());
	}
	
	public void testGetObject() throws Exception{
		CommentQueryParam param = new CommentQueryParam();
		TestCase.assertEquals(0,param.getObjects().length);
		param.set_se_title("just test case");
		TestCase.assertEquals(1,param.getObjects().length);
		param.set_ne_type("10");
		TestCase.assertEquals(2,param.getObjects().length);
		param.set_dnl_createDate("2011-05-17 20:07:02");
		TestCase.assertEquals(3,param.getObjects().length);
	}
}
