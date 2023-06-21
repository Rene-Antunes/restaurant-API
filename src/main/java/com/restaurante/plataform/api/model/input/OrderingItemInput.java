package com.restaurante.plataform.api.model.input;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderingItemInput {
	
	@NotNull
	private Long produtoId;
	@NotNull
	@PositiveOrZero
	private Integer quantity;
	
	private String observation;
}
