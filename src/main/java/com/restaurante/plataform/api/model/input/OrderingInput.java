package com.restaurante.plataform.api.model.input;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.restaurante.plataform.domain.model.OrderingItem;
import com.restaurante.plataform.domain.model.PayType;
import com.restaurante.plataform.domain.model.Tables;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderingInput {
	 
//	@NotNull
	private PayTypeInput payType;
	
	@NotNull
	private TablesInput tables;
	
	@NotNull
	@Size(min = 1)
	@Valid
	private List<OrderingItem> itens = new ArrayList<>();
}
