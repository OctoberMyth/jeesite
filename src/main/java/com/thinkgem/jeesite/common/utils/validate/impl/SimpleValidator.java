package com.thinkgem.jeesite.common.utils.validate.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleValidator{

	public static boolean test(String value,String regex) {
		Pattern pattern = Pattern.compile(regex);
		Matcher match = pattern.matcher(value.toString());
		if(match.matches()==false){
			return false;
		}else{
			return true;
		}
	}
	
	public static boolean test(Object value,String regex) {
		Pattern pattern = Pattern.compile(regex);
		Matcher match = pattern.matcher(value.toString());
		if(match.matches()==false){
			return false;
		}else{
			return true;
		}
	}

}
