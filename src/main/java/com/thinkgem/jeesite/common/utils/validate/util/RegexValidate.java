package com.thinkgem.jeesite.common.utils.validate.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexValidate {

	public static boolean test(Object value,String regex) {
		Pattern pattern = Pattern.compile(regex);
		Matcher match = pattern.matcher(value.toString());
		if(match.matches()){
			return true;
		}else{
			return false;
		}
	}
}
