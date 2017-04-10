package com.thinkgem.jeesite.common.utils.validate.util;

/**
 * 非空校验
 * @author 李朝民
 *
 */
public class NotNullValidate {

	/**
	 * 判断为空
	 * @param obj
	 * @return
	 */
	public static boolean isNull(final Object obj) {
		
        return !isNotNull(obj);
    }
	
	/**
	 * 判断不为空
	 * @param obj
	 * @return
	 */
	public static boolean isNotNull(final Object obj) {
		
		if(obj != null && !"".equals(obj.toString())){
			return true;
		}

        return false;
    }
}
