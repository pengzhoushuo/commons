package com.upeng.commons.lang.encrypt;

import com.upeng.commons.lang.NumberUtils;
import com.upeng.commons.lang.RandomUtils;

public class SplEncrypt {

	public String encrypt(String str, String key){
		//left
		int bInt = NumberUtils.toInt(key.substring(0, 1));
		//right
		int sInt = NumberUtils.toInt(key.substring(1, 2));
		//split
		int gInt = NumberUtils.toInt(key.substring(2, 3));
		StringBuilder sb = new StringBuilder();
		sb.append(RandomUtils.randomNumeric(bInt));
		char[] cs = str.toCharArray();
		int i = 0;
		for(char c : cs){
			i++;
			sb.append(c);
			if(i==gInt){
				sb.append(RandomUtils.randomNumeric(1));
				i=0;
			}
		}
		sb.append(RandomUtils.randomNumeric(sInt));
		return sb.toString();
	}
	
	public static void main(String[] args){
		SplEncrypt splEncrypt = new SplEncrypt();
		String key = "145";
		String ssstr = splEncrypt.encrypt("abc", key);
		System.out.println(ssstr);
		System.out.println(splEncrypt.decrypt(ssstr,key));
	}
	
	public String decrypt(String sStr, String key){
		//left
		int bInt = NumberUtils.toInt(key.substring(0, 1));
		//right
		int sInt = NumberUtils.toInt(key.substring(1, 2));
		//split
		int gInt = NumberUtils.toInt(key.substring(2, 3));
		StringBuilder sb = new StringBuilder();
		sStr = sStr.substring(bInt, sStr.length() - gInt);
		char[] cs = sStr.toCharArray();
		int i = 0;
		for(char c : cs){
			if(i == gInt){
				i++;
				i=0;
			}else{
				sb.append(c);
				i++;
			}
			
		}
		return sb.toString();
	}
}
