package com.upeng.commons.cache;

import java.io.IOException;

import com.upeng.commons.collections.SoftHashMap;
import com.upeng.commons.configuration.Configuration;
import com.upeng.commons.configuration.PropertiesConfiguration;

public class SoftHashMapCacheImpl implements Cache{
	
	public static final int DEFAULT_HARD_SIZE = 1000;
	
	private static SoftHashMapCacheImpl instance;
	
	//static block
	static{
		init();
	}
	
	public static void init(){
		Configuration conf = null;
		try {
			conf = new PropertiesConfiguration("SoftHashMapCacheImpl.properties");
			int hardSize = conf.getInt("hardSize", DEFAULT_HARD_SIZE);
			instance = new SoftHashMapCacheImpl(hardSize);
		} catch (IOException e) {
			System.out.println(String.format("SoftHashMapCacheImpl.properties not found! user default hard size = %s!!", DEFAULT_HARD_SIZE));
			instance = new SoftHashMapCacheImpl();
		}
	}
	
	public static SoftHashMapCacheImpl getInstance(){
		if(instance == null){
			init();
		}
		return instance;
	}
	
	//holder
	private SoftHashMap softHashMap;
	
	public SoftHashMapCacheImpl(){
		this(DEFAULT_HARD_SIZE);
	}
	
	public SoftHashMapCacheImpl(int hardSize){
		this.softHashMap = new SoftHashMap(hardSize);
	}
	
	public void clear() {
		softHashMap.clear();
	}

	public Object get(String key) {
		return softHashMap.get(key);
	}

	public <T extends Object> T get(String key, Class<T> c) {
		Object obj = softHashMap.get(key);
		if(obj != null){
			return (T)obj;
		}else{
			return null;
		}
	}

	public boolean isEmpty() {
		return softHashMap.isEmpty();
	}

	public void put(String key, Object value) {
		softHashMap.put(key, value);
	}

	public int size() {
		return softHashMap.size();
	}

	public void remove(String key){
		softHashMap.remove(key);
	}
	
	public static void main(String[] args){
		Cache cache = new SoftHashMapCacheImpl(1000);
		for(int i=0; i<100000000; i++){
			cache.put(i+"", i);
			System.out.println(cache.size());
		}
		
		System.out.println(cache.get("9000"));
	}
}
