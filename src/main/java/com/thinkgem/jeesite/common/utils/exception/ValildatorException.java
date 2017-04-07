package com.thinkgem.jeesite.common.utils.exception;

public class ValildatorException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ValildatorException(){
		super();
	}
	
	public ValildatorException(String message){
		super(message);
	}

	public ValildatorException(Throwable throwable){
		super(throwable);
	}
	
	public ValildatorException(String message,Throwable throwable){
		super(message,throwable);
	}

}
