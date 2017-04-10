package com.thinkgem.jeesite.test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.thinkgem.jeesite.common.utils.validate.ValidateProcess;
import com.thinkgem.jeesite.test.entity.TestData;

public class Test {

    public static void main(String[] args) {
    	String regex = "^(([1-9]{1}\\d*)|([0]{1}))(\\.(\\d){0,2})?$";
    	
    	Pattern pattern = Pattern.compile(regex);
		Matcher match = pattern.matcher("0.01");
		if(match.matches()){
			System.out.println(match.matches()+":");
		}
    	
//        TestData t = new TestData();
//        t.setAmount(new BigDecimal(10.00));
//        t.setSex("nan");
//        t.setNumber(1);
//        t.setBeginInDate(new Date());
//        ValidateProcess.process(t);
    }
}
