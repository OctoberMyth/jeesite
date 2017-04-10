package com.thinkgem.jeesite.common.utils.validate.impl;

import org.springframework.stereotype.Component;

import com.thinkgem.jeesite.common.utils.validate.IValidator;

/**
 * 用户名格式校验
 * @author 李朝民
 *
 */
@Component
public class Name implements IValidator{

	/**
	 * 由字母数字下划线组成且开头必须是字母，不能超过16位
	 */
	private String regex = "^([a-zA-Z]{1}[a-zA-Z0-9_]{1,15})$";
	
	@Override
	public boolean test(Object value) {
		return false;
	}

}
