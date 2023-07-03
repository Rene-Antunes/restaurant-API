package com.restaurante.plataform.core.modelMapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.restaurante.plataform.api.model.input.OrderingItemInput;
import com.restaurante.plataform.domain.model.OrderingItem;

@Configuration
public class ModelMapperConfig {
	
	@Bean
	public ModelMapper modelMapper() {
		
		var modelMapper = new ModelMapper();
		
		modelMapper.createTypeMap(OrderingItemInput.class, OrderingItem.class)
			.addMappings(mapper -> mapper.skip(OrderingItem::setId));
		
		return modelMapper;
	}
	
	
}
