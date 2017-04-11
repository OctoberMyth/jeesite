package com.thinkgem.jeesite.common.utils.exception;

/**
 * 系统异常封装：自定义功能性组件的异常处理类
 * @author 李朝民
 *
 */
public class SystemException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SystemException(){
		super();
	}
	
	public SystemException(String message){
		super(message);
	}

	public SystemException(Throwable throwable){
		super(throwable);
	}
	
	public SystemException(String message,Throwable throwable){
		super(message,throwable);
	}

}
