package com.thinkgem.jeesite.common.utils.validate;

public interface IValidator {
	
	/**
	 * 全局校验方法、自定义校验方法需要实现的
	 */
	boolean test(Object value);

}
