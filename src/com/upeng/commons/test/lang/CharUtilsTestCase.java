package com.upeng.commons.test.lang;

import junit.framework.TestCase;

import com.upeng.commons.lang.CharUtils;

public class CharUtilsTestCase extends TestCase {
	
	public void testIntArray1(){
		char c = 'a';
		char[] cs = {'a','b','c'};
		TestCase.assertTrue(CharUtils.inArray(c, cs));
		TestCase.assertFalse(CharUtils.notInArray(c, cs));
	}
	
	public void testIntArray2(){
		char c = 'a';
		char[] cs = {'z','b','a'};
		TestCase.assertTrue(CharUtils.inArray(c, cs));
		TestCase.assertFalse(CharUtils.notInArray(c, cs));
	}
	
	public void testIntArray3(){
		char c = 'a';
		char[] cs = {'z','b','t'};
		TestCase.assertFalse(CharUtils.inArray(c, cs));
		TestCase.assertTrue(CharUtils.notInArray(c, cs));
	}
	
	public void testIntArray4(){
		char c = 'a';
		char[] cs = null;
		TestCase.assertFalse(CharUtils.inArray(c, cs));
		TestCase.assertTrue(CharUtils.notInArray(c, cs));
	}
	
	public void testToChar(){
		String s = "a";
		TestCase.assertEquals('a', CharUtils.toChar(s));
		try{
			TestCase.assertEquals('a', CharUtils.toChar("abc"));
			TestCase.assertTrue(false);
		}catch(Exception e){
			TestCase.assertTrue(true);
		}
	}
	
	public void testIsChinese(){
		char c = '彭';
		TestCase.assertTrue(CharUtils.isChinese(c));
		c = '。';
		TestCase.assertTrue(CharUtils.isChinese(c));
		c = '/';
		TestCase.assertFalse(CharUtils.isChinese(c));
		c = 'a';
		TestCase.assertFalse(CharUtils.isChinese(c));
	}
	
	public void testIsContainsChar(){
		String str = "abc/az/1334/019";
		TestCase.assertFalse(CharUtils.isContinsChineseChar(str));
		str = "ddd中abc";
		TestCase.assertTrue(CharUtils.isContinsChineseChar(str));
	}
}
