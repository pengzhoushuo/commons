/**
 * 
 */
package com.upeng.commons.beans;

import java.beans.Expression;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.upeng.commons.lang.ClassUtils;
import com.upeng.commons.lang.StringUtils;

/**
 * <p>Java Bean Operation</p>
 * @author Lucky
 *
 */
public class BeanUtils { 

	/**
	 * <p>Copy field value form source to destination, not include specify field name</p>
	 * <p>Final & static field are excluded</p>
	 * @param <E> 
	 * @param source source object
	 * @param dest destination object
	 * @param excludedFieldName field name specify for not included
	 * @return
	 */
	public static <E extends Object> E copy(Object source, E dest, String... excludedFieldName){
		if(source == null || dest == null){
			return null;
		}
		Field[] fields = ClassUtils.getNoStaticNorFinalFieldArray(source);		
		try{
			if(ClassUtils.isSameType(source, dest)){//same type object
				for(Field field : fields){
					field.setAccessible(true);			
					if(StringUtils.isInList(field.getName(), excludedFieldName)){//filter 
						continue;
					}			
					field.set(dest, field.get(source));
				}
			}else{
				for(Field field : fields){
					field.setAccessible(true);			
					if(StringUtils.isInList(field.getName(), excludedFieldName)){//filter
						continue;
					}			
					Field destField = null;
					try{
						destField = dest.getClass().getDeclaredField(field.getName());
					}catch(NoSuchFieldException e){
					}
					if(destField != null){
						destField.setAccessible(true);						
						destField.set(dest, field.get(source));
					}
				}
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return dest;
	}
	
	/**
	 * <p>Return standard JavaBean set Method Name</p>
	 * <p>etc. input: 'age' output: 'setAge' </p>
	 * @param field
	 * @return
	 */
	public static String getSetMethodName(String field){
		return  "set" + StringUtils.firstLetterUpper(field);
	}
	
	/**
	 * <p>Return standard JavaBean get Method Name</p>
	 * <p>etc. input: 'age' output: 'getAge' </p>
	 * @param field
	 * @return
	 */
	public static String getGetMethodName(String field){
		return  "get" + StringUtils.firstLetterUpper(field);
	}
	
	/**
	 * <p>Inject a instance set value for all fields in Map</p>
	 * <p>This will call setField method for all fields, if failure set field value directly for using reflection</p>
	 * @param classFullName
	 * @param fieldNameAndValues
	 * @return
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 * @throws IllegalAccessException
	 */
	public static Object inject(String classFullName, Map<String, Object> fieldNameAndValues) throws InstantiationException, ClassNotFoundException, IllegalAccessException{
		return inject(Class.forName(classFullName), fieldNameAndValues);
		
	}
	
	/**
	 * <p>Inject a instance set value for all fields in Map</p>
	 * <p>This will call setField method for all fields, if failure set field value directly for using reflection</p>
	 * @param c Class 
	 * @param fieldNameAndValues
	 * @return
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 * @throws IllegalAccessException
	 */
	public static Object inject(Class<?> c, Map<String, Object> fieldNameAndValues) throws InstantiationException, ClassNotFoundException, IllegalAccessException{
		Object target = c.newInstance();
		return inject(target, fieldNameAndValues);
	}
	
	/**
	 * <p>Inject a instance set value for all fields in Map</p>
	 * <p>This will call setField method for all fields, if failure set field value directly for using reflection</p>
	 * @param target taget instance
	 * @param fieldNameAndValues
	 * @return
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 * @throws IllegalAccessException
	 */
	public static Object inject(Object target, Map<String, Object> fieldNameAndValues) throws InstantiationException, ClassNotFoundException, IllegalAccessException{
		Set<Map.Entry<String,Object>> keyValues = fieldNameAndValues.entrySet();
		for(Map.Entry<String, Object> keyValue : keyValues){
			String methodName = getSetMethodName(keyValue.getKey());
			Expression exp = new Expression(target, methodName, new Object[]{keyValue.getValue()});
			try {
				exp.getValue();
			} catch (Exception e) {
				ExpressionUtils.setFieldValue(target, keyValue.getKey(), keyValue.getValue());
			}
		}
		return target;
	}
	
	/**
	 * <p>Inject a value to target's field, the value must match actual type of the field</p>
	 * <p>First it calls setXXX method, if fails set field value directory</p>
	 * @param target target Object to inject
	 * @param field target field to inject
	 * @param value field value
	 */
	public static void injectField(Object target, Field field, Object value){
		String setMethodName = BeanUtils.getSetMethodName(field.getName());
		try {
			ExpressionUtils.executeMethod(target, setMethodName, new Object[]{value});
		} catch (Exception e) {
			ExpressionUtils.setFieldValue(target, field, value);
		}
	}
	
	/**
	 * <p>Check input class is basice type</p>
	 * @param c class type
	 * @return
	 */
	public static boolean isBasicType(Class<?> c){
		if(String.class.equals(c)){
			return true;
		}else if(Integer.class.equals(c) || int.class.equals(c)){
			return true;
		}else if(Double.class.equals(c) || double.class.equals(c)){
			return true;
		}else if(Float.class.equals(c) || float.class.equals(c)){
			return true;
		}else if(Long.class.equals(c) || long.class.equals(c)){
			return true;
		}else if(Short.class.equals(c) || short.class.equals(c)){
			return true;
		}else if(Boolean.class.equals(c) || boolean.class.equals(c)){
			return true;
		}else if(Byte.class.equals(c) || byte.class.equals(c)){
			return true;
		}else if(Character.class.equals(c) || char.class.equals(c)){
			return true;
		}else if(Date.class.equals(c)){
			return true;
		}else if(List.class.equals(c) || ArrayList.class.equals(c)){
			return true;
		}else if(String[].class.equals(c)){
			return true;
		}else if(int[].class.equals(c) || Integer[].class.equals(c)){
			return true;
		}else if(long[].class.equals(c) || Long[].class.equals(c)){
			return true;
		}else if(short[].class.equals(c) || Short[].class.equals(c)){
			return true;
		}else if(float[].class.equals(c) || Float[].class.equals(c)){
			return true;
		}else if(double[].class.equals(c) || Double[].class.equals(c)){
			return true;
		}else if(byte[].class.equals(c) || Byte[].class.equals(c)){
			return true;
		}else if(boolean[].class.equals(c) || Boolean[].class.equals(c)){
			return true;
		}else if(char[].class.equals(c) || Character[].class.equals(c)){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * <p>Description: Validate all not static nor final field, if one field value is null, then return false. otherwise return true<p>
	 * @param obj the object to check
	 * @param excludeFieldNames exclude field name array
	 * @return
	 */
	public static boolean validateNotNullFields(Object obj, String ...excludeFieldNames){
		Field[] fiellds = ClassUtils.getNoStaticNorFinalFieldArray(obj);
		for(Field field : fiellds){
			try {
				if(field.get(obj) == null && !StringUtils.isInList(field.getName(), excludeFieldNames)){
					return false;
				}
			} catch (Exception e) {
				throw new RuntimeException(e);
			} 
		}
		return true;
	}
	
	/**
	 * <p>Description: Validate all not static nor final field, if one field value is null or blank, then return false. otherwise return true<p>
	 * @param obj the object to check
	 * @param excludeFieldNames exclude field name array
	 * @return
	 */
	public static boolean validateNotBlankFields(Object obj, String ...excludeFieldNames){
		Field[] fiellds = ClassUtils.getNoStaticNorFinalFieldArray(obj);
		for(Field field : fiellds){
			try {
				Object o = field.get(obj);
				if(o == null && !StringUtils.isInList(field.getName(), excludeFieldNames)){
					return false;
				}else if(o!= null && StringUtils.isEmpty(o.toString()) && !StringUtils.isInList(field.getName(), excludeFieldNames)){
					return false;
				}
			} catch (Exception e) {
				throw new RuntimeException(e);
			} 
		}
		return true;
	}
	
	/**
	 * <p>Description: Get Bean Field value or get value from a Map by key<p>
	 * @param fieldName
	 * @return
	 */
	public static Object getValue(Object obj, String fieldName){
		if(obj!=null && obj instanceof Map){
			return ((Map)obj).get(fieldName);
		}
		return ExpressionUtils.getFieldValue(obj, fieldName);
	}
}
