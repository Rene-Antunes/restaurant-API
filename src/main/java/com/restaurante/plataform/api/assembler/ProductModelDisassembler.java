package com.restaurante.plataform.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.restaurante.plataform.api.model.input.ProductInput;
import com.restaurante.plataform.domain.model.Product;

@Component
public class ProductModelDisassembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public Product toDomainObject(ProductInput productInput) {
		return 	modelMapper.map(productInput, Product.class);
	}
		
	public void copyToDomainObject(ProductInput productInput, Product product) {
		modelMapper.map(productInput, product);
	}
}
