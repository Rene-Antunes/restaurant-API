package com.restaurante.plataform.api.model.input;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TablesInput {
	
	@NotNull
	@PositiveOrZero
	private Integer number;
}
