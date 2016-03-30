package com.upeng.commons.regex;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.upeng.commons.beans.BeanUtils;
import com.upeng.commons.lang.ClassUtils;
import com.upeng.commons.net.HttpRequestUtils;

public class BeanFromRegexUtils {

	public static <T extends Object> T getBeanFromRegex(Class<T> beanType, String str) throws Exception{
		//instance for return
		T bean = beanType.newInstance();
		Field[] fields = ClassUtils.getNoStaticNorFinalFieldArray(bean);
		for(Field field : fields){
			Regex regexAnnotation = field.getAnnotation(Regex.class);
			if(regexAnnotation != null){
				int group = regexAnnotation.group();
				String patternStr = regexAnnotation.pattern();
		        Pattern pattern = Pattern.compile(patternStr, Pattern.DOTALL);
		        Matcher matcher = pattern.matcher(str);
		        if(matcher.find()){
		        	String value = matcher.group(group);
		        	BeanUtils.injectField(bean, field, value);
		        }
			}
		}
		return bean;
	}
	
	public static <T extends Object> List<T> getBeanListFromRegex(Class<T> beanType, String str) throws Exception{
		List<T> beanList = new ArrayList<T>(); 
		Field[] fields = ClassUtils.getNoStaticNorFinalFieldArray(beanType);
		int fieldIndex = 0;
		for(Field field : fields){
			Regex regexAnnotation = field.getAnnotation(Regex.class);
			if(regexAnnotation != null){
				int group = regexAnnotation.group();
				String patternStr = regexAnnotation.pattern();
		        Pattern pattern = Pattern.compile(patternStr, Pattern.DOTALL);
		        Matcher matcher = pattern.matcher(str);
		        int beanIndex = 0;
		        while(matcher.find()){
		        	T bean = null;
		        	if(fieldIndex < 1){
		        		bean = beanType.newInstance();
		        		beanList.add(bean);
		        	}else if(beanList.size() > beanIndex){
		        		bean = beanList.get(beanIndex);
		        	}else{
		        		bean = beanType.newInstance();
		        		beanList.add(bean);
		        	}
		        	String value = matcher.group(group);
		        	BeanUtils.injectField(bean, field, value);
		        	beanIndex++;
		        }
			}
			fieldIndex++;
		}
		return beanList;
	}
	
	public static <T extends Object> T getBeanFromRegexAndUrl(Class<T> beanType, String url, String charSetName) throws Exception{
		String content = HttpRequestUtils.doGet(url, charSetName);
		return getBeanFromRegex(beanType, content);
	}
	
	public static <T extends Object> List<T> getBeanListFromRegexAndUrl(Class<T> beanType, String url, String charSetName) throws Exception{
		String content = HttpRequestUtils.doGet(url, charSetName);
		return getBeanListFromRegex(beanType, content);
	}
}
