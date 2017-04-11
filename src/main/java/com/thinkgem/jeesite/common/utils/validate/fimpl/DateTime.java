package com.thinkgem.jeesite.common.utils.validate.fimpl;

import java.text.SimpleDateFormat;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.thinkgem.jeesite.common.utils.validate.IFormatValidator;
import com.thinkgem.jeesite.common.utils.validate.util.RegexValidate;

/**
 * 校验时间
 * @author 李朝民
 *
 */
@Component
public class DateTime implements IFormatValidator{

	@Override
	public boolean test(Object value,Object ... params) {
		return RegexValidate.test(value, "\\d{4}(\\-|\\/|.)\\d{1,2}\\1\\d{1,2}");
	}

}
