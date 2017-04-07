package com.thinkgem.jeesite.common.utils.exception;

public class ParamterException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ParamterException(){
		super();
	}
	
	public ParamterException(String message){
		super(message);
	}

	public ParamterException(Throwable throwable){
		super(throwable);
	}
	
	public ParamterException(String message,Throwable throwable){
		super(message,throwable);
	}
}
