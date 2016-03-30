package com.upeng.commons.test.lang.builder;

import com.upeng.commons.lang.builder.ToStringBuilder;

import junit.framework.TestCase;

public class ToStringBuilderTestCase extends TestCase {
	
	public static class Person{
		private String name;
		private int age;
		private String nickName;
		
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
		public String getNickName() {
			return nickName;
		}
		public void setNickName(String nickName) {
			this.nickName = nickName;
		}		
		public Person(){
		}
		public Person(String name, int age, String nickName){
			this.name = name;
			this.age = age;
			this.nickName = nickName;
		}
	}

	public void testToStringBuilder() {
		Person p = new Person("PengZhoushuo", 25, "peng");
		ToStringBuilder builder = new ToStringBuilder(p);
		TestCase.assertTrue(builder.toString().contains("Person"));
	}

	public void testAppend() {
		Person p = new Person("PengZhoushuo", 25, "peng");
		ToStringBuilder builder = new ToStringBuilder(p);
		builder.append("name", p.getName());
		builder.append("age", p.getAge());
		TestCase.assertTrue(builder.toString().contains("name=PengZhoushuo,age=25"));
	}

	public void testReflectionToString() {
		Person p = new Person("PengZhoushuo", 25, "peng");
		TestCase.assertTrue(ToStringBuilder.reflectionToString(p).toString().contains("name=PengZhoushuo,age=25,nickName=peng"));
		TestCase.assertTrue(ToStringBuilder.reflectionToString(p, "abc").toString().contains("name=PengZhoushuo,age=25,nickName=peng"));
		TestCase.assertTrue(ToStringBuilder.reflectionToString(p, "age").toString().contains("name=PengZhoushuo,nickName=peng"));
	}

	public void testToString() {
		Person p = new Person("PengZhoushuo", 25, "peng");
		ToStringBuilder builder = new ToStringBuilder(p);
		builder.append("name", p.getName());
		builder.append("age", p.getAge());
		TestCase.assertTrue(builder.toString().contains("name=PengZhoushuo,age=25"));
	}

	public void testRemoveLastItemIfEqual() {
		StringBuilder sb = new StringBuilder();
		sb.append("123");
		ToStringBuilder.removeLastItemIfEqual(sb, '3');
		TestCase.assertEquals("12", sb.toString());
		ToStringBuilder.removeLastItemIfEqual(sb, '1');
		TestCase.assertEquals("12", sb.toString());
		ToStringBuilder.removeLastItemIfEqual(sb, '2');
		TestCase.assertEquals("1", sb.toString());
	}

}
