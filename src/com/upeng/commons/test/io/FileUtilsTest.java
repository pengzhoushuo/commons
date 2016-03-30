package com.upeng.commons.test.io;

import junit.framework.TestCase;

import com.upeng.commons.io.FileUtils;

public class FileUtilsTest extends TestCase{
	
	public void testGetClassFolder(){
		TestCase.assertTrue(FileUtils.getClassFolder(FileUtilsTest.class).endsWith("io"));
	}
	
	public void testGetExtName(){
		String str = "f://abc/z.txt";
		TestCase.assertEquals("txt", FileUtils.getExtensionName(str));
	}
	
	public void testGetFileName(){
		String str = "f://abc/z.txt";
		TestCase.assertEquals("z.txt", FileUtils.getFileName(str));
		TestCase.assertEquals("abc", FileUtils.getFileName("f://abc"));
	}
}
