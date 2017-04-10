package com.thinkgem.jeesite.common.utils.validate.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Validate {
	
	/**
	 * 必填：true；可空：false
	 * @return
	 */
	boolean required() default false;
	
	/**
	 * 必填信息
	 * @return
	 */
	String[] must() default "必填信息";
	
	/**
	 * format格式化，支持自定义方法；正则表达式
	 * @return
	 */
	String method() default "";
	
	/**
	 * regex如何检验不是很复杂则可以自定义正则校验
	 * @return
	 */
	String regex() default "";
	
	/**
	 * 格式化校验信息
	 * @return
	 */
	String format() default "请填写正确格式";
	
	/**
	 * 数据校验
	 * @return
	 */
	String remote() default "";
	
	/**
	 * 数据校验信息
	 * @return
	 */
	String back() default "后台校验不通过";
}
