package com.restaurante.plataform.api.model.input;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TablesInput {
	
	@NotBlank
	@PositiveOrZero
	private Integer number;
}
