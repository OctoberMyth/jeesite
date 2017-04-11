package com.thinkgem.jeesite.common.utils.validate.fimpl;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.thinkgem.jeesite.common.utils.validate.IFormatValidator;
import com.thinkgem.jeesite.common.utils.validate.util.RegexValidate;

@Component
public class Amount implements IFormatValidator{

	/**
	 * 金额校验
	 */
	@Override
	public boolean test(Object value,Object ... params) {
//		Map<String,Object> pmap = (Map<String, Object>) params[0];
//		String number = pmap.get("number").toString();
		return RegexValidate.test(value, "^(([1-9]{1}\\d*)|([0]{1}))(\\.(\\d){0,2})?$");
	}
	
}
