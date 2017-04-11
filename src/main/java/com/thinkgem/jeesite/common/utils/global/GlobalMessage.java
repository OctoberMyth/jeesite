package com.thinkgem.jeesite.common.utils.global;

import java.text.MessageFormat;

import org.apache.commons.lang3.StringUtils;

import com.thinkgem.jeesite.common.utils.exception.SystemException;
import com.thinkgem.jeesite.common.utils.util.Extract;

/**
 * 国际化转化
 * @author 李朝民
 *
 */
public class GlobalMessage {

	/**
	 * 获得消息
	 * @param message
	 * @return
	 */
	public static String message(String[] message){
		if(message != null && message.length > 1){
			return extractRearrangeArguments(message);
		}else if(message != null && message.length == 1){
			return message[0];
		}else{
			throw new SystemException("校验信息不能为空！");
		}
	}
	
	/**
	 * 获得消息
	 * @param message
	 * @return
	 */
	public static String message(String message){
		if(StringUtils.isNotBlank(message)){
			return message;
		}else{
			throw new SystemException("校验信息不能为空！");
		}
	}
	
	/**
	 * 方法与参数分离
	 * @return
	 */
	private static String extractRearrangeArguments(String[] message){
		String format = message[0];
		int mlen = message.length-1;
		String[] params = Extract.separationParams(message);
		
	    return MessageFormat.format(format, params);
	}
}
