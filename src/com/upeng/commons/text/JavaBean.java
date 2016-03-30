/*
 * @# JavaBean.java.java 9:42:36 PM Feb 7, 2010 2010
 * Copyright 2010 UnclePeng. All rights reserved.
 */
package com.upeng.commons.text;

import java.util.ArrayList;
import java.util.List;

import com.upeng.commons.lang.builder.ToStringBuilder;

/**
 * <p>JavaBean style text description</p>
 * @author UnclePeng
 */
public class JavaBean {
	
	//etc. com.upeng.commons
	private String packageName;
	
	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	//etc. JTree
	private String beanClassName;

	public String getBeanClassName() {
		return beanClassName;
	}

	public void setBeanClassName(String name) {
		this.beanClassName = name;
	}

	//fields
	private List<Field> values = new ArrayList<Field>();
	
	public List<Field> getValues() {
		return values;
	}

	public void setValues(List<Field> values) {
		this.values = values;
	}

	public void addField(String type, String name){
		values.add(new Field(type, name)); 
	}
	
	public static class Field{
		//etc. String
		String fieldType;

		public String getFieldType() {
			return fieldType;
		}

		public void setFieldType(String fieldType) {
			this.fieldType = fieldType;
		}

		public String getFieldName() {
			return fieldName;
		}

		public void setFieldName(String fieldName) {
			this.fieldName = fieldName;
		}
		
		//etc. userName
		String fieldName;
		
		public Field(String type, String name){
			this.fieldType = type;
			this.fieldName = name;
		}
		
		public String toString(){
			return ToStringBuilder.reflectionToString(this);
		}
	}
	
	public String toString(){
		return ToStringBuilder.reflectionToString(this);
	}
}
