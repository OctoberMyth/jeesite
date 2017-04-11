package com.thinkgem.jeesite.common.utils.util;

/**
 * 提取信息
 * @author 李朝民
 *
 */
public class Extract {

	/**
	 * 获得分离出来的参数
	 * @param s
	 * @return
	 */
	public static String[] separationParams(String[] s){
		
		int mlen = s.length-1;
		String[] params = new String[mlen];
		for(int i = mlen;i >= 1;i --){
			params[i-1] = s[i];
		}
		return params;
	}
}
