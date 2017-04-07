package com.thinkgem.jeesite.common.utils.excel.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;

import com.thinkgem.jeesite.common.utils.exception.ParamterException;

public class ValidateProcesser {
	
	//处理器解析需要校验的字段
	public static <T> void processer(T t, int... groups){
		Class<?> cls = t.getClass();
		//get annotation fields
		Field[] fs = cls.getDeclaredFields();
		for(Field f:fs){
			f.setAccessible(true);
			Validate vf = f.getAnnotation(Validate.class);
			if(vf != null){
				//validate(vf);
			}
		}
		//get annotation methods
		Method[] ms = cls.getDeclaredMethods();
		for (Method m : ms){
			m.setAccessible(true);
			Validate vf = m.getAnnotation(Validate.class);
			if (vf != null){
				Type returnType = m.getGenericReturnType();
				Class[] parameterTypes = m.getParameterTypes();
				try {
					Method method = cls.getMethod(m.getName());
					try {
						Object value = method.invoke(t);
						validate(vf,value,returnType);
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
		}
	}
	
	//依次进行校验
	private static void validate(Validate vf,Object value,Type returnType){
		//1.非空校验
		if(vf.required() && StringUtils.isBlank(returnType.toString())){
			throw new ParamterException(vf.must()!=null?vf.must():Message.MUST);
		}

		//2.格式化校验
		if(StringUtils.isNotBlank(vf.method())){
			//1.调用全局校验方法method
			System.out.println(FormatType.METHOD);
			//2.调用自定义校验方法

			//3.使用正则表达式校验regex

		}

		//3.与数据库对比
		if(StringUtils.isNotBlank(vf.remote())){
			System.out.println("remote");
		}
	}
	
	//类型转换后非空校验
	private static boolean required(Object value,String returnType){
		if(ReturnType.RETURN_TYPE_BIGDECIMAL.equals(returnType)){
			BigDecimal v = new BigDecimal(value.toString());
			return false;
		}else if(ReturnType.RETURN_TYPE_DATE.equals(returnType)){
			
		}
		return true;
	}

	//类型转换后格式校验
	private static boolean format(Object value,Type returnType){
		return true;
	}
	
	//类型转换后数据校验
	private static boolean remote(Object value,Type returnType){
		return true;
	}
	
	//类型转换
	private static boolean TypeConversion(Object value,Type returnType){
		return true;
	}
}
