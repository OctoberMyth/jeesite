package com.thinkgem.jeesite.common.utils.validate.fimpl;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.thinkgem.jeesite.common.utils.validate.IFormatValidator;
import com.thinkgem.jeesite.common.utils.validate.util.RegexValidate;

/**
 * 数字格式校验 正整数
 * @author 李朝民
 *
 */
@Component
public class Number implements IFormatValidator{
	
	/**
	 * 正整数
	 */
	@Override
	public boolean test(Object value,Object ... params) {
		return RegexValidate.test(value, "[1-9]\\d*");
	}

}
