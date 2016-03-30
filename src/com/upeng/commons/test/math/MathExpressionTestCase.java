package com.upeng.commons.test.math;

import com.upeng.commons.math.MathExpression;

import junit.framework.TestCase;

public class MathExpressionTestCase extends TestCase {

	public void testCount() throws Exception{
		String str= "";
		try{
			MathExpression.count(str);
			TestCase.assertTrue(false);
		}catch(IllegalArgumentException e){
			TestCase.assertTrue(true);
		}
		str = "1";
		TestCase.assertEquals(str, MathExpression.count(str));
		str = "0";
		TestCase.assertEquals(str, MathExpression.count(str));
		str = "-1";
		try{
			MathExpression.count(str);
			TestCase.assertTrue(false);
		}catch(IllegalArgumentException e){
			TestCase.assertTrue(true);
		}
		str = "1--1";
		try{
			MathExpression.count(str);
			TestCase.assertTrue(false);
		}catch(IllegalArgumentException e){
			TestCase.assertTrue(true);
		}
		str = "1*/1";
		try{
			MathExpression.count(str);
			TestCase.assertTrue(false);
		}catch(IllegalArgumentException e){
			TestCase.assertTrue(true);
		}
		str = "2+3+4+5+6+7";
		TestCase.assertEquals("27",MathExpression.count(str));
		str = "2-3+4-5+6-7";
		TestCase.assertEquals("-3",MathExpression.count(str));
		str = "4*3/2%5";
		TestCase.assertEquals("1", MathExpression.count(str));
		str = "4*3/2%5+2/2+2*3/2-2";
		TestCase.assertEquals("3", MathExpression.count(str));
		str = "(1+1/(1+1)+2/4+3)*(2+3)/5";
		TestCase.assertEquals("5", MathExpression.count(str));
		str = "(((1+1))+1)*2";
		TestCase.assertEquals("6", MathExpression.count(str));
		str = "((((1+1))+1)*2)+2*1+(3+1*(1-0))";
		TestCase.assertEquals("12", MathExpression.count(str));
		str = "9875455554-10/3";
		System.out.println(MathExpression.count(str));
	}
}
