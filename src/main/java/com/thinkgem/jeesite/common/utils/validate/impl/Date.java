package com.thinkgem.jeesite.common.utils.validate.impl;

import org.springframework.stereotype.Component;

import com.thinkgem.jeesite.common.utils.validate.IValidator;

/**
 * 数字格式校验 正整数
 * @author 李朝民
 *
 */
@Component
public class Date implements IValidator{
	//    "\\d{4}(\\-|\\/|.)\\d{1,2}\\1\\d{1,2}";

	@Override
	public boolean test(Object value) {
		// TODO Auto-generated method stub
		return false;
	}

}
