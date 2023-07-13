package com.restaurante.plataform.domain.exception;

public class GroupTypeNotFoundException extends EntityNotFoundException{

	private static final long serialVersionUID = 1L;
	
	
	public GroupTypeNotFoundException(String message) {
		super(message);
	}
	
	public GroupTypeNotFoundException(Long groupId) {
		this(String.format("Não existe um cadastro de Grupo com código %d", groupId));
	}
}
