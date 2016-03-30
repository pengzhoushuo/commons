package com.upeng.commons.test.collections;

import junit.framework.TestCase;

import com.upeng.commons.collections.CharStack;

public class CharStackTestCase extends TestCase{
	
	public void testPopUntil(){
		String str = "My name is unclpeng. Come form China. Ha Ha";
		CharStack stack = new CharStack();
		stack.pushString(str);
		TestCase.assertEquals(" Ha Ha", stack.popUntil('.'));
	}
	
	public void testPopUntil2(){
		String str = "My name is unclpeng. Come form China. Ha Ha";
		CharStack stack = new CharStack();
		stack.pushString(str);
		TestCase.assertEquals("Ha", stack.popUntil('.',' '));
	}
	
	public void testPopFromLastUntil(){
		String str = "My name is unclpeng. Come form China. Ha Ha";
		CharStack stack = new CharStack();
		stack.pushString(str);
		TestCase.assertEquals(" Come form China. Ha Ha", stack.popFromLastUntil('.'));
	}
	
	public void testPopFromLastUntil2(){
		String str = "My name is unclpeng. Come form China. Ha Ha";
		CharStack stack = new CharStack();
		stack.pushString(str);
		TestCase.assertEquals(" Come form China. Ha Ha", stack.popFromLastUntil('.','H'));
	}
}
