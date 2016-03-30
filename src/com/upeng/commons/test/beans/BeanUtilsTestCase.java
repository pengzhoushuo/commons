package com.upeng.commons.test.beans;

import java.util.HashMap;
import java.util.Map;

import com.upeng.commons.beans.BeanUtils;
import com.upeng.commons.beans.ExpressionUtils;
import com.upeng.commons.lang.ClassUtils;
import com.upeng.commons.test.beans.ExpressionUtilsTestCase.Person;

import junit.framework.TestCase;

public class BeanUtilsTestCase extends TestCase {

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
	
	public void testCopy() {
		Person p1= new Person();
		Person p2= new Person();
		p1.setName("peng");
		p1.setAge(20);
		BeanUtils.copy(p1, p2, "age");
		TestCase.assertEquals("peng", p2.getName());
		TestCase.assertEquals(0, p2.getAge());
	}

	public void testGetSetMethodName() {
		TestCase.assertEquals("setName", BeanUtils.getSetMethodName("name"));
	}

	public void testGetGetMethodName() {
		TestCase.assertEquals("getName", BeanUtils.getGetMethodName("name"));
	}

	public void testInjectStringMapOfStringObject() throws InstantiationException, ClassNotFoundException, IllegalAccessException {
		String str = "com.upeng.commons.test.beans.BeanUtilsTestCase$Person";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("age", 11);
		map.put("name", "pengzhoushuo");
		Person p  = (Person)BeanUtils.inject(str, map);
		TestCase.assertEquals("pengzhoushuo", p.getName());
		TestCase.assertEquals(11, p.getAge());
	}

	public void testInjectClassOfQMapOfStringObject() throws InstantiationException, ClassNotFoundException, IllegalAccessException {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("age", 11);
		map.put("name", "pengzhoushuo");
		Person p  = (Person)BeanUtils.inject(Person.class, map);
		TestCase.assertEquals("pengzhoushuo", p.getName());
		TestCase.assertEquals(11, p.getAge());
	}

	public void testInjectObjectMapOfStringObject() throws InstantiationException, ClassNotFoundException, IllegalAccessException {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("age", 11);
		map.put("name", "pengzhoushuo");
		Person p = new Person();
		BeanUtils.inject(p, map);
		TestCase.assertEquals("pengzhoushuo", p.getName());
		TestCase.assertEquals(11, p.getAge());
	}

	public void testInjectField() {
		Person p = new Person();
		//has set method
		BeanUtils.injectField(p, ClassUtils.getField(p, "name"), "peng");
		//no set method
		BeanUtils.injectField(p, ClassUtils.getField(p, "nickName"), "dd");
		TestCase.assertEquals("peng", p.getName());
		TestCase.assertEquals("dd", p.getNickName());
		//no exists field name
		try{
			BeanUtils.injectField(p, ClassUtils.getField(p, "nName"), "dd");
			TestCase.assertTrue(false);
		}catch(Exception e){
			TestCase.assertTrue(true);
		}
	}

	public void testIsBasicType() {
		TestCase.assertTrue(BeanUtils.isBasicType(java.util.Date.class));		
		TestCase.assertTrue(BeanUtils.isBasicType(String.class));
		
		TestCase.assertTrue(BeanUtils.isBasicType(int.class));
		TestCase.assertTrue(BeanUtils.isBasicType(double.class));
		TestCase.assertTrue(BeanUtils.isBasicType(float.class));
		TestCase.assertTrue(BeanUtils.isBasicType(short.class));
		TestCase.assertTrue(BeanUtils.isBasicType(byte.class));
		TestCase.assertTrue(BeanUtils.isBasicType(char.class));
		
		TestCase.assertTrue(BeanUtils.isBasicType(int[].class));
		TestCase.assertTrue(BeanUtils.isBasicType(double[].class));
		TestCase.assertTrue(BeanUtils.isBasicType(float[].class));
		TestCase.assertTrue(BeanUtils.isBasicType(short[].class));
		TestCase.assertTrue(BeanUtils.isBasicType(byte[].class));
		TestCase.assertTrue(BeanUtils.isBasicType(char[].class));
		
		TestCase.assertTrue(BeanUtils.isBasicType(Integer[].class));
		TestCase.assertTrue(BeanUtils.isBasicType(Double[].class));
		TestCase.assertTrue(BeanUtils.isBasicType(Float[].class));
		TestCase.assertTrue(BeanUtils.isBasicType(Short[].class));
		TestCase.assertTrue(BeanUtils.isBasicType(Byte[].class));
		TestCase.assertTrue(BeanUtils.isBasicType(Character[].class));
		
		TestCase.assertTrue(BeanUtils.isBasicType(Integer.class));
		TestCase.assertTrue(BeanUtils.isBasicType(Double.class));
		TestCase.assertTrue(BeanUtils.isBasicType(Float.class));
		TestCase.assertTrue(BeanUtils.isBasicType(Short.class));
		TestCase.assertTrue(BeanUtils.isBasicType(Byte.class));
		TestCase.assertTrue(BeanUtils.isBasicType(Character.class));
		
		TestCase.assertFalse(BeanUtils.isBasicType(Person.class));
	}
	
