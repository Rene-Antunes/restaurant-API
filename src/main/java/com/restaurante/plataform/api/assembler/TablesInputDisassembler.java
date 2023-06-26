package com.restaurante.plataform.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.restaurante.plataform.api.model.input.TablesInput;
import com.restaurante.plataform.api.model.input.TablesInputUpdate;
import com.restaurante.plataform.domain.model.Tables;

@Component
public class TablesInputDisassembler {
	
	@Autowired
	ModelMapper modelMapper;
	
	public Tables toDomainObject(TablesInput tablesInput) {
		return modelMapper.map(tablesInput, Tables.class);
	}
	
	public List<Tables> toDomainObjectList(List<TablesInput> tablesInputs) {
		return tablesInputs.stream()
				.map(table -> toDomainObject(table))
				.collect(Collectors.toList());
	}
	
	public void copyToDomainObject(TablesInputUpdate tablesInputUpdate, Tables tables){
		modelMapper.map(tablesInputUpdate, tables);
	}
}
