package com.restaurante.plataform.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.restaurante.plataform.api.model.OrderingModel;
import com.restaurante.plataform.domain.model.Ordering;

@Component
public class OrderingModelAssembler {
	
	private ModelMapper modelMapper;
	
	public OrderingModel toModel(Ordering order) {
		return modelMapper.map(order, OrderingModel.class);
	}
	
	
	public List<OrderingModel> toCollectionModel(List<Ordering> orderins){
		return orderins.stream()
				.map(order -> toModel(order))
				.collect(Collectors.toList());
	}
}
