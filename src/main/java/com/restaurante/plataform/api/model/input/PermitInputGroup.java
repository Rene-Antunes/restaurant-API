package com.restaurante.plataform.api.model.input;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PermitInputGroup {
	
	@NotNull
	private Long id;
}
