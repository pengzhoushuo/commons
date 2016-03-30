package com.upeng.commons.test.lang;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Assert;

import com.upeng.commons.lang.StringUtils;

/**
 * A JUNIT TESTCASE must extends TestCase.class
 * you can write main method for no GUI JUNIT runner
 * @author Administrator
 *
 */
public class StringUtilsTestCase extends TestCase {

	public void testIsEmpty() {
		TestCase.assertTrue(StringUtils.isEmpty(null));
		TestCase.assertTrue(StringUtils.isEmpty(""));
		TestCase.assertFalse(StringUtils.isEmpty(" "));
		TestCase.assertFalse(StringUtils.isEmpty("a"));
	}

	public void testIsNotEmpty() {
		TestCase.assertFalse(StringUtils.isNotEmpty(null));
		TestCase.assertFalse(StringUtils.isNotEmpty(""));
		TestCase.assertTrue(StringUtils.isNotEmpty(" "));
		TestCase.assertTrue(StringUtils.isNotEmpty("a"));
	}

	public void testIsBlank() {
		TestCase.assertTrue(StringUtils.isBlank(null));
		TestCase.assertTrue(StringUtils.isBlank(""));
		TestCase.assertTrue(StringUtils.isBlank(" "));
		TestCase.assertFalse(StringUtils.isBlank("a"));
	}

	public void testIsNotBlank() {
		TestCase.assertFalse(StringUtils.isNotBlank(null));
		TestCase.assertFalse(StringUtils.isNotBlank(""));
		TestCase.assertFalse(StringUtils.isNotBlank(" "));
		TestCase.assertTrue(StringUtils.isNotBlank("a"));
	}

	public void testIsIntNumString() {
		TestCase.assertFalse(StringUtils.isIntNumString(null));
		TestCase.assertFalse(StringUtils.isIntNumString(""));
		TestCase.assertFalse(StringUtils.isIntNumString("1 "));
		TestCase.assertFalse(StringUtils.isIntNumString("a"));
		TestCase.assertTrue(StringUtils.isIntNumString("156"));
	}

	public void testIsNumString() {
		TestCase.assertFalse(StringUtils.isNumString(null));
		TestCase.assertFalse(StringUtils.isNumString(""));
		TestCase.assertTrue(StringUtils.isNumString("1 "));
		TestCase.assertFalse(StringUtils.isNumString("a"));
		TestCase.assertTrue(StringUtils.isNumString("156"));
		TestCase.assertTrue(StringUtils.isNumString("0.0156"));
	}

	public void testToUppderCase() {
		TestCase.assertEquals("ABC", StringUtils.toUppderCase("abc"));
		TestCase.assertEquals("ABC", StringUtils.toUppderCase("aBc"));
		TestCase.assertEquals("ABC", StringUtils.toUppderCase("Abc"));
	}

	public void testToLowerCase() {
		TestCase.assertEquals("abc", StringUtils.toLowerCase("ABC"));
		TestCase.assertEquals("abc", StringUtils.toLowerCase("aBc"));
		TestCase.assertEquals("abc", StringUtils.toLowerCase("Abc"));
	}

	public void testIsInListStringStringArray() {
		assertTrue(StringUtils.isInList("abc", "ee","abc","ab1"));
		assertFalse(StringUtils.isInList("abcd", "ee","abc","ab1"));
	}

	public void testIsInListStringBooleanStringArray() {
		assertTrue(StringUtils.isInList("abc", true, "ABC","abz"));
		assertFalse(StringUtils.isInList("abc", false, "ABC","abz"));
		assertFalse(StringUtils.isInList("abc", false, "ABC","abz"));
	}

	public void testStartsWithIgnoreCaseStringString() {
		assertTrue(StringUtils.startsWithIgnoreCase("abcdeAB", "AB"));
		assertFalse(StringUtils.startsWithIgnoreCase("adbcdeAB", "AB"));
	}

	public void testStartsWithIgnoreCaseStringStringInt() {
		assertTrue(StringUtils.startsWithIgnoreCase("dabcde", "ab", 1));
		assertFalse(StringUtils.startsWithIgnoreCase("dabcde", "ab", 2));
	}

	public void testStartsWithStringString() {
		assertTrue(StringUtils.startsWith("abc", "ab"));
		assertFalse(StringUtils.startsWith("abc", "bc"));
	}

	public void testStartsWithStringStringInt() {
		assertTrue(StringUtils.startsWith("dabc", "ab", 1));
		assertFalse(StringUtils.startsWith("abc", "bc",3));
	}

	public void testGetBytes() {
		TestCase.assertEquals(new String(StringUtils.getBytes("abc")),"abc");
	}

	public void testToStringInt() {
		assertEquals(StringUtils.toString(12),"12");
	}

	public void testToStringDouble() {
		assertEquals(StringUtils.toString(12.0),"12.0");
	}

	public void testToStringFloat() {
		assertEquals(StringUtils.toString(0.12),"0.12");
	}

	public void testToStringLong() {
		assertEquals(StringUtils.toString(12),"12");
	}

	public void testToStringBoolean() {
		assertEquals(StringUtils.toString(true),"true");
		assertEquals(StringUtils.toString(false),"false");
	}

	public void testToStringChar() {
		assertEquals(StringUtils.toString('c'),"c");
	}

	public void testToHexString() {
		StringUtils.toHexString(StringUtils.getBytes("123"));
	}

	public void testToStringStringString() {
		assertEquals(StringUtils.toString(null, "abcde"),"abcde");
	}

