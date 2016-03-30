package com.upeng.commons.test.lang;

import com.upeng.commons.lang.PackageUtils;

import junit.framework.TestCase;

public class PackageUtilsTestCase extends TestCase {

	public void testGetClasses() throws ClassNotFoundException {
		TestCase.assertNotNull(PackageUtils.getClasses("com.upeng.commons.test.lang"));
		try{
			PackageUtils.getClasses("com.upeng.commons.test.lafdfdfng");
			TestCase.assertTrue(false);
		}catch(ClassNotFoundException e){
			TestCase.assertTrue(true);
		}
	}

}
