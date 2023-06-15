package com.restaurante.plataform.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.restaurante.plataform.api.assembler.UserModelAssembler;
import com.restaurante.plataform.api.model.UserModel;
import com.restaurante.plataform.domain.model.User;
import com.restaurante.plataform.domain.repository.UserRepository;

@RestController
@RequestMapping(value = "users")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserModelAssembler userModelAssembler;
	
	@GetMapping
	public List<UserModel> listar(){
		List<User> AllUsers = userRepository.findAll();
		return userModelAssembler.toCollectionModel(AllUsers);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public User add(@RequestBody @Valid User user) {
		return userRepository.save(user);
	}
	
}
