package com.thinkgem.jeesite.common.utils.validate;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.apache.commons.lang3.StringUtils;

import com.thinkgem.jeesite.common.utils.exception.ParamterException;
import com.thinkgem.jeesite.common.utils.exception.SystemException;
import com.thinkgem.jeesite.common.utils.global.GlobalMessage;
import com.thinkgem.jeesite.common.utils.util.Extract;
import com.thinkgem.jeesite.common.utils.validate.annotation.Validate;
import com.thinkgem.jeesite.common.utils.validate.util.NotNullValidate;
import com.thinkgem.jeesite.common.utils.validate.util.RegexValidate;
import com.thinkgem.jeesite.common.utils.validate.util.RemoteValidate;

public class ValidateProcess<T> {
    
	/**
	 * 数据对象
	 */
    private T entity ;
    
    public ValidateProcess(T entity){
    	this.entity = entity;
    	
    	process(entity);
    }

	//处理器
    public void process(T entity, int... groups) {
    	Class<?> cls = entity.getClass();
        //get annotation fields
        getAnnotationFields(cls);
        //get annotation methods
        getAnnotationMethods(cls);
    }

    //check methods
    private void getAnnotationMethods(Class<?> cls) {
        Method[] ms = cls.getDeclaredMethods();
        for (Method method : ms) {
            method.setAccessible(true);
            Validate vf = method.getAnnotation(Validate.class);
            if (vf != null) {
                try {
                    Object value = method.invoke(entity);
                    Class<?> returnType = method.getReturnType();
                    validate(vf, value, returnType);
                } catch (Exception e) {
                	throw new SystemException(e);
                }
            }
        }
    }

    //check the fields
    private void getAnnotationFields(Class<?> cls) {
        Field[] fields = cls.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            Validate vf = field.getAnnotation(Validate.class);
            if (vf != null) {
                try {
                    Object v = field.get(entity);
                    Class<?> returnType = field.getType();
                    validate(vf, v, returnType);
                } catch (IllegalAccessException e) {
                	throw new SystemException(e);
                }

            }
        }
    }

    //依次进行校验
    private void validate(Validate vf, Object value, Class<?> returnType) {
        //1.非空校验
        if (vf.required()) {
        	notNullValidate(vf,value);
        }

        //2.格式化校验
        if (vf.method() != null && vf.method().length > 0) {
        	methodValidate(vf,value);
        }else if(StringUtils.isNotBlank(vf.regex())){
        	regexValidate(vf,value);
        }
        
        //3.与数据库对比
        if (vf.remote() != null && vf.remote().length > 0) {
        	remoteValidate(vf,value);
        }
    }
    
    //非空校验
    private void notNullValidate(Validate vf, Object value){
    	if(NotNullValidate.isNull(value)){
    		throw new ParamterException(GlobalMessage.message(vf.must()));
    	}
    }
    
    //使用正则校验
    private void regexValidate(Validate vf, Object value){
    	
		if(!RegexValidate.test(value,vf.regex())){
			throw new ParamterException(GlobalMessage.message(vf.format()));
		}else{
			throw new SystemException("校验参数不能为空！");
		}
    }
    
    //使用自定义方法校验
    private void methodValidate(Validate vf, Object value){
    	String[] info = vf.method();
    	String beanName = info[0];
    	
		if(info.length > 1 && !FormatValidatorFactory.test(beanName,value,entity,Extract.separationParams(info))){
			throw new ParamterException(GlobalMessage.message(vf.format()));
		}else if(info.length == 1 && !FormatValidatorFactory.test(beanName,value)){
			throw new ParamterException(GlobalMessage.message(vf.format()));
		}
    }
    
    //与数据库对比
    private void remoteValidate(Validate vf, Object value){
    	String[] info = vf.remote();
    	String type = info[0];//校验类型repeatCheck,isExist
    	if(!RemoteValidate.test(value,entity,type,Extract.separationParams(info))){
			throw new ParamterException(GlobalMessage.message(vf.back()));
		}
    }

}
