package com.restaurante.plataform.api.exceptionHandler;

import lombok.Getter;

@Getter
public enum ProblemType {

	MESSAGE_INCOMPREHENSIBLE(" /mensagem-incompreensível", "Mensagem incompreensível"),
	
	RESOURCE_NOT_FOUND(" /recurso-nao-encontrado", "Recurso não encontrado"),
	
	USE_ENTITY(" entidade-em-uso", "Entidade em uso"),
	
	MEDIA_NOT_SUPORTED(" media-nao-suportada", "Tipo de media não suportada"),
	
	BUSINESS_ERR(" erro-negocio", "Violação regra de negócio");
	
	
	private String title;
	private String uri;
	
	private ProblemType(String path, String title) {
		this.uri = "http://restaurant.com.br" + path;
		this.title = title;
	}
	
}
