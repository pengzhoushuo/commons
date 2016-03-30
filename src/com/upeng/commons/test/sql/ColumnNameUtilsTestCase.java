package com.upeng.commons.test.sql;

import com.upeng.commons.sql.ColumnNameUtils;

import junit.framework.TestCase;


public class ColumnNameUtilsTestCase extends TestCase {

	public static void testToFieldName(){
		String columnName = "accountInfo";
		TestCase.assertEquals("accountInfo",ColumnNameUtils.toFieldName(columnName));
		
		columnName = "account_Info";
		TestCase.assertEquals("accountInfo",ColumnNameUtils.toFieldName(columnName));
		
		columnName = "account_info";
		TestCase.assertEquals("accountInfo",ColumnNameUtils.toFieldName(columnName));
		
		columnName = "AccountInfo";
		TestCase.assertEquals("accountInfo",ColumnNameUtils.toFieldName(columnName));
		
		columnName = "Account_Info";
		TestCase.assertEquals("accountInfo",ColumnNameUtils.toFieldName(columnName));
		
		columnName = "ACCOUNT_INFO";
		TestCase.assertEquals("accountInfo",ColumnNameUtils.toFieldName(columnName));
		
		columnName = "Create_Date";
		TestCase.assertEquals("createDate",ColumnNameUtils.toFieldName(columnName));
	}
}
