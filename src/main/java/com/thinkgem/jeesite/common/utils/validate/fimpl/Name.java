package com.thinkgem.jeesite.common.utils.validate.fimpl;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.thinkgem.jeesite.common.utils.validate.IFormatValidator;
import com.thinkgem.jeesite.common.utils.validate.util.RegexValidate;

/**
 * 用户名格式校验
 * @author 李朝民
 *
 */
@Component
public class Name implements IFormatValidator{

	/**
	 * 由字母数字下划线组成且开头必须是字母，不能超过16位
	 */
	@Override
	public boolean test(Object value,Object ... params) {
		return RegexValidate.test(value, "^([a-zA-Z]{1}[a-zA-Z0-9_]{1,15})$");
	}

}
