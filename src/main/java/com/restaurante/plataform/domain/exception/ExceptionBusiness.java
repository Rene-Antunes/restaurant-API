package com.restaurante.plataform.domain.exception;

public class ExceptionBusiness extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	
	public ExceptionBusiness(String message) {
		super(message);
	}
	
	public ExceptionBusiness(String message, Throwable couse) {
		super(message, couse);
	}
}
