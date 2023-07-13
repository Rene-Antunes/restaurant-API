package com.restaurante.plataform.domain.exception;

public class ProductNotFoundException extends EntityNotFoundException{

	private static final long serialVersionUID = 1L;
	
	
	public ProductNotFoundException(String message) {
		super(message);
	}
	
	public ProductNotFoundException(Long productId) {
		this(String.format("Não existe um cadastro de produto com código %d", productId));
	}
}
