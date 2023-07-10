package com.restaurante.plataform.api.assembler;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.restaurante.plataform.api.model.GroupTypeModel;
import com.restaurante.plataform.domain.model.GroupType;

@Component
public class GroupTypeModelAssembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public GroupTypeModel toModel(GroupType groupType) {
		return modelMapper.map(groupType, GroupTypeModel.class);
	}

	
	public List<GroupTypeModel> toCollectionModel(Collection<GroupType> groups){
		return groups.stream()
				.map(groupType -> toModel(groupType))
				.collect(Collectors.toList());
	}
}
