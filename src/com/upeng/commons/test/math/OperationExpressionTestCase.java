package com.upeng.commons.test.math;

import junit.framework.TestCase;

import com.upeng.commons.math.OperationExpression;


public class OperationExpressionTestCase extends TestCase{

	public static void testCountNumberEqual() throws Exception{
		String operator = "==";
		String data1 = "2";
		String data2 = "2.0000";
		assertEquals(true, OperationExpression.count(data1, operator, data2));
		assertEquals(true, OperationExpression.count("0.0", operator, "0.0"));
		assertEquals(false, OperationExpression.count("3.0", operator, "3.01"));
		try{
			assertEquals(false, OperationExpression.count("3.0", operator, "3.01abcde"));
		}catch(Exception e){
			assertTrue(true);
		}
	}
	
	public static void testCountNumberNotEqual() throws Exception{
		String operator = "!=";
		String data1 = "2";
		String data2 = "2.0000";
		assertEquals(false, OperationExpression.count(data1, operator, data2));
		assertEquals(false, OperationExpression.count("0.0", operator, "0.0"));
		assertEquals(true, OperationExpression.count("3.0", operator, "3.01"));
		assertEquals(true, OperationExpression.count("3.0", operator, "3.01abcde"));
	}
	
	public static void testCountNumberMore() throws Exception{
		String operator = ">";
		String data1 = "2";
		String data2 = "2.0000";
		assertEquals(false, OperationExpression.count(data1, operator, data2));
		assertEquals(false, OperationExpression.count("0.0", operator, "0.0"));
		assertEquals(false, OperationExpression.count("3.0", operator, "3.01"));
		assertEquals(true, OperationExpression.count("4.0", operator, "3.99"));
		try{
			assertEquals(false, OperationExpression.count("3.0", operator, "3.01abcde"));
		}catch(Exception e){
			assertTrue(true);
		}
	}
	
	public static void testCountMoreNumberEqual() throws Exception{
		String operator = ">=";
		String data1 = "2";
		String data2 = "2.0000";
		assertEquals(true, OperationExpression.count(data1, operator, data2));
		assertEquals(true, OperationExpression.count("0.0", operator, "0.0"));
		assertEquals(false, OperationExpression.count("3.0", operator, "3.01"));
		assertEquals(true, OperationExpression.count("4.0", operator, "3.99"));
		try{
			assertEquals(false, OperationExpression.count("3.0", operator, "3.01abcde"));
		}catch(Exception e){
			assertTrue(true);
		}
	}
	
	public static void testCountNumberLess() throws Exception{
		String operator = "<";
		String data1 = "2";
		String data2 = "2.0000";
		assertEquals(false, OperationExpression.count(data1, operator, data2));
		assertEquals(false, OperationExpression.count("0.0", operator, "0.0"));
		assertEquals(true, OperationExpression.count("3.0", operator, "3.01"));
		assertEquals(false, OperationExpression.count("4.0", operator, "3.99"));
		try{
			assertEquals(false, OperationExpression.count("3.0", operator, "3.01abcde"));
		}catch(Exception e){
			assertTrue(true);
		}
	}
	
	public static void testCountNumberLessEqual() throws Exception{
		String operator = "<=";
		String data1 = "2";
		String data2 = "2.0000";
		assertEquals(true, OperationExpression.count(data1, operator, data2));
		assertEquals(true, OperationExpression.count("0.0", operator, "0.0"));
		assertEquals(true, OperationExpression.count("3.0", operator, "3.01"));
		assertEquals(false, OperationExpression.count("4.0", operator, "3.99"));
		try{
			assertEquals(false, OperationExpression.count("3.0", operator, "3.01abcde"));
		}catch(Exception e){
			assertTrue(true);
		}
	}
	
	public static void testCountNumberIn() throws Exception{
		String operator = "In";
		String data1 = "2";
		String data2 = "2.0000";
		assertEquals(true, OperationExpression.count(data1, operator, data2));
		assertEquals(true, OperationExpression.count("0.0", operator, "0.0"));
		assertEquals(false, OperationExpression.count("3.0", operator, "3.01"));
		assertEquals(false, OperationExpression.count("4.0", operator, "3.99"));
		assertEquals(true, OperationExpression.count("4.0", operator, "3.99,4.0"));
		assertEquals(true, OperationExpression.count("4.0", operator, "[3.99,4.0,3]"));
		assertEquals(false, OperationExpression.count("4.0", operator, "[3.99,5.0,3]"));
		try{
			assertEquals(false, OperationExpression.count("3.0", operator, "3.01abcde,cc"));
		}catch(Exception e){
			assertTrue(true);
		}
	}
	
