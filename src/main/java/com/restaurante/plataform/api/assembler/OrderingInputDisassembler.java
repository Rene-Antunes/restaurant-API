package com.restaurante.plataform.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.restaurante.plataform.api.model.input.OrderingInput;
import com.restaurante.plataform.domain.model.Ordering;

@Component
public class OrderingInputDisassembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public Ordering toDomainObject(OrderingInput orderingInput) {
		return modelMapper.map(orderingInput, Ordering.class);
	}
	
	public void copyToDomainObject(OrderingInput orderingInput, Ordering ordering) {
		modelMapper.map(orderingInput, ordering);
	}
	
}
