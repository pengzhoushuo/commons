package com.upeng.commons.test.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.upeng.commons.collections.CollectionsUtils;
import com.upeng.commons.lang.builder.ToStringBuilder;

import junit.framework.TestCase;

public class CollectionsUtilsTestCase extends TestCase {

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
		public String toString(){
			return ToStringBuilder.reflectionToString(this);
		}
	}
	
	public void testContact() {
		List<String> l1 = new ArrayList<String>();
		l1.add("abc");
		l1.add("abc");
		List<String> l2 = new ArrayList<String>();
		l2.add("zzz");
		l2.add("zz2");
		TestCase.assertEquals(4, CollectionsUtils.contact(l1, l2).size());
		Set<String> s1 = new HashSet<String>();
		Set<String> s2 = new HashSet<String>();
		s1.add("abc");
		s1.add("def");
		s2.add("abc");
		s2.add("zzz");
		TestCase.assertEquals(3, CollectionsUtils.contact(s1, s2).size());
	}

	public void testSubListListOfObjectIntInt() {
		List<String> l1 = new ArrayList<String>();
		l1.add("abc");
		l1.add("abc");
		l1.add("zzz");
		l1.add("zz2");
		TestCase.assertEquals(0, CollectionsUtils.subList(l1, 0,0).size());
		TestCase.assertEquals(1, CollectionsUtils.subList(l1, 0,1).size());
		TestCase.assertEquals(3, CollectionsUtils.subList(l1, 1,10).size());
		TestCase.assertEquals(0, CollectionsUtils.subList(l1, 12,10).size());
		TestCase.assertEquals(0, CollectionsUtils.subList(l1, 2,1).size());
	}

	public void testSubListListOfObjectInt() {
		List<String> l1 = new ArrayList<String>();
		l1.add("abc");
		l1.add("abc");
		l1.add("zzz");
		l1.add("zz2");
		TestCase.assertEquals(4, CollectionsUtils.subList(l1, -10).size());
		TestCase.assertEquals(4, CollectionsUtils.subList(l1, 0).size());
		TestCase.assertEquals(3, CollectionsUtils.subList(l1, 1).size());
		TestCase.assertEquals(1, CollectionsUtils.subList(l1, 3).size());
		TestCase.assertEquals(0, CollectionsUtils.subList(l1, 4).size());
		TestCase.assertEquals(0, CollectionsUtils.subList(l1, 5).size());
	}

	public void testToList() {
		TestCase.assertEquals(3, CollectionsUtils.toList("abc","def","ghj").size());
	}

	public void testToStringList() {
		TestCase.assertEquals(3, CollectionsUtils.toStringList("abc","def","ghj").size());
	}

	public void testToIntList() {
		TestCase.assertEquals(3, CollectionsUtils.toIntList(3,2,1).size());
	}

	public void testSubMap() {
		Map<String,String> sourceMap = new HashMap<String,String>();
		Map<String,String> targetMap = new HashMap<String,String>();
		sourceMap.put("abc.a", "zzz");
		sourceMap.put("abc.z", "abcz");
		sourceMap.put("ddd", "dd");
		TestCase.assertEquals(2, CollectionsUtils.subMap(sourceMap, targetMap, "abc.").size());
		TestCase.assertEquals("abcz", targetMap.get("z"));
		TestCase.assertNull(targetMap.get("abc.z"));
	}

	public void testInList() {
		List<String> list = new ArrayList<String>();
		list.add("abc");
		list.add("eefg");
		list.add("zdr");
		TestCase.assertTrue(CollectionsUtils.inList("abc", list));
		TestCase.assertFalse(CollectionsUtils.inList("zzz", list));
	}

	public void testReverse() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		CollectionsUtils.reverse(list);
		for(int i=0; i<4; i++){
			TestCase.assertEquals(list.get(0).intValue(), 4);
			TestCase.assertEquals(list.get(1).intValue(), 3);
			TestCase.assertEquals(list.get(2).intValue(), 2);
			TestCase.assertEquals(list.get(3).intValue(), 1);
		}

		List<Integer> list2 = new ArrayList<Integer>();
		list2.add(1);
		list2.add(2);
		list2.add(3);
		list2.add(4);
		list2.add(5);
		CollectionsUtils.reverse(list2);
		for(int i=0; i<6; i++){
			TestCase.assertEquals(list2.get(0).intValue(), 5);
			TestCase.assertEquals(list2.get(1).intValue(), 4);
			TestCase.assertEquals(list2.get(2).intValue(), 3);
			TestCase.assertEquals(list2.get(3).intValue(), 2);
			TestCase.assertEquals(list2.get(4).intValue(), 1);
		}
		
	}
	
	public void testSort(){
		Map map1 = new HashMap();
		map1.put("k", "a1");
		Map map2 = new HashMap();
		map2.put("k", "a5");
		Map map3 = new HashMap();
		map3.put("k", "a3");
		Map map4 = new HashMap();
		map4.put("k", "a2");
		List<Map> list = new ArrayList<Map>();
		list.add(map1);
		list.add(map2);
		list.add(map3);
		list.add(map4);
		CollectionsUtils.sort(list, "k", true);
		TestCase.assertEquals("a1", list.get(0).get("k"));
		CollectionsUtils.sort(list, "k", false);
		TestCase.assertEquals("a5" ,list.get(0).get("k"));
		
		Person p1 = new Person(); 
		p1.setName("peng");
		p1.setAge(3);
		Person p2 = new Person(); 
		p2.setName("peng");
		p2.setAge(13);
		Person p3 = new Person(); 
		p3.setName("aeng");
		p3.setAge(1);
		Person p4 = new Person(); 
		p4.setName("aeng");
		p4.setAge(3);
		List<Person> list2 = new ArrayList<Person>();
		list2.add(p1);
		list2.add(p2);
		list2.add(p3);
		CollectionsUtils.sort(list2, "name,age", true);
		TestCase.assertEquals(1, list2.get(0).getAge());
		TestCase.assertEquals("aeng", list2.get(0).getName());
		CollectionsUtils.sort(list2, "name,age", false);
		TestCase.assertEquals(13, list2.get(0).getAge());
		TestCase.assertEquals("peng", list2.get(0).getName());
	}
	
	public void testTurnSetToList(){
		Set<String> set = new HashSet<String>();
		set.add("one");
		set.add("two");
		set.add("One");
		set.add("two");
		List<String> list = CollectionsUtils.turnSetToList(set);
		TestCase.assertEquals(3, list.size());
		TestCase.assertEquals("two", list.get(0));
		TestCase.assertEquals("one", list.get(1));
		TestCase.assertEquals("One", list.get(2));
	}
	
	public void testTurnListToSet(){
		List<String> list = new ArrayList<String>();
		list.add("one");
		list.add("two");
		list.add("One");
		list.add("two");
		Set<String> set = CollectionsUtils.turnListToSet(list);
		TestCase.assertEquals(3, set.size());
		int i = 0;
		for(String str : set){
			if(i == 0){
				TestCase.assertEquals("two", str);
			}
			if(i == 2){
				TestCase.assertEquals("One", str);
			}
			if(i == 3){
				TestCase.assertEquals("one", str);
			}
			i++;
		}
	}
	
	public void turnMapKeyToList(){
		Map<String, String> map = new HashMap<String, String>();
		map.put("one", "1");
		map.put("tow", "2");
		map.put("three", "3");
		List<String> list = CollectionsUtils.turnMapKeyToList(map);
		TestCase.assertEquals(3, list.size());
		TestCase.assertEquals("two", list.get(0));
		TestCase.assertEquals("one", list.get(1));
		TestCase.assertEquals("One", list.get(2));
	}
	
	public void testGetReverseResult(){
		Set<String> allResult = new HashSet<String>();
		allResult.add("one");
		allResult.add("cc");
		allResult.add("two");
		Set<String> partResult = new HashSet<String>();
		partResult.add("one");
		partResult.add("two");
		List<String> otherPartResult = CollectionsUtils.getReverseResult(allResult, partResult);
		TestCase.assertEquals(1, otherPartResult.size());
		TestCase.assertEquals("cc", otherPartResult.get(0));
	}
}
