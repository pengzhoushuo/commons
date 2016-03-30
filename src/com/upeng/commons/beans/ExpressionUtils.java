/**
 * 
 */
package com.upeng.commons.beans;

import java.beans.Expression;
import java.lang.reflect.Field;
import java.util.List;

import com.upeng.commons.lang.ClassUtils;

/**
 * <p>Method and Field operation</p>
 * @author Lucky
 *
 */
public class ExpressionUtils {
	
	/**
	 * <p>Execute method use reflection</p>
	 * @see java.beans.Expression
	 * @param target target object
	 * @param methodName the method for execute
	 * @param arguments the arguments to this method
	 * @return execute result
	 */
	public static Object executeMethod(Object target, String methodName, Object[] arguments){
		Expression exp = new Expression(target, methodName, arguments);
		try {
			return exp.getValue();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * <p>Description:Execute method use reflection <p>
	 * @param c target object class
	 * @param methodName  the method for execute
	 * @param arguments the arguments to this method
	 * @return execute result
	 */
	public static Object executeMethod(Class<?> c, String methodName, Object[] arguments){
		try {
			Expression exp = new Expression(c.newInstance(), methodName, arguments);
			return exp.getValue();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
		
	/**
	 * <p>Get object field value. </p>
	 * @param obj target object
	 * @param name field name 
	 * @return field value
	 */
	public static Object getFieldValue(Object obj, String name){
		try{
			return ClassUtils.getField(obj, name).get(obj);
		}catch(Exception e){
			throw new IllegalArgumentException(String.format("Field name %s not found.", name));
		}	
	}
	
	/**
	 * <p>Set object field value</p>
	 * @param obj
	 * @param fieldName
	 * @param value
	 */
	public static void setFieldValue(Object obj, String fieldName, Object value){
		Field field = null;
		try{
			field = ClassUtils.getField(obj, fieldName);
			setFieldValue(obj, field, value);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * <p>Description: Set object field value<<p>
	 * @param obj
	 * @param field
	 * @param value
	 */
	public static void setFieldValue(Object obj, Field field, Object value){
		try {
			
			if(value == null && ClassUtils.isNumberClass(field.getType())){
				return;
			}
			field.set(obj, value);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * <p>Description: Execute method of a class collection until not exception found<p>
	 * @param classList
	 * @param methodName
	 * @param arguments
	 * @return
	 * @throws Exception
	 */
	public static Object executeMethod(List<Class<?>> classList, String methodName, Object[] arguments) throws Exception{
		Object result = null;
		for(Class<?> c : classList){
			try{
				result = executeMethod(c, methodName, arguments);
				break;
			}catch(Exception unused){
			}
		}
		return result;
	}
}
