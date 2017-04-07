package com.thinkgem.jeesite.common.utils.excel.annotation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ValidateInvocationHandler implements InvocationHandler{

	private Object target;
	
	public ValidateInvocationHandler(Object target) {
		super();
		this.target = target;
	}
	
	public Object getProxy(){
		return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
				target.getClass().getClasses(), this); 
	}

	@Override
	public Object invoke(Object arg0, Method arg1, Object[] arg2) throws Throwable {
		// TODO Auto-generated method stub
		return null;
	}

}
