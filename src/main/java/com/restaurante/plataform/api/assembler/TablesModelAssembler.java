package com.restaurante.plataform.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.restaurante.plataform.api.model.TablesModel;
import com.restaurante.plataform.domain.model.Tables;

@Component
public class TablesModelAssembler {
	@Autowired
	private ModelMapper modelMapper;
	
	public TablesModel toModel(Tables table) {
		return modelMapper.map(table, TablesModel.class);
	}

	
	public List<TablesModel> toCollectionModel(List<Tables> tables){
		return tables.stream()
				.map(table -> toModel(table))
				.collect(Collectors.toList());
	}
}
