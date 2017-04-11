package com.thinkgem.jeesite.common.utils.validate.fimpl;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.thinkgem.jeesite.common.utils.validate.IFormatValidator;
import com.thinkgem.jeesite.common.utils.validate.util.RegexValidate;

/**
 * 邮箱格式校验
 * @author 李朝民
 *
 */
@Component
public class Email implements IFormatValidator{

	@Override
	public boolean test(Object value,Object ... params) {
		return RegexValidate.test(value, "\\w[-\\w.+]*@([A-Za-z0-9][-A-Za-z0-9]+\\.)+[A-Za-z]{2,14}");
	}

}
