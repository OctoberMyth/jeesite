package com.thinkgem.jeesite.test;

import java.text.MessageFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

    public static void main(String[] args) {
    	String regex = "0?(13|14|15|18)[0-9]{9}";
    	
    	Pattern pattern = Pattern.compile(regex);
		Matcher match = pattern.matcher("018888888811");
		if(match.matches()){
			System.out.println(match.matches()+":");
		}
		
		String format = "{0}--{1}";
		String[] params = {"a","b","c1"};
		String[] param = new String[params.length-1];
		for(int i = params.length-1;i >= 1;i --){
			param[i-1] = params[i];
		}
		System.out.println(param);
		String str = MessageFormat.format(format, param);
		System.out.println(str.toString());
    	
//        TestData t = new TestData();
//        t.setAmount(new BigDecimal(10.00));
//        t.setSex("nan");
//        t.setNumber(1);
//        t.setBeginInDate(new Date());
//        ValidateProcess.process(t);
    }
}
