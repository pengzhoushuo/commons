package com.upeng.commons.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.upeng.commons.lang.ArrayUtils;
import com.upeng.commons.lang.comparator.BeanComparator;

/**
 * @author Lucky
 *
 */
public class CollectionsUtils<E>{

	/**
	 * <p>Contact Collection A to Collection B</p>
	 * @param <E>
	 * @param c1
	 * @param c2
	 * @return
	 */
	public static <E extends Object> Collection<E> contact(Collection <E> c1, Collection<E> c2){
		if(c1 == null){
			return c2;
		}else if(c2 == null){
			return c1;
		}
		c1.addAll(c2);
		return c1;
	}
	
	/**
	 * <p>Get sub List form source list</p>
	 * @param sourceList source list
	 * @param fromIndex start index, if less than 0, start form 0 
	 * @param toIndex end index, if large than sourceList.size(), ends with sourceList.size()
	 * @return
	 */
	public static <E extends Object> List<E> subList(List<E> sourceList, int fromIndex, int toIndex){
		if(fromIndex > toIndex){
			fromIndex = toIndex;
		}
		int endIndex = sourceList.size();
		if(fromIndex > endIndex){
			fromIndex = endIndex;
		}else if(fromIndex < 0){
			fromIndex = 0;
		}
		if(toIndex > endIndex){
			toIndex = endIndex;
		}
		return sourceList.subList(fromIndex, toIndex);
	}
	
	/**
	 * <p>Get sub List form source list</p>
	 * @param sourceList source list, if less than 0, start form 0 
	 * @param fromIndex start index
	 * @return
	 */
	public static <E extends Object> List<E> subList(List<E> sourceList, int fromIndex){
		return subList(sourceList,fromIndex, sourceList.size()); 
	}
	
	/**
	 * <p>Convert Object[] to Object List</p>
	 * @param os object array
	 * @return
	 */
	public static <T> List<T> toList(T... os){		
		return Arrays.asList(os);
	}
	
	/**
	 * <p>Convert String[] to String List</p>
	 * @param strings string array
	 * @return
	 */
	public static List<String> toStringList(String... strings){
		return toList(strings);
	}
	
	/**
	 * <p>Convert int[] to int List</p>
	 * @param ints int array
	 * @return
	 */
	public static List<Integer> toIntList(int... ints){		 
		int len = ints.length;
		List<Integer> list = new ArrayList<Integer>(len);
		for(int i : ints){
			list.add(i);
		}
		return list;
	}
	
	/**
	 * <p>Return subMap from target Map where the key start with appointing keyPrefix, subMap's remove keyPrefix</p>
	 * <p>subMap([key1:value1,key21:value21,key22:value22], new HashMap(), key2) return [1:value21,2:value22]</p>
	 * @param sourceMap
	 * @param targetMap
	 * @param keyPrefix
	 * @return
	 */
	public static <E extends Object> Map<String, E> subMap(Map<String, E> sourceMap, Map<String, E> targetMap, String keyPrefix){
		Set<Map.Entry<String, E>> entrys = sourceMap.entrySet();
		for(Map.Entry<String, E> entry : entrys){
			String key = entry.getKey();
			if(key != null && key.startsWith(keyPrefix)){
				targetMap.put(key.replace(keyPrefix, ""), entry.getValue());
			}
		}
		return targetMap;
	}
	
	/**
	 * <p>For program debug use , print each item of collection</p>
	 * @param c
	 */
	public static void print(Collection<?> c){
		ArrayUtils.print(c.toArray());
	}
	
	public static <E extends Object> boolean inList(String id, List<E> idList){
		for(E i : idList){
			if(i.equals(id)){
				return true;
			}
		}
		return false;
	}
	
	public static void printMap(Map map){
		Set<Map.Entry> entrySet = map.entrySet();
		for(Map.Entry entry : entrySet){
			entry.getKey();
			entry.getValue();
			System.out.println(String.format("K: %s, V: %s", entry.getKey(), entry.getValue()));
		}
	}
	
	public static <E extends Object> void reverse(List<E> list){ 
		if(list == null || list.isEmpty()){
			return;
		}
		int size = list.size();
		E temp = null;
		for(int i=0; i<size/2; i++){
			temp = list.get(i);
			list.set(i, list.get(size-1-i));
			list.set(size-1-i, temp);
		}
	}
	
	public static void sort(List orgList, String sortField, boolean asc){
		BeanComparator comparator = new BeanComparator();
		comparator.setComparaFields(sortField);
		comparator.setAsc(asc);
		Collections.sort(orgList, comparator);
	}
	
	public static void sort(List orgList, String sortField){
		sort(orgList, sortField, true);
	}
	
	public static boolean isEmpty(List list){
		if(list==null){
			return true;
		}else{
			return list.isEmpty();
		}
	}
	
	public static boolean isNotEmpty(List list){
		return !isEmpty(list);
	}
	
	public static int size(List list){
		if(isEmpty(list)){
			return 0;
		}else{
			return list.size();
		}
	}
	
	/**
	 * <p>turn source set to list</p>
	 * @param set source set
	 * @return
	 */
	public static <T extends Object> List<T> turnSetToList(Set<T> set){
		return new ArrayList<T>(set);
	}
	
	/**
	 * <p>Turn source list to Set</p>
	 * @param list source list
	 * @return
	 */
	public static<T extends Object> Set<T> turnListToSet(List<T> list){
		Set set = new HashSet<T>();
		if(list != null){
			for(T obj : list){
				set.add(obj);
			}
		}
		return set;
	}
	
	/**
	 * <p>turn source map's to list</p>
	 * @param map source map
	 * @return
	 */
	public static <T extends Object> List<T> turnMapKeyToList(Map map){
		return new ArrayList<T>(map.keySet());
	} 
	
	/**
	 * <p>Generate reverse result</p>
	 * @param allResult all result
	 * @param partResult part result
	 * @return reverse result
	 */
	public static <T extends Object> List<T> getReverseResult(Set<T> allResult, Set<T> partResult){
		List<T> resultList = new ArrayList<T>();
		Map<T,T> map = new HashMap<T,T>();
		if(partResult != null){
			for(T obj : partResult){
				map.put(obj, obj);
			}
		}
		if(allResult != null){
			Iterator<T> itor = allResult.iterator();
			while(itor.hasNext()){
				T obj = itor.next();
				if(map.containsKey(obj)){
					itor.remove();
				}else{
					resultList.add(obj);
				}
			}
		}
		return resultList;
	}
}
