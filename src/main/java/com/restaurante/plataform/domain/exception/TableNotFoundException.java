package com.restaurante.plataform.domain.exception;

public class TableNotFoundException extends EntityNotFoundException{

	private static final long serialVersionUID = 1L;
	
	
	public TableNotFoundException(String message) {
		super(message);
	}
	
	public TableNotFoundException(Long tableId) {
		this(String.format("Não existe um cadastro de mesa com código %d", tableId));
	}
}
