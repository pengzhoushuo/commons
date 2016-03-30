package com.upeng.commons.test.beans;

import com.upeng.commons.beans.ExpressionUtils;
import com.upeng.commons.lang.ClassUtils;
import com.upeng.commons.lang.time.StopWatch;

import junit.framework.TestCase;

public class ExpressionUtilsTestCase extends TestCase {

	public static class Person{
		private String name;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		private String nickName;
		public String getNickName() {
			return nickName;
		}
		private int age;
	}
	
	public void testExecuteMethod() {
		String setMethodName = "setName";
		String getMethodName = "getName";
		Person p = new Person();
		ExpressionUtils.executeMethod(p, setMethodName, new Object[]{"pengzhoushuo"});
		TestCase.assertEquals("pengzhoushuo", p.getName());
		TestCase.assertEquals("pengzhoushuo", ExpressionUtils.executeMethod(p, getMethodName, null));
	}

	public void testGetFieldValue() {
		Person p = new Person();
		p.setName("pengzhoushuo");
		TestCase.assertEquals("pengzhoushuo", ExpressionUtils.getFieldValue(p, "name"));
	}

	public void testSetFieldValueObjectStringObject() {
		Person p = new Person();
		ExpressionUtils.setFieldValue(p, "name", "pengzhoushuo");
		TestCase.assertEquals("pengzhoushuo", ExpressionUtils.getFieldValue(p, "name"));
	}

	public void testSetFieldValueObjectFieldObject() {
		Person p = new Person();
		ExpressionUtils.setFieldValue(p, ClassUtils.getField(p, "name"), "pengzhoushuo");
		TestCase.assertEquals("pengzhoushuo", ExpressionUtils.getFieldValue(p, "name"));
	}
	
	public void testSetFieldValueObjectFieldObject2() {
		Person p = new Person();
		ExpressionUtils.setFieldValue(p, ClassUtils.getField(p, "age"), null);
		TestCase.assertEquals(0, ExpressionUtils.getFieldValue(p, "age"));
	}
	
	public static void main(String[] args){
		String setMethodName = "setName";
		String getMethodName = "getName";
		StopWatch stopWatch = new StopWatch();
		for(int i=0; i<10000000; i++){
			Person p = new Person();
			ExpressionUtils.executeMethod(p, setMethodName, new Object[]{"pengzhoushuo"});
			
		}
		System.out.println("executeSetMethod:" + stopWatch.getInterval() + " MS");
		stopWatch.begin();
		for(int i=0; i<10000000; i++){
			Person p = new Person();
			ExpressionUtils.executeMethod(p, getMethodName, null);
		}
		System.out.println("executeGetMethod:" + stopWatch.getInterval() + " MS");
		stopWatch.begin();
		for(int i=0; i<10000000; i++){
			Person p = new Person();
			ExpressionUtils.setFieldValue(p, "name", "pengzhoushuo");
		}
		System.out.println("inject set field " + stopWatch.getInterval() + " MS");
		stopWatch.begin();
		for(int i=0; i<10000000; i++){
			Person p = new Person();
			ExpressionUtils.getFieldValue(p, "name");
		}
		System.out.println("inject get field " + stopWatch.getInterval() + " MS");
	}

}
