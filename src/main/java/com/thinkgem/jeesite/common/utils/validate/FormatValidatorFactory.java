package com.thinkgem.jeesite.common.utils.validate;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.thinkgem.jeesite.common.utils.SpringContextHolder;
import com.thinkgem.jeesite.common.utils.exception.SystemException;

/**
 * Created by 86443
 * on 2017/4/7.
 */
public class FormatValidatorFactory {
	
	/**
	 * 禁止创建
	 */
    private FormatValidatorFactory() {}
    
    /**
     * 执行级联校验的方法
     * @param beanName
     * @param value
     * @param entity
     * @param params
     * @return
     */
    public static boolean test(String beanName,Object value,Object entity,String[] params) {
    	Map<String,Object> pmap = packageParams(entity,params);
    	try{
    		IFormatValidator validator = (IFormatValidator)SpringContextHolder.getBean(beanName);
            return validator.test(value,pmap);
    	}catch(NoSuchBeanDefinitionException e){
    		throw new SystemException("没有实现对应的校验类:"+toUpperCaseFirstOne(beanName));
    	}
    }
    
    /**
     * 执行具体的校验方法
     * @param beanName
     * @param value
     * @return
     */
    public static boolean test(String beanName,Object value) {
    	
    	try{
    		IFormatValidator validator = (IFormatValidator)SpringContextHolder.getBean(beanName);
            return validator.test(value);
    	}catch(NoSuchBeanDefinitionException e){
    		throw new SystemException("没有实现对应的校验类:"+toUpperCaseFirstOne(beanName));
    	}
    }
    
    /**
     * 封装参数
     * @param entity
     * @param params
     * @return
     */
    private static Map<String,Object> packageParams(Object entity,String[] params){
    	Map<String,Object> pmap = new HashMap<String,Object>();
    	Class<?> cls = entity.getClass();
    	for(String param : params){
    		Method method;
			try {
				method = cls.getMethod("get"+toUpperCaseFirstOne(param));
				Object value;
				try {
					value = method.invoke(entity);
		    		pmap.put(param, value);
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
    	}
    	return pmap;
    }

    /**
     * 首字母转大写
     * @param s
     * @return
     */
    private static String toUpperCaseFirstOne(String s) {
        if (Character.isUpperCase(s.charAt(0))) {
            return s;
        } else {
            return (new StringBuilder()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
        }
    }

}
