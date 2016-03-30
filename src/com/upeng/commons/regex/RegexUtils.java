package com.upeng.commons.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtils {

	public static boolean isMobileNumber(String mobileNum){
		String regex = "^1[3|4|5|8][0-9]{9}$";
		Pattern pattern = Pattern.compile(regex, Pattern.DOTALL);
		Matcher matcher = pattern.matcher(mobileNum);
		if(matcher.find()){
			return true;
		}
		return false;
	}
	

	public static boolean isZipCode(String zipCode){
		String regex = "^[0-9]{6}$";
		Pattern pattern = Pattern.compile(regex, Pattern.DOTALL);
		Matcher matcher = pattern.matcher(zipCode);
		if(matcher.find()){
			return true;
		}
		return false;
	}
}
