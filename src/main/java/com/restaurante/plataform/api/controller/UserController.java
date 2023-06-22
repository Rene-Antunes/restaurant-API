package com.restaurante.plataform.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.restaurante.plataform.api.assembler.UserInputDisassembler;
import com.restaurante.plataform.api.assembler.UserModelAssembler;
import com.restaurante.plataform.api.model.UserModel;
import com.restaurante.plataform.api.model.input.PasswordInput;
import com.restaurante.plataform.api.model.input.UserInput;
import com.restaurante.plataform.api.model.input.UserPasswordInput;
import com.restaurante.plataform.domain.model.User;
import com.restaurante.plataform.domain.repository.UserRepository;
import com.restaurante.plataform.domain.service.RegisterUserService;

@RestController
@RequestMapping(value = "users")
public class UserController {
	
	@Autowired
	private RegisterUserService registerUserService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserModelAssembler userModelAssembler;
	
	@Autowired
	private UserInputDisassembler userInputDisassembler;
	
	@GetMapping
	public List<UserModel> listar(){
		List<User> AllUsers = userRepository.findAll();
		return userModelAssembler.toCollectionModel(AllUsers);
	}
	
	@GetMapping("/{userId}")
	public UserModel find(@PathVariable Long userId) {
		User user = registerUserService.findOrFail(userId);
		return userModelAssembler.toModel(user);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public UserModel add(@RequestBody @Valid UserPasswordInput userInput) {
		User user = userInputDisassembler.toDmainObject(userInput);
		user = registerUserService.save(user);
		return userModelAssembler.toModel(user);
	}
	

	@PutMapping("/{userId}")
	public UserModel toUpdate(@PathVariable Long userId, 
			@RequestBody @Valid UserInput userInput) {
		User CurrentUser = registerUserService.findOrFail(userId);
		userInputDisassembler.copyToDomainObject(userInput, CurrentUser);
		CurrentUser = registerUserService.save(CurrentUser);

		return userModelAssembler.toModel(CurrentUser);
	}
	
	@PutMapping("{userId}/password")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void changePassword(@PathVariable Long userId,
			@RequestBody @Valid PasswordInput passwordinput) {
		
		registerUserService.changePassword(userId, passwordinput.getCurrentPassword()
				, passwordinput.getNewPassword());
	}
	
}
