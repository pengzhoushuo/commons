package com.upeng.commons.math;

import java.util.Date;

import com.upeng.commons.lang.ArrayUtils;
import com.upeng.commons.lang.DateUtils;
import com.upeng.commons.lang.NumberUtils;
import com.upeng.commons.lang.StringUtils;

/**
 * <p>OperationExpression</p>
 * @author Lucky
 */
public class OperationExpression {

	//operation interface
	interface Operation{
		boolean equal(String data1, String data2);
		boolean less(String data1, String data2);
		boolean lessEqual(String data1, String data2);
		boolean more(String data1, String data2);
		boolean moreEqual(String data1, String data2);
		boolean in(String data1, String data2);
		boolean notIn(String data1, String data2);
		
		//count result
		boolean count(String data1, String operator, String data2);
	}
	
	//common
	abstract static class AbstractOperation implements Operation{
		public abstract boolean equal(String data1, String data2);
		
		public boolean notEqual(String data1, String data2){
			return !equal(data1, data2);
		}
		
		public abstract boolean less(String data1, String data2);
		
		public boolean lessEqual(String data1, String data2){
			return !more(data1, data2);
		}
		
		public abstract boolean more(String data1, String data2);
		
		public boolean moreEqual(String data1, String data2){
			return !less(data1, data2);
		}
		
		public abstract boolean in(String data1, String data2);
		
		public boolean notIn(String data1, String data2){
			return !in(data1, data2);
		}
		
		public boolean count(String data1, String operator, String data2){
			if("==".equalsIgnoreCase(operator)){
				return equal(data1, data2);
			}else if("!=".equalsIgnoreCase(operator)){
				return notEqual(data1, data2);
			}else if("<".equalsIgnoreCase(operator)){
				return less(data1, data2);
			}else if("<=".equalsIgnoreCase(operator)){
				return lessEqual(data1, data2);
			}else if(">".equalsIgnoreCase(operator)){
				return more(data1, data2);
			}else if(">=".equalsIgnoreCase(operator)){
				return moreEqual(data1, data2);
			}else if("in".equalsIgnoreCase(operator)){
				return in(data1, data2);
			}else if("not in".equalsIgnoreCase(operator)){
				return notIn(data1, data2);
			}else{
				throw new UnsupportedOperationException("Unsupported operation: " + operator);
			}
		}
	}
	
	//Operation of String
	static class StringOperation extends AbstractOperation{
		public boolean equal(String data1, String data2) {
			return data1.equals(data2);
		}

		public boolean in(String data1, String data2) {
			return ArrayUtils.indexOf(ArrayUtils.toStringArray(data2), data1) != -1;
		}

		public boolean less(String data1, String data2) {
			throw new UnsupportedOperationException("String unsupport this operation");
		}

		public boolean more(String data1, String data2) {
			throw new UnsupportedOperationException("String unsupport this operation");
		}
	}
	
	//Operation of Number
	static class NumberOperation extends AbstractOperation{
		
		public boolean equal(String data1, String data2) {
			return NumberUtils.toDoubleStrict(data1) -NumberUtils.toDoubleStrict(data2) == 0;
		}

		public boolean in(String data1, String data2) {
			double[] doubleArray = ArrayUtils.toDoubleArrayStrict(data2);
			double double1 = NumberUtils.toDoubleStrict(data1);
			for(double double2 : doubleArray){
				if(double1 == double2){
					return true;
				}
			}
			return false;
		}

		public boolean less(String data1, String data2) {
			return NumberUtils.toDoubleStrict(data1) < NumberUtils.toDoubleStrict(data2);
		}

		public boolean more(String data1, String data2) {
			return NumberUtils.toDoubleStrict(data1) > NumberUtils.toDoubleStrict(data2);
		}
	}
	
	//Operation of Date
	static class DateOperation extends AbstractOperation{
		public boolean equal(String data1, String data2) {
			return DateUtils.toDate(data1).equals(DateUtils.toDate(data2));
		}
		
		public boolean in(String data1, String data2) {
			Date[] dates = ArrayUtils.toDateArray(data2);
			Date date1 = DateUtils.toDate(data1);
			for(Date date : dates){
				if(date1.equals(date)){
					return true;
				}
			}
			return false;
		}

		public boolean less(String data1, String data2) {
			return DateUtils.toDate(data1).before(DateUtils.toDate(data2));
		}

		public boolean more(String data1, String data2) {
			return DateUtils.toDate(data1).after(DateUtils.toDate(data2));
		}
	}
	
	/**
	 * <p>Description: Get Result true/false from Operation Expression<p>
	 * @param data1 1,2
	 * @param operator >,<,>=,<=,==,!=,in,not in
	 * @param data2 1,[1,2],1,2,3
	 * @return
	 */
	public static boolean count(String data1, String operator, String data2){
		if(StringUtils.isBlank(data1)){
			throw new IllegalArgumentException("Data1 must not be blank");
		}else{
			if(StringUtils.isBlank(operator)){
				throw new IllegalArgumentException("Operator must not be blank");
			}else if(StringUtils.isEmpty(data2)){
				throw new IllegalArgumentException("Data2 must not be blank");
			}
			int type = getType(data1, data2);
			if(type == 1){
				return countNum(data1, operator, data2);
			}else if(type == 2){
				return countDate(data1, operator, data2);
			}else{
				
				return countString(data1, operator, data2);
			}
		}
	}
	
	//1 number, 2 date, 3 string
	private static int getType(String data1, String data2){
		if(StringUtils.contains(data2, ",")){
			if(StringUtils.isNumString(data1)){
				try{
					ArrayUtils.toDoubleArrayStrict(data2);
					return 1;
				}catch(Exception e){
					return 3;
				}
			}else if(StringUtils.isDateString(data1)){
				try{
					ArrayUtils.toDateArray(data1);
					return 2;
				}catch(Exception e){
					return 3;
				}
			}
		}else{
			if(StringUtils.isNumString(data1)){
				if(StringUtils.isNumString(data2)){
					return 1;
				}
				return 3;
			}else if(StringUtils.isDateString(data1)){
				if(StringUtils.isDateString(data2)){
					return 2;
				}
				return 3;
			}
		}
		return 3;
	}
	
	private static boolean countNum(String data1, String operator, String data2){
		Operation operation = new NumberOperation();
		return operation.count(data1, operator, data2);
	}
	
	private static boolean countString(String data1, String operator, String data2){
		Operation operation = new StringOperation();
		System.out.println("string");
		return operation.count(data1, operator, data2);
	}
	
	private static boolean countDate(String data1, String operator, String data2){
		Operation operation = new DateOperation();
		System.out.println("date");
		return operation.count(data1, operator, data2);
	}
}
