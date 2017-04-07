package com.thinkgem.jeesite.test;

import com.thinkgem.jeesite.common.utils.excel.annotation.ValidateProcess;

import java.math.BigDecimal;
import java.util.Date;

public class Test {

    public static void main(String[] args) {
        TestData t = new TestData();
        t.setAmount(new BigDecimal(10.00));
        t.setSex("nan");
        t.setNumber(1);
        t.setBeginInDate(new Date());
        ValidateProcess.process(t);
    }
}
