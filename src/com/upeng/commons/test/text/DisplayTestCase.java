package com.upeng.commons.test.text;

import com.upeng.commons.text.Display;

import junit.framework.TestCase;

public class DisplayTestCase extends TestCase {

	public void testDisplayStringString() {
		TestCase.assertEquals("abc",Display.display(null, "abc"));
		TestCase.assertEquals("def",Display.display("def", "abc"));
	}

	public void testDisplayString() {
		TestCase.assertEquals("",Display.display(null));
		TestCase.assertEquals("def",Display.display("def"));
	}

}
