package com.upeng.commons.lang;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Class operation</p>
 * @author Lucky
 *
 */
public class ClassUtils {

	/**
	 * Check two object class types, if they are same class instance return true, else return false.
	 * @param a object a
	 * @param b object b
	 * @return <code>true</code> if a & b are the same class instance
	 */
	public static boolean isSameType(Object a, Object b){
		validateParameters(a, b);
		return isSameType(a.getClass(), b.getClass());
	}
	
	/**
	 * 
	 * Check two class types,if they they are same return true, else return false.
	 * @param a object a
	 * @param b object b
	 * @return <code>true</code> if a & b are the same class instance
	 */
	public static boolean isSameType(Class<?> a, Class<?> b){
		validateParameters(a,b);
		if(a.getName().equals(b.getName())){
			return true;
		}else{
			return false;
		}
	}
	
	//for private use
	private static void validateParameters(Object a, Object b){
		if(a == null || b == null){
			throw new java.lang.IllegalArgumentException("parameters cannot be null");
		}
	}
	
	/**
	 * Get field form an object by appointing field name, it search form all declared fields</p>
	 * including private protected public final and static fields
	 * @param obj the object to fetch field
	 * @param name field name
	 * @return destination Field
	 * @throws NoSuchFieldException
	 */
	public static Field getField(Object obj, String name){
		try{
			Field field =  obj.getClass().getDeclaredField(name);
			field.setAccessible(true);
			return field;
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
	public static Field getField(Class<?> c, String name){
		try{
			Field field =  c.getDeclaredField(name);
			field.setAccessible(true);
			return field;
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * Get no static field nor final field form an object by appointing field name, it search form all declared fields
	 * including private protected and public field
	 * @param obj the object to fetch fields
	 * @return Field array
	 */
	public static Field[] getNoStaticNorFinalFieldArray(Object obj){
		return getNoStaticNorFinalFieldArray(obj.getClass());
	}
	
	public static Field[] getNoStaticNorFinalFieldArray(Class<?> c){
		return getNoStaticNorFinalFieldList(c).toArray(new Field[]{});
	}
	
	/**
	 * Get no static field nor final field form an object by appointing field name, it search form all declared fields
	 * including private protected and public fields
	 * @param obj the object to fetch field
	 * @return Field list
	 */
	public static List<Field> getNoStaticNorFinalFieldList(Object obj){
		return getNoStaticNorFinalFieldList(obj.getClass());
	}
	
	public static List<Field> getNoStaticNorFinalFieldList(Class<?> c){
		Field[] fields = c.getDeclaredFields();
		List<Field> nostaticFieldList = new ArrayList<Field>();
		for(Field field : fields){
			field.setAccessible(true);
			if(!Modifier.isStatic(field.getModifiers()) && !Modifier.isFinal(field.getModifiers())){
				nostaticFieldList.add(field);
			}
		}
		return nostaticFieldList;
	}
	
	/**
	 * Get no static field form an object by appointing field name, it search form all declared fields
	 * including private protected and public field
	 * @param obj the object to fetch fields
	 * @return Field array
	 */
	public static Field[] getNoStaticFieldArray(Object obj){
		return getNoStaticFieldArray(obj.getClass());
	}
	
	public static Field[] getNoStaticFieldArray(Class<?> c){
		return getNoStaticFieldList(c).toArray(new Field[]{});
	}
	
	/**
	 * Get no static field form an object by appointing field name, it search form all declared fields
	 * including private protected and public fields
	 * @param obj the object to fetch field
	 * @return Field list
	 */
	public static List<Field> getNoStaticFieldList(Object obj){
		return getNoStaticFieldList(obj.getClass());
	}
	
	public static List<Field> getNoStaticFieldList(Class<?> c){
		Field[] fields = c.getDeclaredFields();
		List<Field> nostaticFieldList = new ArrayList<Field>();
		for(Field field : fields){
			field.setAccessible(true);
			if(!Modifier.isStatic(field.getModifiers())){
				nostaticFieldList.add(field);
			}
		}
		return nostaticFieldList;
	}
	
	/**
	 * Get field form an object by appointing field name, it search form all declared fields but not static or final
	 * including private protected and public fields
	 * @param obj the object to fetch field
	 * @param name field name
	 * @return destination
	 * @throws NoSuchFieldException
	 */
	public static Field getNoStaticNorFinalField(Object obj, String name)  throws NoSuchFieldException{
		return getNoStaticNorFinalField(obj.getClass(), name);
	}
	
	public static Field getNoStaticNorFinalField(Class<?> c, String name)  throws NoSuchFieldException{
		Field[] fields = c.getDeclaredFields();
		for(Field field : fields){
			field.setAccessible(true);
			if(!Modifier.isStatic(field.getModifiers()) && !Modifier.isFinal(field.getModifiers())){
				if(field.getName().equals(name)){
					return field;
				}
			}		
		}
		throw new NoSuchFieldException(String.format("No such field: %s", name));
	}
	
	/**
	 * <p>Check weather specify class is from JDK </p>
	 * @param c
	 * @return
	 */
	public static boolean isSystemClass(Class<?> c){
		return c.getName().startsWith("java.");
	}
	
	public static boolean isNumberClass(Class<?> c){
		if(c.getName().equals("int") || c.getName().equals("double") || c.getName().equals("float") || c.getName().equals("short")){
			return true;
		}else if(c.equals(Integer.class) || c.equals(Double.class) || c.equals(Short.class) || c.equals(Float.class)){
			return true;
		}
		return false;
	}
}
