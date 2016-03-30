package com.upeng.commons.test.collections;

import com.upeng.commons.collections.ArrayStack;

import junit.framework.TestCase;

public class ArrayStackTestCase extends TestCase {

	public void testArrayStack() {
		ArrayStack<Object> stack = new ArrayStack<Object>();
		TestCase.assertEquals(0, stack.size());
	}

	public void testArrayStackInt() {
		ArrayStack<Object> stack = new ArrayStack<Object>();
		TestCase.assertEquals(0, stack.size());
	}

	public void testEmpty() {
		ArrayStack<Object> stack = new ArrayStack<Object>();
		TestCase.assertTrue(stack.isEmpty());
		stack.add("abc");
		TestCase.assertFalse(stack.isEmpty());
	}

	public void testPeek() {
		ArrayStack<Object> stack = new ArrayStack<Object>();
		TestCase.assertTrue(stack.isEmpty());
		stack.add("abc");
		TestCase.assertFalse(stack.isEmpty());
		TestCase.assertEquals("abc", stack.peek());
		TestCase.assertFalse(stack.isEmpty());;
	}

	public void testPeekInt() {
		ArrayStack<Object> stack = new ArrayStack<Object>();
		TestCase.assertTrue(stack.isEmpty());
		stack.add("eee");
		stack.add("abc");
		TestCase.assertFalse(stack.isEmpty());
		TestCase.assertEquals("abc", stack.peek(0));
		TestCase.assertEquals(2, stack.size());;
	}

	public void testPop() {
		ArrayStack<Object> stack = new ArrayStack<Object>();
		TestCase.assertTrue(stack.isEmpty());
		stack.add("eee");
		stack.add("abc");
		TestCase.assertFalse(stack.isEmpty());
		TestCase.assertEquals("abc", stack.pop());
		TestCase.assertEquals(1, stack.size());;
	}

	public void testPush() {
		ArrayStack<Object> stack = new ArrayStack<Object>();
		TestCase.assertTrue(stack.isEmpty());
		stack.add("eee");
		stack.add("abc");
		TestCase.assertFalse(stack.isEmpty());
		TestCase.assertEquals("zzz", stack.push("zzz"));
		TestCase.assertEquals(3, stack.size());;
	}

	public void testSearch() {
		ArrayStack<Object> stack = new ArrayStack<Object>();
		TestCase.assertTrue(stack.isEmpty());
		stack.add("eee");
		stack.add("abc");
		TestCase.assertFalse(stack.isEmpty());
		TestCase.assertEquals(1, stack.search("abc"));
		TestCase.assertEquals(2, stack.size());;
	}

}
