package com.thinkgem.jeesite.common.utils.validate.fimpl;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.thinkgem.jeesite.common.utils.validate.IFormatValidator;
import com.thinkgem.jeesite.common.utils.validate.util.RegexValidate;

/**
 * 座机格式校验
 * @author 李朝民
 *
 */
@Component
public class Phone implements IFormatValidator{

	/**
	 * 国内电话号码
	 */
	@Override
	public boolean test(Object value,Object ... params) {
		return RegexValidate.test(value, "[0-9-()（）]{7,18}");
	}

}
