package com.thinkgem.jeesite.common.utils.global;

import java.text.MessageFormat;

/**
 * 国际化转化
 * @author 李朝民
 *
 */
public class GlobalMessage {

	public static String message(String[] message){
		if(message != null && message.length > 1){
			return extractRearrangeArguments(message);
		}else{
			
		}
		return message[0];
	}
	
	/**
	 * 
	 * @return
	 */
	private static String extractRearrangeArguments(String[] message){
		String format = message[0];
		int mlen = message.length-1;
		String[] params = new String[mlen];
		for(int i = mlen;i >= 1;i --){
			params[i-1] = message[i];
		}
		
	    return MessageFormat.format(format, params);
	}
}
