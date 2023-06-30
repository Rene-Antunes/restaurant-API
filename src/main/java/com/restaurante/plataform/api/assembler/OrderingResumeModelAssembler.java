package com.restaurante.plataform.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.restaurante.plataform.api.model.OrderingModel;
import com.restaurante.plataform.api.model.OrderingResumeModel;
import com.restaurante.plataform.domain.model.Ordering;

@Component
public class OrderingResumeModelAssembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public OrderingResumeModel toModel(Ordering order) {
		return modelMapper.map(order, OrderingResumeModel.class);
	}
	
	
	public List<OrderingResumeModel> toCollectionModel(List<Ordering> orderins){
		return orderins.stream()
				.map(order -> toModel(order))
				.collect(Collectors.toList());
	}
}