	public static void testCountNumberNotIn() throws Exception{
		String operator = "not In";
		String data1 = "2";
		String data2 = "2.0000";
		assertEquals(false, OperationExpression.count(data1, operator, data2));
		assertEquals(false, OperationExpression.count("0.0", operator, "0.0"));
		assertEquals(true, OperationExpression.count("3.0", operator, "3.01"));
		assertEquals(true, OperationExpression.count("4.0", operator, "3.99"));
		assertEquals(false, OperationExpression.count("4.0", operator, "3.99,4.0"));
		assertEquals(false, OperationExpression.count("4.0", operator, "[3.99,4.0,3]"));
		assertEquals(true, OperationExpression.count("4.0", operator, "[3.99,5.0,3]"));
		assertEquals(true, OperationExpression.count("3.0", operator, "3.01abcde"));
	}
	
	public static void testCountStringEqual() throws Exception{
		String operator = "==";
		String data1 = "2a";
		String data2 = "2a";
		assertEquals(true, OperationExpression.count(data1, operator, data2));
		assertEquals(true, OperationExpression.count("0.0b", operator, "0.0b"));
		assertEquals(false, OperationExpression.count("3.0c", operator, "3.01c"));
	}
	
	public static void testCountStringNotEqual() throws Exception{
		String operator = "!=";
		String data1 = "2a";
		String data2 = "2a";
		assertEquals(false, OperationExpression.count(data1, operator, data2));
		assertEquals(false, OperationExpression.count("0.0b", operator, "0.0b"));
		assertEquals(true, OperationExpression.count("3.0c", operator, "3.01c"));
	}
	
	public static void testCountStringMore() throws Exception{
		String operator = ">";
		try{
			assertEquals(false, OperationExpression.count("3.0c", operator, "3.01c"));
		}catch(Exception e){
			assertTrue(true);
		}
	}
	
	public static void testCountMoreStringEqual() throws Exception{
		String operator = ">=";
		try{
			assertEquals(false, OperationExpression.count("3.0c", operator, "3.01c"));
		}catch(Exception e){
			assertTrue(true);
		}
	}
	
	public static void testCountStringLess() throws Exception{
		String operator = "<";
		try{
			assertEquals(false, OperationExpression.count("3.0c", operator, "3.01c"));
		}catch(Exception e){
			assertTrue(true);
		}
	}
	
	public static void testCountStringLessEqual() throws Exception{
		String operator = "<=";
		try{
			assertEquals(false, OperationExpression.count("3.0c", operator, "3.01c"));
		}catch(Exception e){
			assertTrue(true);
		}
	}
	
	public static void testCountStringIn() throws Exception{
		String operator = "In";
		String data1 = "2z";
		String data2 = "2z";
		assertEquals(true, OperationExpression.count(data1, operator, data2));
		assertEquals(true, OperationExpression.count("0.0z", operator, "0.0z"));
		assertEquals(false, OperationExpression.count("3.0z", operator, "3.01z"));
		assertEquals(false, OperationExpression.count("4.0z", operator, "3.99z"));
		assertEquals(true, OperationExpression.count("4.0z", operator, "3.99z,4.0z"));
		assertEquals(true, OperationExpression.count("4.0z", operator, "[3.99z,4.0z,3z]"));
		assertEquals(false, OperationExpression.count("4.0z", operator, "[3.99z,5.0z,3z]"));
		assertEquals(false, OperationExpression.count("3.0z", operator, "3.01abcde"));
	}
	
	public static void testCountStringNotIn() throws Exception{
		String operator = "not In";
		String data1 = "2z";
		String data2 = "2z";
		assertEquals(false, OperationExpression.count(data1, operator, data2));
		assertEquals(false, OperationExpression.count("0.0z", operator, "0.0z"));
		assertEquals(true, OperationExpression.count("3.0z", operator, "3.01z"));
		assertEquals(true, OperationExpression.count("4.0z", operator, "3.99z"));
		assertEquals(false, OperationExpression.count("4.0z", operator, "3.99z,4.0z"));
		assertEquals(false, OperationExpression.count("4.0z", operator, "[3.99z,4.0z,3z]"));
		assertEquals(true, OperationExpression.count("4.0z", operator, "[3.99z,5.0z,3z]"));
		assertEquals(true, OperationExpression.count("3.0z", operator, "3.01abcde"));
	}
	
	public static void testCountDateEqual() throws Exception{
		String operator = "==";
		String data1 = "2011-7-21";
		String data2 = "2011-7-21 0:0:0";
		assertEquals(true, OperationExpression.count(data1, operator, data2));
		assertEquals(true, OperationExpression.count("2011-7-21", operator, "2011-7-21"));
		assertEquals(false, OperationExpression.count("2011-7-21", operator, "2011-7-20"));
		assertEquals(false, OperationExpression.count("2011-7-21 20:10:35", operator, "2011-7-21 20:10:36"));
		assertEquals(false, OperationExpression.count("2011.7.21", operator, "2011.7.21 0:0:0"));
	}
	
