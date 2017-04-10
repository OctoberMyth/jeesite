package com.thinkgem.jeesite.common.utils.validate.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import com.thinkgem.jeesite.common.utils.validate.IValidator;

@Component
public class Amount implements IValidator{

	/**
	 * 金额校验
	 */
	private String regex = "^(([1-9]{1}\\d*)|([0]{1}))(\\.(\\d){0,2})?$";

	@Override
	public boolean test(Object value) {
		Pattern pattern = Pattern.compile(regex);
		Matcher match = pattern.matcher(value.toString());
		if(match.matches()==false){
			return false;
		}else{
			return true;
		}
	}
	
}
