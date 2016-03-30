package com.upeng.commons.test.sql;

import com.upeng.commons.sql.TableNameUtils;

import junit.framework.TestCase;

public class TableNameUtilsTestCase extends TestCase {

	public void testToClassName() {
		String tableName = "accountInfo";
		TestCase.assertEquals("Accountinfo",TableNameUtils.toClassName(tableName));
		
		tableName = "account_Info";
		TestCase.assertEquals("AccountInfo",TableNameUtils.toClassName(tableName));
		
		tableName = "account_info";
		TestCase.assertEquals("AccountInfo",TableNameUtils.toClassName(tableName));
		
		tableName = "AccountInfo";
		TestCase.assertEquals("Accountinfo",TableNameUtils.toClassName(tableName));
		
		tableName = "Account_Info";
		TestCase.assertEquals("AccountInfo",TableNameUtils.toClassName(tableName));
		
		tableName = "ACCOUNT_INFO";
		TestCase.assertEquals("AccountInfo",TableNameUtils.toClassName(tableName));
		
		tableName = "Create_Date";
		TestCase.assertEquals("CreateDate",TableNameUtils.toClassName(tableName));
	}
}
