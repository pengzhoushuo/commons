package com.upeng.commons.test.db;

import java.io.Serializable;

import com.upeng.commons.db.HashMapDB;
import com.upeng.commons.lang.builder.ToStringBuilder;

import junit.framework.TestCase;

public class TestHashMapDB extends TestCase{
	
	public void testPut(){
		HashMapDB map = new HashMapDB("D:/test", "z001");
		map.put("key1", "value1");
		Person p = new Person();
		p.setAge(10);
		p.setName("peng");
		map.put("person1", p);
		//again
		map.put("key1", "value1");
		map.put("key1", "value2");
		map.put("person1", p);
		p.setName("大");
		map.put("person2", p);
		map.put("person1", p);
	}
	
	public void testGet(){
		HashMapDB map = new HashMapDB("D:/test", "z001");
		map.loadAll();
		TestCase.assertEquals("value2", map.get("key1"));
		System.out.println(map.get("person1"));
		System.out.println(map.get("person2"));
	}
	
	public void testReload(){
		HashMapDB map = new HashMapDB("D:/test", "z001");
		map.loadAll();
		map.reload();
		map.reload();
		TestCase.assertEquals("value2", map.get("key1"));
		System.out.println(map.get("person1"));
		System.out.println(map.get("person2"));
	}
	
//	public void testRemove(){
//		HashMapDB map = new HashMapDB("D:/test", "z001");
//		map.loadAll();
//		map.remove("key1");
//		map.remove("person1");
//		map.remove("person2");
//		map.remove("zz");
//		TestCase.assertEquals(null, map.get("key1"));
//		System.out.println(map.get("person1"));
//		System.out.println(map.get("person2"));
//	}
	
	public static class Person implements Serializable{
		/**
		 * 
		 */
		private static final long serialVersionUID = 4843790120145222104L;
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

		private int age;
		
		public String toString(){
			return ToStringBuilder.reflectionToString(this);
		}
	}

}
