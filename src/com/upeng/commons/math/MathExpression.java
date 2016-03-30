package com.upeng.commons.math;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.upeng.commons.collections.ArrayStack;
import com.upeng.commons.collections.CollectionsUtils;
import com.upeng.commons.lang.CharUtils;
import com.upeng.commons.lang.NumberUtils;
import com.upeng.commons.lang.StringUtils;
import com.upeng.commons.lang.builder.ToStringBuilder;

/**
 * <p>MathExpression</p>
 * @author Lucky
 */
public class MathExpression {

	//package number、operator, brackets as item
	static class Item{
		
		public static final int NUMBER = 51;
		public static final int UNKNOW = 500;
		
		private String value;
		private int type = NUMBER;//default type is number

		public String getValue() {
			return value;
		}

		public void setValue(String value) { 
			this.value = value;
			if(this.value.length() == 1){
				 char c = CharUtils.toChar(this.value);
				 if(!isNumber(c)){//not a number
					 setType(getTypeByChar(c));
				 }
			}
		}

		public int getType() {
			return type;
		}

		public void setType(int type) {
			this.type = type;
		}
		
		public String toString(){
			return ToStringBuilder.reflectionToString(this);
		}
		
		public static int getTypeByChar(char c){
			int currentType = UNKNOW;
			switch(c){
				case '*': currentType = 11; break; 
				case '/': currentType = 12; break;
				case '%': currentType = 13; break;
				case '+': currentType = 21; break;
				case '-': currentType = 22; break;
				case '(': currentType = 31; break;
				case ')': currentType = 32; break;
				case '.': currentType = 41; break;
				case '0': currentType = 0; break;
				case '1': currentType = 1; break;
				case '2': currentType = 2; break;
				case '3': currentType = 3; break;
				case '4': currentType = 4; break;
				case '5': currentType = 5; break;
				case '6': currentType = 6; break;
				case '7': currentType = 7; break;
				case '8': currentType = 8; break;
				case '9': currentType = 9; break;
			}
			return currentType;
		}
		
//		//convert number string to double
//		public double getDoubleValue(){
//			if(this.type == NUMBER){
//				return NumberUtils.toDoubleStrict(this.getValue());
//			}else{
//				throw new IllegalArgumentException(String.format("%s can not convert to a number", this.value));
//			}
//		}
		
		public BigDecimal getBigDecimal(){
			BigDecimal dec = new BigDecimal(this.getValue());
			return dec;
		}
	}
	
	private static boolean isOperator(char c){
		int type = Item.getTypeByChar(c);
		return (type < 30 && type > 10);
	}
	
	private static boolean isBrackets(char c){
		int type = Item.getTypeByChar(c);
		return (type > 30 && type < 40);
	}
	
	private static boolean isNumber(char c){
		return Item.getTypeByChar(c) < 10 || Item.getTypeByChar(c) == 41;
	}
	
	//number1 +-*/% number2
	private static Item count(Item item1, Item item2, Item item3){
		String value;
		switch(item2.getType()){
			case 11: value = item1.getBigDecimal().multiply(item3.getBigDecimal()).toString(); break;
			case 12: value = item1.getBigDecimal().divide(item3.getBigDecimal(), 10, BigDecimal.ROUND_HALF_UP).toString(); break;
			case 13: value = item1.getBigDecimal().remainder(item3.getBigDecimal()).toString(); break;
			case 21: value = item1.getBigDecimal().add(item3.getBigDecimal()).toString(); break;
			case 22: value = item1.getBigDecimal().subtract(item3.getBigDecimal()).toString(); break;
			default: throw new IllegalArgumentException(String.format("%s is invalidate operator", item2.getValue()));
		}
		Item item = new Item();
		item.setValue(value);
		item.setType(Item.NUMBER);
		return item;
	}
	
