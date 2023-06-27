package com.restaurante.plataform.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.restaurante.plataform.api.model.input.GroupTypeInput;
import com.restaurante.plataform.domain.model.GroupType;

@Component
public class GroupTypeInputDisassembler {
	@Autowired
	private ModelMapper modelMapper;

	public GroupType toDomainModel(GroupTypeInput groupTypeInput) {
		return modelMapper.map(groupTypeInput, GroupType.class);
	}
	
	public void copyToDomainObject(GroupTypeInput groupTypeInput, GroupType groupType ) {
		modelMapper.map(groupTypeInput, groupType);
	}
}
