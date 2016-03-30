package com.upeng.commons.test.lang;

import com.upeng.commons.lang.RandomUtils;
import com.upeng.commons.lang.StringUtils;

import junit.framework.TestCase;

public class RandomUtilsTestCase extends TestCase {

	public void testGetUUID() {
		TestCase.assertEquals(32+4, RandomUtils.getUUID().length());
	}

	public void testGetUUIDUpperCase() {
		TestCase.assertTrue(StringUtils.isUpperCase(RandomUtils.getUUIDUpperCase()));
	}

	public void testRandomIntPositiveIntIntInt() {
		TestCase.assertEquals(2, RandomUtils.randomIntPositive(1, 2, 2));
		try{
			TestCase.assertEquals(0, RandomUtils.randomIntPositive(1, 1, 2));
			TestCase.assertTrue(false);
		}catch(Exception e){
			TestCase.assertTrue(true);
		}
		TestCase.assertEquals(2, RandomUtils.randomIntPositive(2, 2, 2));
		TestCase.assertEquals(2, RandomUtils.randomIntPositive(1, 2, 2));
		TestCase.assertTrue(2<RandomUtils.randomIntPositive(2, 10, 3)&&10 > RandomUtils.randomIntPositive(2, 10,3) );
		try{
			TestCase.assertEquals(1, RandomUtils.randomIntPositive(2, 1,3));
			TestCase.assertTrue(false);
		}catch(Exception e){
			TestCase.assertTrue(true);
		}
		try{
			TestCase.assertEquals(1, RandomUtils.randomIntPositive(-1, 1,2));
			TestCase.assertTrue(false);
		}catch(Exception e){
			TestCase.assertTrue(true);
		}
	}

	public void testRandomIntPositiveIntInt() {
		TestCase.assertEquals(0, RandomUtils.randomIntPositive(0, 0));
		TestCase.assertEquals(1, RandomUtils.randomIntPositive(1, 1));
		TestCase.assertTrue(1<RandomUtils.randomIntPositive(2, 10)&&11 > RandomUtils.randomIntPositive(2, 10) );
		try{
			TestCase.assertEquals(1, RandomUtils.randomIntPositive(2, 1));
			TestCase.assertTrue(false);
		}catch(Exception e){
			TestCase.assertTrue(true);
		}
		try{
			TestCase.assertEquals(1, RandomUtils.randomIntPositive(-1, 1));
			TestCase.assertTrue(false);
		}catch(Exception e){
			TestCase.assertTrue(true);
		}
	}

	public void testRandomIntPositiveInt() {
		TestCase.assertEquals(0, RandomUtils.randomIntPositive(0));
		TestCase.assertTrue(-1<RandomUtils.randomIntPositive(10)&&11 > RandomUtils.randomIntPositive(2, 10) );
		try{
			TestCase.assertEquals(1, RandomUtils.randomIntPositive(-1));
			TestCase.assertTrue(false);
		}catch(Exception e){
			TestCase.assertTrue(true);
		}
	}

	public void testRandomAlphabetic() {
		TestCase.assertEquals(10,RandomUtils.randomAlphabetic(10).length());
	}

	public void testRandomNumeric() {
		TestCase.assertTrue(StringUtils.isNumString(RandomUtils.randomNumeric(5)));
	}

	public void testRandomString() {
		TestCase.assertEquals(10, RandomUtils.randomString(10).length());
	}

	public void testRandom() {
		String[] results = {"abc","def","ghj"};
		TestCase.assertEquals("ghj",RandomUtils.random(results, new double[]{0,0,1.0}));
		TestCase.assertEquals("def",RandomUtils.random(results, new double[]{0,1,0.0}));
		try{
			TestCase.assertEquals("ghj",RandomUtils.random(results, new double[]{0,0,1.1}));
			TestCase.assertTrue(false);
		}catch(Exception e){
			TestCase.assertTrue(true);
		}
		try{
			TestCase.assertEquals("ghj",RandomUtils.random(results, new double[]{0,0,0.99}));
			TestCase.assertTrue(false);
		}catch(Exception e){
			TestCase.assertTrue(true);
		}
		try{
			TestCase.assertEquals("ghj",RandomUtils.random(results, new double[]{0,1}));
			TestCase.assertTrue(false);
		}catch(Exception e){
			TestCase.assertTrue(true);
		}
	}

}
