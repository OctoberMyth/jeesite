package com.thinkgem.jeesite.common.utils.validate;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.thinkgem.jeesite.common.utils.exception.ValildatorException;

/**
 * Created by 86443
 * on 2017/4/7.
 */
public class ValidatorFactory {
	
	private static WebApplicationContext webApplicationContext;
	
	/**
	 * 初始化
	 */
	static{
		webApplicationContext = ContextLoader.getCurrentWebApplicationContext();    
	}
	
	/**
	 * 禁止创建
	 */
    private ValidatorFactory() {}
    
    /**
     * 执行具体的校验方法
     * @param beanName
     */
    public static boolean execute(String beanName,Object value,String... regex ) {
    	try{
    		IValidator validator = (IValidator)webApplicationContext.getBean(beanName);
            return validator.test(value);
    	}catch(NoSuchBeanDefinitionException e){
    		throw new ValildatorException("没有实现对应的校验类:"+toUpperCaseFirstOne(beanName));
    	}
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
