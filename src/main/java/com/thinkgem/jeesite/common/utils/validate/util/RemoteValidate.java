package com.thinkgem.jeesite.common.utils.validate.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.thinkgem.jeesite.common.utils.SpringContextHolder;

/**
 * 与持久化数据进行对比
 * @author 李朝民
 *
 */
public class RemoteValidate {
	
	//private static Dao dao;
	
	public static <T,E> boolean test(Object value,T t,E s,String methods) {
		Class<?> cls = t.getClass();
		Class<?> service = s.getClass();
		Method method;
		try {
			method = service.getMethod(methods,cls);
			try {
				method.invoke(s, cls);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		
		return true;
	}

}
