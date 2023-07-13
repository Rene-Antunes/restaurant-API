package com.restaurante.plataform.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.restaurante.plataform.api.model.input.PermitInput;
import com.restaurante.plataform.domain.model.Permit;

@Component
public class PermitModelDisassembler {
	
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	public Permit toDomainObject(PermitInput permitInput) {
		return modelMapper.map(permitInput, Permit.class);
	}
	
}
