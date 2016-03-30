package com.upeng.commons.test.lang;

import com.upeng.commons.lang.BooleanUtils;

import junit.framework.TestCase;

public class BooleanUtilsTestCase extends TestCase {

	public void testToBooleanInt() {
		TestCase.assertEquals(true, BooleanUtils.toBoolean(1));
		TestCase.assertEquals(false, BooleanUtils.toBoolean(0));
		TestCase.assertEquals(true, BooleanUtils.toBoolean(2));
		TestCase.assertEquals(true, BooleanUtils.toBoolean(-1));
		TestCase.assertEquals(false, BooleanUtils.toBoolean(-0));
	}

	public void testToBooleanStringBoolean() {
		TestCase.assertEquals(true, BooleanUtils.toBoolean("true", false));
		TestCase.assertEquals(true, BooleanUtils.toBoolean("trUe", false));
		TestCase.assertEquals(false, BooleanUtils.toBoolean("faLse", true));
		TestCase.assertEquals(false, BooleanUtils.toBoolean("faLSe", true));
		TestCase.assertEquals(true, BooleanUtils.toBoolean("0", true));
		TestCase.assertEquals(false, BooleanUtils.toBoolean("1", false));
		TestCase.assertEquals(false, BooleanUtils.toBoolean("dzz", false));
	}

	public void testToBooleanString() {
		TestCase.assertEquals(true, BooleanUtils.toBoolean("TrUe"));
		TestCase.assertEquals(false, BooleanUtils.toBoolean("FaLse"));
		TestCase.assertEquals(false, BooleanUtils.toBoolean("0"));
		TestCase.assertEquals(false, BooleanUtils.toBoolean("1"));
	}

	public void testToBooleanStrict() {
		TestCase.assertEquals(true, BooleanUtils.toBooleanStrict("TrUe"));
		TestCase.assertEquals(false, BooleanUtils.toBooleanStrict("FaLse"));
		try{
			TestCase.assertEquals(false, BooleanUtils.toBooleanStrict("0"));
			TestCase.assertTrue(false);
		}catch(Exception e){
			TestCase.assertTrue(true);
		}
	}

}
