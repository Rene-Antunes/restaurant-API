package com.restaurante.plataform.api.model.input;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PermitInput {
	
	@NotNull
	private Long id;
}
