package com.restaurante.plataform.api.assembler;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.restaurante.plataform.api.model.PermitModel;
import com.restaurante.plataform.domain.model.Permit;

@Component
public class PermitModelAssembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public PermitModel toModel(Permit permition) {
		return modelMapper.map(permition, PermitModel.class);
	}
	
	public List<PermitModel> toCollectionModel(Collection<Permit> permitions){
		return permitions.stream()
				.map(permition -> toModel(permition))
				.collect(Collectors.toList());
	}
}
