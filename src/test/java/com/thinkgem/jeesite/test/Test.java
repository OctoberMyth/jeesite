package com.thinkgem.jeesite.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
		String str = "testDataService.findList";
		String[] arr = str.split("\\.");
		System.out.println(str.split(""));
//        TestData t = new TestData();
//        t.setAmount(new BigDecimal(10.00));
//        t.setSex("nan");
//        t.setNumber(1);
//        t.setBeginInDate(new Date());
//        ValidateProcess.process(t);
    }
}
