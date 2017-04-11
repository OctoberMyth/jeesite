package com.thinkgem.jeesite.common.utils.validate.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.common.utils.SpringContextHolder;
import com.thinkgem.jeesite.common.utils.validate.constants.RemoteType;
import com.thinkgem.jeesite.test.entity.TestData;

/**
 * 与持久化数据进行对比
 * @author 李朝民
 *
 */
public class RemoteValidate {
	
	/**
	 * 与数据库数据对比
	 * @param value 需要校验的
	 * @param t    需要校验的对象
	 * @param type 校验类型
	 * @param uri 校验类型
	 * @return
	 */
	public static <T> boolean test(Object value,T t,String type,String[] uri) {
		String[] arr = uri[0].split("\\.");
		Class<?> cls = t.getClass();
		CrudService crud = (CrudService)SpringContextHolder.getBean(arr[0]);
		Method method;
		
		try {
			method = crud.getClass().getMethod(arr[1],cls);
			try {
				List<T> data = (List<T>) method.invoke(crud, t);
				if(RemoteType.REPEATCHECK.equals(type)){//不能重复
					if(data != null && data.size() > 0){
						return false;
					}else{
						return true;
					}
				}else if(RemoteType.ISEXIST.equals(type)){//数据库要有对应值
					if(data != null && data.size() > 0){
						return true;
					}else{
						return false;
					}
				}
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
