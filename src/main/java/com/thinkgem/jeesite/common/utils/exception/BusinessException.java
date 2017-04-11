package com.thinkgem.jeesite.common.utils.exception;

public class BusinessException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BusinessException(){
		super();
	}
	
	public BusinessException(String message){
		super(message);
	}

	public BusinessException(Throwable throwable){
		super(throwable);
	}
	
	public BusinessException(String message,Throwable throwable){
		super(message,throwable);
	}

}
