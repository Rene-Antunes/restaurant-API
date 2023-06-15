package com.restaurante.plataform.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.restaurante.plataform.api.model.UserModel;
import com.restaurante.plataform.domain.model.User;

@Component
public class UserModelAssembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	public UserModel toModel(User user) {
		return modelMapper.map(user, UserModel.class);
	}
	
	public List<UserModel> toCollectionModel(List<User> users){
		return users.stream()
				.map(user -> toModel(user))
				.collect(Collectors.toList());
	}
	
}