	public void testValidateNotNullFields(){
		Person p = new Person();
		p.nickName = "abc";
		TestCase.assertFalse(BeanUtils.validateNotNullFields(p));
		TestCase.assertTrue(BeanUtils.validateNotNullFields(p,"name"));
		TestCase.assertFalse(BeanUtils.validateNotNullFields(p,"age"));
		TestCase.assertTrue(BeanUtils.validateNotNullFields(p,"name","age"));
		TestCase.assertTrue(BeanUtils.validateNotNullFields(p,"age","name"));
		p.setName("peng");
		TestCase.assertTrue(BeanUtils.validateNotNullFields(p,"name"));
		TestCase.assertTrue(BeanUtils.validateNotNullFields(p,"age"));
		TestCase.assertTrue(BeanUtils.validateNotNullFields(p,"name","age"));
		TestCase.assertTrue(BeanUtils.validateNotNullFields(p,"age","name"));
		p.setAge(10);
		TestCase.assertTrue(BeanUtils.validateNotNullFields(p,"name"));
		TestCase.assertTrue(BeanUtils.validateNotNullFields(p,"age"));
		TestCase.assertTrue(BeanUtils.validateNotNullFields(p,"name","age"));
		TestCase.assertTrue(BeanUtils.validateNotNullFields(p,"age","name"));
	}

	public void testGetFieldValue() {
		Person p = new Person();
		p.setName("pengzhoushuo");
		TestCase.assertEquals("pengzhoushuo", BeanUtils.getValue(p, "name"));
		Map map = new HashMap();
		map.put("ztest", "hahaa");
		TestCase.assertEquals(null, BeanUtils.getValue(map, "name"));
		TestCase.assertEquals("hahaa", BeanUtils.getValue(map, "ztest"));
	}
	
	public void testValidateNotBlankFields(){
		Person p = new Person();
		p.nickName = "abc";
		TestCase.assertFalse(BeanUtils.validateNotBlankFields(p));
		TestCase.assertTrue(BeanUtils.validateNotBlankFields(p,"name"));
		TestCase.assertFalse(BeanUtils.validateNotBlankFields(p,"age"));
		TestCase.assertTrue(BeanUtils.validateNotBlankFields(p,"name","age"));
		TestCase.assertTrue(BeanUtils.validateNotBlankFields(p,"age","name"));
		p.setName("peng");
		TestCase.assertTrue(BeanUtils.validateNotBlankFields(p,"name"));
		TestCase.assertTrue(BeanUtils.validateNotBlankFields(p,"age"));
		TestCase.assertTrue(BeanUtils.validateNotBlankFields(p,"name","age"));
		TestCase.assertTrue(BeanUtils.validateNotBlankFields(p,"age","name"));
		p.setAge(10);
		TestCase.assertTrue(BeanUtils.validateNotBlankFields(p,"name"));
		TestCase.assertTrue(BeanUtils.validateNotBlankFields(p,"age"));
		TestCase.assertTrue(BeanUtils.validateNotBlankFields(p,"name","age"));
		TestCase.assertTrue(BeanUtils.validateNotBlankFields(p,"age","name"));
		Person p2 = new Person();
		p2.setName("");
		p2.nickName = "abc";
		TestCase.assertFalse(BeanUtils.validateNotBlankFields(p2,"age"));
	}
}
