package com.thinkgem.jeesite.common.utils.validate.impl;

import org.springframework.stereotype.Component;

import com.thinkgem.jeesite.common.utils.validate.IValidator;
import com.thinkgem.jeesite.common.utils.validate.util.RegexValidate;

/**
 * 手机格式校验
 * @author 李朝民
 *
 */
@Component
public class Mobile implements IValidator{

	/**
	 * 手机格式校验
	 */
	@Override
	public boolean test(Object value) {
		return RegexValidate.test(value, "0?(13|14|15|18)[0-9]{9}");
	}

}