	//with no brackets
	private static Item count (List<Item> itemList){
		if(itemList.size() == 1){
			return itemList.get(0);
		}
		for(int i=0; i<itemList.size(); i++){//handle high operation
			Item item = itemList.get(i);
			if(item.getType()>10 && item.getType()<20){
				if(i > 0 && i + 1 < itemList.size()){
					Item preItem = itemList.get(i-1);
					Item nextItem = itemList.get(i+1);
					itemList.set(i, count(preItem, item, nextItem));
					itemList.remove(preItem);
					itemList.remove(nextItem);
					return count(itemList);
				}
			}
			if(i<20 && i<30){
				continue;
			}else{
				throw new IllegalArgumentException("Illegal Expression");
			}
		}
		for(int i=0; i<itemList.size(); i++){//handle low operation
			Item item = itemList.get(i);
			if(i<20 && i<30){
				if(i > 0 && i + 1 < itemList.size()){
					Item preItem = itemList.get(i-1);
					Item nextItem = itemList.get(i+1);
					itemList.set(i, count(preItem, item, nextItem));
					itemList.remove(preItem);
					itemList.remove(nextItem);
					return count(itemList);
				}
			}else{
				throw new IllegalArgumentException("Illegal Expression");
			}
		}
		return count(itemList);
	}
	
	//with brackets
	private static Item popItemsHasBrackets(List<Item> items){
		ArrayStack<Item> stack = new ArrayStack<Item>();
		for(Item item : items){
			if(item.getType() != 32){// '('
				stack.push(item);
			}else{
				List<Item> shortItems = new LinkedList<Item>();
				Item stackItem;
				while((stackItem = stack.pop()).getType() != 31){
					shortItems.add(stackItem);
				}
				CollectionsUtils.reverse(shortItems);
				stack.push(count(shortItems));
			}
		}
		return count(stack);
	}
	
	//split a string to some items and push them to a list
	private static List<Item> splitItem2List(String str){
		if(StringUtils.isBlank(str)){
			throw new IllegalArgumentException("Input String can not be blank");
		}
		char[] cs = str.toCharArray();
		List<Item> itemList = new ArrayList<Item>();
		StringBuilder sbNumber = new StringBuilder();
		int preType =Item.UNKNOW;
		for(char c : cs){
			if(c == ' '){//ignore
				continue;
			}
			if(isNumber(c)){//number
				sbNumber.append(c);
				preType = Item.NUMBER;
			}else{
				if(sbNumber.length() > 0){
					Item item  = new Item();
					item.setValue(sbNumber.toString());
					itemList.add(item);
				}
				if(isOperator(c)){//operator
					if(preType > 10 && preType < 30 || preType == Item.UNKNOW){// +-/-number
						throw new IllegalArgumentException("Illegal expression");
					}
					sbNumber = new StringBuilder();
					Item item  =new Item();
					item.setValue(String.valueOf(c));
					itemList.add(item);
					preType = item.getType();
				}else if(isBrackets(c)){//brackets
					sbNumber = new StringBuilder();
					Item item  =new Item();
					item.setValue(String.valueOf(c));
					itemList.add(item);
					preType = item.getType();
				}else{//unknow
					throw new IllegalArgumentException("Illegal expression");
				}
			}
		}
		if(sbNumber.length() > 0){//the last number, if has
			Item item  =new Item();
			item.setValue(sbNumber.toString());
			itemList.add(item);
			sbNumber = null;
		}
		return itemList;
	}
	
	/**
	 * <p>Description: Get value from an expression string <p>
	 * @param expressStr expression string
	 * @return
	 * @throws Exception
	 */
	public static String count(String expressStr) throws Exception{
		Item item = popItemsHasBrackets(splitItem2List(expressStr));
		return NumberUtils.trimZero(item.getValue());
	}
	
	public static void main(String[] args) throws Exception{
		List<Item> items = new LinkedList<Item>();
		Item item1 = new Item();
		item1.setValue("54");
		Item item2 = new Item();
		item2.setValue("*");
		item2.setType(11);
		Item item3 = new Item();
		item3.setValue("2");
		items.add(item1);
		items.add(item2);
		items.add(item3);
		Item item4 = new Item();
		item4.setValue("+");
		item4.setType(21);
		
		Item item5 = new Item();
		item5.setValue("2");
		items.add(item4);
		items.add(item5);
		
		Item item6 = new Item();
		item6.setValue("/");
		item6.setType(12);
		
		Item item7 = new Item();
		item7.setValue("10");
		item7.setType(Item.NUMBER);
		items.add(item6);
		items.add(item7);
		//System.out.println(count(items).getValue());
		for(int i=0; i<1; i++){
			String str = "(((21 + 2)*( 2         +1 )))/2+1-2*1";
			//System.out.println(count(splitItem2List(str)));
			
			try{
				System.out.println(count(str));
			}catch(Exception e){
				e.printStackTrace();
				System.err.println("错误的表达式");
			}
		}
		
		System.out.println(Integer.MAX_VALUE);
	}

}
