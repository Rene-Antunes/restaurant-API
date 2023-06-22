package com.restaurante.plataform.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.restaurante.plataform.api.model.input.UserInput;
import com.restaurante.plataform.domain.model.User;

@Component
public class UserInputDisassembler {
	
	@Autowired
	private ModelMapper modelMpper;
	
	public User toDmainObject(UserInput userInput) {
			return modelMpper.map(userInput, User.class);
	}

	public void copyToDomainObject(UserInput userInput, User user) {
		modelMpper.map(userInput, user);
	}
	
}
