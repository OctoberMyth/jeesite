package com.thinkgem.jeesite.common.utils.validate.fimpl;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.thinkgem.jeesite.common.utils.validate.IFormatValidator;
import com.thinkgem.jeesite.common.utils.validate.util.RegexValidate;

/**
 * 手机格式校验
 * @author 李朝民
 *
 */
@Component
public class Mobile implements IFormatValidator{

	/**
	 * 手机格式校验
	 */
	@Override
	public boolean test(Object value,Object ... params) {
		return RegexValidate.test(value, "0?(13|14|15|18)[0-9]{9}");
	}

}
