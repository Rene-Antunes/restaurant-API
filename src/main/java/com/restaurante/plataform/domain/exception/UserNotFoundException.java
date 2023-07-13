package com.restaurante.plataform.domain.exception;

public class UserNotFoundException extends EntityNotFoundException{

	private static final long serialVersionUID = 1L;
	
	
	public UserNotFoundException(String message) {
		super(message);
	}
	
	public UserNotFoundException(Long userId) {
		this(String.format("Não existe um cadastro de usuário com código %d", userId));
	}
}
