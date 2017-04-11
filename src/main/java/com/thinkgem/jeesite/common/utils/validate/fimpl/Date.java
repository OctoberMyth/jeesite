package com.thinkgem.jeesite.common.utils.validate.fimpl;

import java.text.SimpleDateFormat;

import org.springframework.stereotype.Component;

import com.thinkgem.jeesite.common.utils.validate.IFormatValidator;
import com.thinkgem.jeesite.common.utils.validate.util.RegexValidate;

/**
 * 校验日期
 * @author 李朝民
 *
 */
@Component
public class Date implements IFormatValidator{

	@SuppressWarnings("unused")
	@Override
	public boolean test(Object value,Object ... params) {
		String d = value.toString();
		java.util.Date date = (java.util.Date) value;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String time = formatter.format(date);
		return RegexValidate.test(time, "\\d{4}(\\-|\\/|.)\\d{1,2}\\1\\d{1,2}");
	}

}