	public static void testCountDateNotEqual() throws Exception{
		String operator = "!=";
		String data1 = "2011-7-21";
		String data2 = "2011-7-21 0:0:0";
		assertEquals(false, OperationExpression.count(data1, operator, data2));
		assertEquals(false, OperationExpression.count("2011-7-21", operator, "2011-7-21"));
		assertEquals(true, OperationExpression.count("2011-7-21", operator, "2011-7-20"));
		assertEquals(true, OperationExpression.count("2011-7-21 20:10:35", operator, "2011-7-21 20:10:36"));
		assertEquals(true, OperationExpression.count("2011.7.21", operator, "2011.7.21 0:0:0"));
	}
	
	public static void testCountDateMore() throws Exception{
		String operator = ">";
		String data1 = "2011-7-21";
		String data2 = "2011-7-21 0:0:0";
		assertEquals(false, OperationExpression.count(data1, operator, data2));
		assertEquals(false, OperationExpression.count("2011-7-21", operator, "2011-7-21"));
		assertEquals(true, OperationExpression.count("2011-7-21", operator, "2011-7-20"));
		assertEquals(false, OperationExpression.count("2011-7-21 20:10:35", operator, "2011-7-21 20:10:36"));
		assertEquals(true, OperationExpression.count("2011-7-21 21:10:35", operator, "2011-7-21 20:10:36"));
	}

	
	public static void testCountDateLess() throws Exception{
		String operator = "<";
		String data1 = "2011-7-21";
		String data2 = "2011-7-21 0:0:0";
		assertEquals(false, OperationExpression.count(data1, operator, data2));
		assertEquals(false, OperationExpression.count("2011-7-21", operator, "2011-7-21"));
		assertEquals(false, OperationExpression.count("2011-7-21", operator, "2011-7-20"));
		assertEquals(true, OperationExpression.count("2011-7-21 20:10:35", operator, "2011-7-21 20:10:36"));
		assertEquals(false, OperationExpression.count("2011-7-21 21:10:35", operator, "2011-7-21 20:10:36"));
	}
	
	public static void testCountDateMoreEqual() throws Exception{
		String operator = ">=";
		String data1 = "2011-7-21";
		String data2 = "2011-7-21 0:0:0";
		assertEquals(true, OperationExpression.count(data1, operator, data2));
		assertEquals(true, OperationExpression.count("2011-7-21", operator, "2011-7-21"));
		assertEquals(true, OperationExpression.count("2011-7-21", operator, "2011-7-20"));
		assertEquals(false, OperationExpression.count("2011-7-21 20:10:35", operator, "2011-7-21 20:10:36"));
		assertEquals(true, OperationExpression.count("2011-7-21 21:10:35", operator, "2011-7-21 20:10:36"));
	}
	
	public static void testCountDateLessEqual() throws Exception{
		String operator = "<=";
		String data1 = "2011-7-21";
		String data2 = "2011-7-21 0:0:0";
		assertEquals(true, OperationExpression.count(data1, operator, data2));
		assertEquals(true, OperationExpression.count("2011-7-21", operator, "2011-7-21"));
		assertEquals(false, OperationExpression.count("2011-7-21", operator, "2011-7-20"));
		assertEquals(true, OperationExpression.count("2011-7-21 20:10:35", operator, "2011-7-21 20:10:36"));
		assertEquals(false, OperationExpression.count("2011-7-21 21:10:35", operator, "2011-7-21 20:10:36"));
	}
	
	public static void testCountDateIn() throws Exception{
		String operator = "in";
		String data1 = "2011-7-21";
		String data2 = "2011-7-21 0:0:0";
		assertEquals(true, OperationExpression.count(data1, operator, data2));
		assertEquals(true, OperationExpression.count("2011-7-21", operator, "2011-7-21"));
		assertEquals(false, OperationExpression.count("2011-7-21", operator, "2011-7-20"));
		assertEquals(true, OperationExpression.count("2011-7-21 20:10:35", operator, "2011-7-21 20:10:36,2011-7-21 20:10:35"));
		assertEquals(false, OperationExpression.count("2011-7-21 21:10:35", operator, "2011-7-21 20:10:36,2011-7-21 21:10:34,2011-7-21 21:10:32"));
	}
	
	public static void testCountDateNotIn() throws Exception{
		String operator = "not in";
		String data1 = "2011-7-21";
		String data2 = "2011-7-21 0:0:0";
		assertEquals(false, OperationExpression.count(data1, operator, data2));
		assertEquals(false, OperationExpression.count("2011-7-21", operator, "2011-7-21"));
		assertEquals(true, OperationExpression.count("2011-7-21", operator, "2011-7-20"));
		assertEquals(false, OperationExpression.count("2011-7-21 20:10:35", operator, "2011-7-21 20:10:36,2011-7-21 20:10:35"));
		assertEquals(true, OperationExpression.count("2011-7-21 21:10:35", operator, "2011-7-21 20:10:36,2011-7-21 21:10:34,2011-7-21 21:10:32"));
	}
}
