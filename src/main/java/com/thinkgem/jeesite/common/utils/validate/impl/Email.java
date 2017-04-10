package com.thinkgem.jeesite.common.utils.validate.impl;

import org.springframework.stereotype.Component;

import com.thinkgem.jeesite.common.utils.validate.IValidator;
import com.thinkgem.jeesite.common.utils.validate.util.RegexValidate;

/**
 * 邮箱格式校验
 * @author 李朝民
 *
 */
@Component
public class Email implements IValidator{

	@Override
	public boolean test(Object value) {
		return RegexValidate.test(value, "\\w[-\\w.+]*@([A-Za-z0-9][-A-Za-z0-9]+\\.)+[A-Za-z]{2,14}");
	}

}
