package com.thinkgem.jeesite.common.utils.validate;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.apache.commons.lang3.StringUtils;

import com.thinkgem.jeesite.common.utils.exception.ParamterException;
import com.thinkgem.jeesite.common.utils.validate.annotation.Validate;
import com.thinkgem.jeesite.common.utils.validate.impl.SimpleValidator;

public class ValidateProcess {

    //处理器
    public static <T> void process(T t, int... groups) {
        Class<?> cls = t.getClass();
        //get annotation fields
        getAnnotationFields(t, cls);
        //get annotation methods
        getAnnotationMethods(t, cls);
    }

    //check the field
    private static <T> void getAnnotationMethods(T t, Class<?> cls) {
        Method[] ms = cls.getDeclaredMethods();
        for (Method method : ms) {
            method.setAccessible(true);
            Validate vf = method.getAnnotation(Validate.class);
            if (vf != null) {
                try {
                    Object value = method.invoke(t);
                    Class<?> returnType = method.getReturnType();
                    validate(vf, value, returnType);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //check methods
    private static <T> void getAnnotationFields(T t, Class<?> cls) {
        Field[] fields = cls.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            Validate vf = field.getAnnotation(Validate.class);
            if (vf != null) {
                try {
                    Object v = field.get(t);
                    Class<?> returnType = field.getType();
                    validate(vf, v, returnType);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    //依次进行校验
    private static void validate(Validate vf, Object value, Class<?> returnType) {
        //1.非空校验
        if (vf.required() && StringUtils.isBlank(returnType.toString())) {
            throw new ParamterException(vf.must());
        }

        //2.格式化校验
        if (StringUtils.isNotBlank(vf.method()) && !ValidatorFactory.execute(vf.method(),value)) {
        	throw new ParamterException(vf.format());
        }else if(StringUtils.isNotBlank(vf.regex()) && !SimpleValidator.test(value, vf.regex())){
        	throw new ParamterException(vf.format());
        }
        
        //3.与数据库对比
        if (StringUtils.isNotBlank(vf.remote())) {
        	throw new ParamterException(vf.back());
        }
    }


    //类型转换后非空校验
    private static boolean required(Object value, String returnType) {
//        if (ReturnType.RETURN_TYPE_BIGDECIMAL.equals(returnType)) {
//            BigDecimal v = new BigDecimal(value.toString());
//            return false;
//        } else if (ReturnType.RETURN_TYPE_DATE.equals(returnType)) {
//
//        }
        return true;
    }

}