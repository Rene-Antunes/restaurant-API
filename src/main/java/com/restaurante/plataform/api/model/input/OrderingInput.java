package com.restaurante.plataform.api.model.input;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderingInput {
	
	@NotNull
	private PayTypeIdInput payType;
	
	@Valid
	@NotNull
	private TablesIdInput tables;
	
	private BigDecimal serverTax;
	
	@NotNull
	@Size(min = 1)
	@Valid
	private List<OrderingItemInput> itens = new ArrayList<>();
}
