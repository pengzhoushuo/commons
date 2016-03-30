package com.upeng.commons.cache;

/**
 * A simple Cache interface
 * @author Lucky
 */
public interface Cache {

	public void put(String key, Object value);
	
	public Object get(String key);
	
	public <T extends Object> T get(String key, Class<T> c);
	
	public int size();
	
	public boolean isEmpty();
	
	public void clear();
	
	public void remove(String key);
}
