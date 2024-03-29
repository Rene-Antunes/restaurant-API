package com.restaurante.plataform.api.model.input;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PermitInput {
	
	
	@NotBlank
	private String name;
	@NotBlank
	private String description;
}
