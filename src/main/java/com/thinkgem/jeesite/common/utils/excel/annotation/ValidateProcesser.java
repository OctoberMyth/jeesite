package com.thinkgem.jeesite.common.utils.excel.annotation;

import com.thinkgem.jeesite.common.utils.exception.ParamterException;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.math.BigDecimal;

public class ValidateProcesser {

    //处理器解析需要校验的字段
    public static <T> void processer(T t, int... groups) {
        Class<?> cls = t.getClass();
        //get annotation fields
        getAnnotationFields(t, cls);
        //get annotation methods
        getAnnotationMethods(t, cls);
    }

    private static <T> void getAnnotationMethods(T t, Class<?> cls) {
        Method[] ms = cls.getDeclaredMethods();
        for (Method method : ms) {
            method.setAccessible(true);
            Validate vf = method.getAnnotation(Validate.class);
            if (vf != null) {
                try {
                    Class<?> returnType = method.getReturnType();
                    Object value = method.invoke(t);
                    validate(vf, value, returnType);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static <T> void getAnnotationFields(T t, Class<?> cls) {
        Field[] fields = cls.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            Validate vf = field.getAnnotation(Validate.class);
            if (vf != null) {
                try {
                    Class<?> returnType = field.getType();
                    Object v = field.get(t);
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
            throw new ParamterException(vf.must() != null ? vf.must() : Message.MUST);
        }

        //2.格式化校验
        if (StringUtils.isNotBlank(vf.method())) {
            //1.调用全局校验方法method
            System.out.println(FormatType.METHOD);
            //2.调用自定义校验方法

            //3.使用正则表达式校验regex

        }

        //3.与数据库对比
        if (StringUtils.isNotBlank(vf.remote())) {
            System.out.println("remote");
        }
    }

    //类型转换后非空校验
    private static boolean required(Object value, String returnType) {
        if (ReturnType.RETURN_TYPE_BIGDECIMAL.equals(returnType)) {
            BigDecimal v = new BigDecimal(value.toString());
            return false;
        } else if (ReturnType.RETURN_TYPE_DATE.equals(returnType)) {

        }
        return true;
    }

    //类型转换后格式校验
    private static boolean format(Object value, Type returnType) {
        return true;
    }

    //类型转换后数据校验
    private static boolean remote(Object value, Type returnType) {
        return true;
    }

    //类型转换
    private static boolean TypeConversion(Object value, Type returnType) {
        return true;
    }
}
