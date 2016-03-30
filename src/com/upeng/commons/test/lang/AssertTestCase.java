package com.upeng.commons.test.lang;

import com.upeng.commons.lang.Assert;

import junit.framework.TestCase;

public class AssertTestCase extends TestCase {

	public void testIsTrueBooleanString() {
		Assert.isTrue(true,"test");
		try{
			Assert.isTrue(false, "test");
			TestCase.assertTrue(false);
		}catch(Exception e){
			if(e.getMessage().contains("test")){
				TestCase.assertTrue(true);
			}else{
				TestCase.assertTrue(false);
			}
		}
	}

	public void testIsTrueBoolean() {
		Assert.isTrue(true);
		try{
			Assert.isTrue(false);
			TestCase.assertTrue(false);
		}catch(Exception e){
			TestCase.assertTrue(true);
		}
	}

	public void testIsNullObjectString() {
		Assert.isNull(null,"test");
		try{
			Assert.isNull("abc", "test");
			TestCase.assertTrue(false);
		}catch(Exception e){
			if(e.getMessage().contains("test")){
				TestCase.assertTrue(true);
			}else{
				TestCase.assertTrue(false);
			}
		}
	}

	public void testIsNullObject() {
		Assert.isNull(null);
		try{
			Assert.isNull("abc");
			TestCase.assertTrue(false);
		}catch(Exception e){
			TestCase.assertTrue(true);
		}
	}

	public void testNotNullObjectString() {
		Assert.notNull("abc","test");
		try{
			Assert.notNull(null, "test");
			TestCase.assertTrue(false);
		}catch(Exception e){
			if(e.getMessage().contains("test")){
				TestCase.assertTrue(true);
			}else{
				TestCase.assertTrue(false);
			}
		}
	}

	public void testNotNullObject() {
		Assert.notNull("abc");
		try{
			Assert.notNull(null);
			TestCase.assertTrue(false);
		}catch(Exception e){
			TestCase.assertTrue(true);
		}
	}

	public void testHasTextStringString() {
		Assert.hasText("abc","test");
		try{
			Assert.hasText("", "test");
			TestCase.assertTrue(false);
		}catch(Exception e){
			if(e.getMessage().contains("test")){
				TestCase.assertTrue(true);
			}else{
				TestCase.assertTrue(false);
			}
		}
		try{
			Assert.hasText(null, "test");
			TestCase.assertTrue(false);
		}catch(Exception e){
			if(e.getMessage().contains("test")){
				TestCase.assertTrue(true);
			}else{
				TestCase.assertTrue(false);
			}
		}
	}

	public void testHasTextString() {
		Assert.hasText("abc");
		try{
			Assert.hasText("");
			TestCase.assertTrue(false);
		}catch(Exception e){
			TestCase.assertTrue(true);
		}
		try{
			Assert.hasText(null);
			TestCase.assertTrue(false);
		}catch(Exception e){
			TestCase.assertTrue(true);
		}
	}

}
