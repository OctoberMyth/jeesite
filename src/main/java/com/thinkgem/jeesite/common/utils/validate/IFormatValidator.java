package com.thinkgem.jeesite.common.utils.validate;

public interface IFormatValidator {
	
	/**
	 * 全局校验方法、自定义校验方法需要实现的
	 * @param value 当前需要校验的值
	 * @param params 需要级联校验的参数，封装到了一个map当中  
	 * @return
	 */
	boolean test(Object value,Object ... params);

}
