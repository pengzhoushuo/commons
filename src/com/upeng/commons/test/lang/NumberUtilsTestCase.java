package com.upeng.commons.test.lang;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Assert;

import com.upeng.commons.lang.NumberUtils;

public class NumberUtilsTestCase  extends TestCase{

	public void testToIntString() {
		assertEquals(NumberUtils.toInt("123"),123);
		assertEquals(NumberUtils.toInt("abc"),0);
	}

	public void testToIntStringInt() {
		assertEquals(NumberUtils.toInt("123",1),123);
		assertEquals(NumberUtils.toInt("abc",1),1);
	}

	public void testToIntStrict() {
		assertEquals(NumberUtils.toIntStrict("123"),123);
		try{
			NumberUtils.toIntStrict("abc");
		}catch(IllegalArgumentException e){
			assertTrue(true);
		}
	}

	public void testToIntBoolean() {
		assertEquals(NumberUtils.toInt(true),1);
		assertEquals(NumberUtils.toInt(false),0);
	}

	public void testToLongString() {
		long a = 123;
		long b = 0;
		assertEquals(NumberUtils.toLong("123"),a);
		assertEquals(NumberUtils.toLong("abc"),b);
	}

	public void testToLongStringLong() {
		long a = 123;
		assertEquals(NumberUtils.toLong("123",1),a);
		assertEquals(NumberUtils.toLong("abc",2),2);
	}

	public void testToLongStrict() {
		long a = 123;
		assertEquals(NumberUtils.toLongStrict("123"),a);
		try{
			NumberUtils.toLongStrict("abc");
		}catch(IllegalArgumentException e){
			assertTrue(true);
		}
	}

	public void testToFloatString() {
		float a = 123;
		float b = 0;
		assertEquals(NumberUtils.toFloat("123"),a);
		assertEquals(NumberUtils.toFloat("abc"),b);
	}

	public void testToFloatStringFloat() {
		float a = 123;
		float b = 2;
		assertEquals(NumberUtils.toFloat("123",1),a);
		assertEquals(NumberUtils.toFloat("abc",b),b);
	}

	public void testToFloatStrict() {
		float a = 123;
		assertEquals(NumberUtils.toFloatStrict("123"),a);
		try{
			NumberUtils.toFloatStrict("abc");
		}catch(IllegalArgumentException e){
			assertTrue(true);
		}
	}

	public void testToDoubleString() {
		double a = 123;
		double b = 0;
		assertEquals(NumberUtils.toDouble("123"),a);
		assertEquals(NumberUtils.toDouble("abc"),b);
	}

	public void testToDoubleStringDouble() {
		double a = 123;
		double b = 2;
		assertEquals(NumberUtils.toDouble("123",1),a);
		assertEquals(NumberUtils.toDouble("abc",b),b);
	}

	public void testToDoubleStrict() {
		double a = 123;
		assertEquals(NumberUtils.toDoubleStrict("123"),a);
		try{
			NumberUtils.toDoubleStrict("abc");
		}catch(IllegalArgumentException e){
			assertTrue(true);
		}
	}

	public void testToShortString() {
		short a = 123;
		short b = 0;
		assertEquals(NumberUtils.toShort("123"),a);
		assertEquals(NumberUtils.toShort("abc"),b);
	}

	public void testToShortStringShort() {
		short a = 123;
		short b = 2;
		short c = 1;
		assertEquals(NumberUtils.toShort("123",c),a);
		assertEquals(NumberUtils.toShort("abc",b),b);
	}

	public void testToShortStrict() {
		short a = 123;
		assertEquals(NumberUtils.toShortStrict("123"),a);
		try{
			NumberUtils.toShortStrict("abc");
		}catch(IllegalArgumentException e){
			assertTrue(true);
		}
	}

	public void testToBigDecimalString() {
		BigDecimal a = new BigDecimal(123);
		BigDecimal b = new BigDecimal(0);
		assertEquals(NumberUtils.toBigDecimal("123"),a);
		assertEquals(NumberUtils.toBigDecimal("abc"),b);
	}

	public void testToBigDecimalStringBigDecimal() {
		BigDecimal a = new BigDecimal(123);
		BigDecimal c = new BigDecimal(1);
		assertEquals(NumberUtils.toBigDecimal("123",c),a);
		assertEquals(NumberUtils.toBigDecimal("abc",c),c);
	}

	public void testToBigDecimalStrict() {
		BigDecimal a = new BigDecimal(123);
		assertEquals(NumberUtils.toBigDecimalStrict("123"),a);
		try{
			NumberUtils.toBigDecimalStrict("abc");
		}catch(IllegalArgumentException e){
			assertTrue(true);
		}
	}

	public void testToBigIntegerString() {
		BigInteger a = new BigInteger("123");
		BigInteger b = new BigInteger("0");
		assertEquals(NumberUtils.toBigInteger("123"),a);
		assertEquals(NumberUtils.toBigInteger("abc"),b);
	}

	public void testToBigIntegerStringBigInteger() {
		BigInteger a = new BigInteger("123");
		BigInteger b = new BigInteger("0");
		assertEquals(NumberUtils.toBigInteger("123",b),a);
		assertEquals(NumberUtils.toBigInteger("abc",a),a);
	}

	public void testToBigIntegerStrict() {
		BigInteger a = new BigInteger("123");
		assertEquals(NumberUtils.toBigIntegerStrict("123"),a);
		try{
			NumberUtils.toBigIntegerStrict("abc");
		}catch(IllegalArgumentException e){
			assertTrue(true);
		}
	}

