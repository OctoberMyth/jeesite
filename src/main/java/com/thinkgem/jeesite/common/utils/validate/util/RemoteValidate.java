package com.thinkgem.jeesite.common.utils.validate.util;

import java.lang.reflect.Method;

import com.thinkgem.jeesite.common.utils.SpringContextHolder;

/**
 * 与持久化数据进行对比
 * @author 李朝民
 *
 */
public class RemoteValidate {
	
	//private static Dao dao;
	
	public static <T> boolean test(Object value,Class<T> cls,String methods) {
//		Method method = cls.getMethod(methods, Class<?> value);
//		Class classDao = SpringContextHolder.getBean(cls.getName());
//		method.invoke(cls, value);
		
		return true;
	}

}