	public void testToStringList() {
		assertTrue(true);		
		List<Integer> intList = new ArrayList<Integer>();
		intList.add(1);
		intList.add(2);
		intList.add(3);
		List<String> strList = new ArrayList<String>();
		strList.add("1");
		strList.add("2");
		strList.add("3");
		assertEquals(StringUtils.toStringList(intList),strList);
	}

	public void testToStringArray() {
		Assert.assertArrayEquals(StringUtils.toStringArray(new int[]{1,3,5}), new String[]{"1","3","5"});
	}

	public void testContains() {
		assertTrue(StringUtils.contains("abcde", "cd"));
		assertTrue(StringUtils.contains("abcde", "de"));
		assertFalse(StringUtils.contains("abcde", "ad"));
	}

	public void testSplitString() {
		Assert.assertArrayEquals(StringUtils.split("abc#qwe# aa"), new String[]{"abc","qwe","aa"});
	}

	public void testSplitStringCharBoolean() {
		Assert.assertArrayEquals(StringUtils.split("abc@qwe@ aa", '@', true), new String[]{"abc","qwe","aa"});
		Assert.assertArrayEquals(StringUtils.split("abc@qwe@ aa", '@', false), new String[]{"abc","qwe"," aa"});
	}

	public void testIsUpperCase() {
		assertTrue(StringUtils.isUpperCase("ABC"));
		assertTrue(StringUtils.isUpperCase("1ABC"));
		assertFalse(StringUtils.isUpperCase("Abc"));
		assertFalse(StringUtils.isUpperCase("abc"));
	}

	public void testIsLowerCase() {
		assertFalse(StringUtils.isLowerCase("ABC"));
		assertFalse(StringUtils.isLowerCase("1ABC"));
		assertFalse(StringUtils.isLowerCase("Abc"));
		assertTrue(StringUtils.isLowerCase("abc"));
		assertTrue(StringUtils.isLowerCase("a1bc"));
	}

	public void testFirstLetterUpper() {
		assertEquals(StringUtils.firstLetterUpper("abc"),"Abc");
		assertEquals(StringUtils.firstLetterUpper("ABC"),"ABC");
		assertEquals(StringUtils.firstLetterUpper("Abc"),"Abc");
	}

	public void testFirstLetterLower() {
		assertEquals(StringUtils.firstLetterLower("abc"),"abc");
		assertEquals(StringUtils.firstLetterLower("ABC"),"aBC");
		assertEquals(StringUtils.firstLetterLower("Abc"),"abc");
	}

	public void testGetSegments() {
		Assert.assertArrayEquals(StringUtils.getSegments("abc", 2), new String[]{"ab","c"});
		Assert.assertArrayEquals(StringUtils.getSegments("abcd", 2), new String[]{"ab","cd"});
	}

	public void testSubString() {
		assertEquals(StringUtils.subString("abc", 1, 8),"bc");
		assertEquals(StringUtils.subString("abcd", 1, 4),"bcd");
	}
	
	public void testLength(){
		assertEquals(StringUtils.length(null),0);
		assertEquals(StringUtils.length(""),0);
		assertEquals(StringUtils.length(" "),1);
		assertEquals(StringUtils.length("abc"),3);
	}
	
	public void testOmitString(){
		String source = "abcde";
		assertEquals(StringUtils.omitString(source, 2, "###"), "ab###");
		assertEquals(StringUtils.omitString(source, 3),"abc...");
	}
	
	public static void testSubstringBefore(){
		String source = "abc";
		assertEquals(StringUtils.substringBefore(source, "a"),"");
		assertEquals(StringUtils.substringBefore("abcba", "b") , "a");
		assertEquals(StringUtils.substringBefore("abc", "c"), "ab" );
		System.out.println(StringUtils.substringBefore("abc", ""));
		assertEquals(StringUtils.substringBefore("abc", ""), "");
		assertEquals(StringUtils.substringBefore("abc", null) ,"abc");
		assertEquals(StringUtils.substringBefore("abc", "a") ,"");
		assertEquals(StringUtils.substringBefore("abc", "c") ,"ab");
		assertEquals(StringUtils.substringBefore("abc", "b") ,"a");
		assertEquals(StringUtils.substringBefore("abc", "") ,"");
		assertEquals(StringUtils.substringBefore("abc", null) ,"abc");
		assertEquals(StringUtils.substringBefore("abc", " ") ,"");
	}
	
	public static void testSubstringAfter(){
		assertEquals(StringUtils.substringAfter(null, null) , null);
		assertEquals(StringUtils.substringAfter("", null) , "");
		assertEquals(StringUtils.substringAfter("abc", null) , "");
		assertEquals(StringUtils.substringAfter("abc", "a") , "bc");
		assertEquals(StringUtils.substringAfter("abcba", "b"), "cba");
		assertEquals(StringUtils.substringAfter("abc", "c") , "");
		assertEquals(StringUtils.substringAfter("abc", "d"), "");
		assertEquals(StringUtils.substringAfter("abc", "") , "abc");
		assertEquals(StringUtils.substringAfter("abc", "a") , "bc");
		assertEquals(StringUtils.substringAfter("abc", "b") , "c");
		assertEquals(StringUtils.substringAfter("abc", "c") , "");
		assertEquals(StringUtils.substringAfter("abc", "") , "abc");
		assertEquals(StringUtils.substringAfter("abc", null) , "");
		assertEquals(StringUtils.substringAfter(null, "abc") , null);
		assertEquals(StringUtils.substringAfter("abc", " ") , "");
		assertEquals(StringUtils.substringAfter("abcb", "b") , "cb");
	}
	
	public static void testIsDateString(){
		assertTrue(StringUtils.isDateString("2011-7-20"));
		assertTrue(StringUtils.isDateString("2011-7-20 15:12:14"));
		assertFalse(StringUtils.isDateString("20110720"));
	}
}