	public void testToByteString() {
		byte a = 123;
		byte b = 0;
		assertEquals(NumberUtils.toByte("123"),a);
		assertEquals(NumberUtils.toByte("abc"),b);
	}

	public void testToByteStringByte() {
		byte a = 123;
		byte b = 0;
		assertEquals(NumberUtils.toByte("123",b),a);
		assertEquals(NumberUtils.toByte("abc",a),a);
	}

	public void testToByteStrict() {
		byte a = 123;
		assertEquals(NumberUtils.toByteStrict("123"),a);
		try{
			NumberUtils.toByteStrict("abc");
		}catch(IllegalArgumentException e){
			assertTrue(true);
		}
	}

	public void testMinLongArray() {
		long[] ls = new long[]{20,10,30,50,60,35};
		long min = 10;
		assertEquals(NumberUtils.min(ls),min);
	}

	public void testMinIntArray() {
		int[] is = new int[]{20,10,30,50,60,35};
		assertEquals(NumberUtils.min(is),10);
	}

	public void testMinInt() {
		int[] is = new int[]{20,10,30,50,60,35};
		assertEquals(NumberUtils.minInt(is),10);
	}

	public void testMinShortArray() {
		short[] ss = new short[]{20,10,30,50,60,35};
		short min = 10;
		assertEquals(NumberUtils.min(ss),min);
	}

	public void testMinByteArray() {
		byte[] bs = new byte[]{20,10,30,50,60,35};
		byte min = 10;
		assertEquals(NumberUtils.min(bs),min);
	}

	public void testMinDoubleArray() {
		double[] ds = new double[]{20,10,30,50,60,35};
		double min = 10;
		assertEquals(NumberUtils.min(ds),min);
	}

	public void testMinFloatArray() {
		float[] fs = new float[]{20,10,30,50,60,35};
		float min = 10;
		assertEquals(NumberUtils.min(fs),min);
	}

	public void testMaxLongArray() {
		long[] s = new long[]{20,10,30,50,60,35};
		long max = 60;
		assertEquals(NumberUtils.max(s),max);
	}

	public void testMaxIntArray() {
		int[] s = new int[]{20,10,30,50,60,35};
		int max = 60;
		assertEquals(NumberUtils.max(s),max);
	}

	public void testMaxInt() {
		int[] s = new int[]{20,10,30,50,60,35};
		int max = 60;
		assertEquals(NumberUtils.maxInt(s),max);
	}

	public void testMaxShortArray() {
		short[] s = new short[]{20,10,30,50,60,35};
		short max = 60;
		assertEquals(NumberUtils.max(s),max);
	}

	public void testMaxByteArray() {
		byte[] s = new byte[]{20,10,30,50,60,35};
		byte max = 60;
		assertEquals(NumberUtils.max(s),max);
	}

	public void testMaxDoubleArray() {
		double[] s = new double[]{20,10,30,50,60,35};
		double max = 60;
		assertEquals(NumberUtils.max(s),max);
	}

	public void testMaxFloatArray() {
		float[] s = new float[]{20,10,30,50,60,35};
		float max = 60;
		assertEquals(NumberUtils.max(s),max);
	}

	public void testToIntArray() {
		Assert.assertArrayEquals(NumberUtils.toIntArray(new String[]{"1","3","5"}),new int[]{1,3,5});
		Assert.assertArrayEquals(NumberUtils.toIntArray(new String[]{}), new int[]{});
		
	}

	public void testToIntList() {
		List<String> strList = new ArrayList<String>();
		strList.add("1");
		strList.add("4");
		strList.add("7");
		Assert.assertArrayEquals(NumberUtils.toIntList(strList).toArray(),new Object[]{1,4,7});
	}
	
	public void testTrimZero(){
		String num = "15968";
		Assert.assertEquals(num, NumberUtils.trimZero(num));
		num = "15968.10";
		Assert.assertEquals("15968.1", NumberUtils.trimZero(num));
		num = "15968.1000000";
		Assert.assertEquals("15968.1", NumberUtils.trimZero(num));
		num = "15968.1100000010";
		Assert.assertEquals("15968.110000001", NumberUtils.trimZero(num));
		num = "15968.1100000010000000000000";
		Assert.assertEquals("15968.110000001", NumberUtils.trimZero(num));
		num = "15968.0000000000000000000000";
		Assert.assertEquals("15968", NumberUtils.trimZero(num));
		num = "15968.";
		Assert.assertEquals("15968", NumberUtils.trimZero(num));
		num = "159680";
		Assert.assertEquals("159680", NumberUtils.trimZero(num));
		num = ".";
		Assert.assertEquals("", NumberUtils.trimZero(num));
		num = "";
		Assert.assertEquals("", NumberUtils.trimZero(num));
		num = "0.00000001";
		Assert.assertEquals("0.00000001", NumberUtils.trimZero(num));
		num = "0.0000000100000000";
		Assert.assertEquals("0.00000001", NumberUtils.trimZero(num));
		num = "0.00000001000000000.520";
		Assert.assertEquals("0.00000001000000000.52", NumberUtils.trimZero(num));
		num = "0.0";
		Assert.assertEquals("0", NumberUtils.trimZero(num));
		num = "0.";
		Assert.assertEquals("0", NumberUtils.trimZero(num));
	}
	

}
