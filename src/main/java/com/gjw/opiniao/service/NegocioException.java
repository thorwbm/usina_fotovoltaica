package com.gjw.opiniao.service;

public class NegocioException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public NegocioException(String msg){
		super(msg);
	}
	public NegocioException(String msg, Exception e){
		super(msg + " - " + e.getMessage());
	}
	
}
