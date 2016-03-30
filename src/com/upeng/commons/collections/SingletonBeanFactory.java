package com.upeng.commons.collections;

import java.util.HashMap;
import java.util.Map;

public class SingletonBeanFactory {

	//singleton bean name and bean instance
	private static Map singletonBeanMap = new HashMap();
	
	/**
	 * <p>Description: Return a singleton bean instance<p>
	 * @param <T> 
	 * @param beanClass
	 * @return
	 */
	public <T extends Object> T getBean(Class<T> beanClass){
		Object obj = singletonBeanMap.get(beanClass.getName());
		if(obj == null){
			synchronized(singletonBeanMap){
				try {
					T beanInstance = beanClass.newInstance();
					singletonBeanMap.put(beanClass.getName(), beanInstance);
					return beanInstance;
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
		}
		return (T)obj;
	}
}
