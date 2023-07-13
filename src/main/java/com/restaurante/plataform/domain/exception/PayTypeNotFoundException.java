package com.restaurante.plataform.domain.exception;

public class PayTypeNotFoundException extends EntityNotFoundException{

	private static final long serialVersionUID = 1L;
	
	
	public PayTypeNotFoundException(String message) {
		super(message);
	}
	
	public PayTypeNotFoundException(Long payTypeId) {
		this(String.format("Não existe um cadastro tipo de pagamento com código %d", payTypeId));
	}
}
