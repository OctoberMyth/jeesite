package com.thinkgem.jeesite.common.utils.validate.impl;

import org.springframework.stereotype.Component;

import com.thinkgem.jeesite.common.utils.validate.IValidator;

@Component
public class Amount implements IValidator{

	private String regex = "";

	@Override
	public void test() {
		System.out.println("this amount class!");
	}
	

}
