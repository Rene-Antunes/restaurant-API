package com.restaurante.plataform.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.restaurante.plataform.api.assembler.GroupTypeModelAssembler;
import com.restaurante.plataform.api.model.GroupTypeModel;
import com.restaurante.plataform.domain.model.User;
import com.restaurante.plataform.domain.service.RegisterUserService;

@RestController
@RequestMapping(value = "/users/{userId}/groups")
public class UserGroupController {
	
	@Autowired
	private RegisterUserService registerUserService;
	
	@Autowired
	private GroupTypeModelAssembler groupTypeModelAssembler;
	
	
	@GetMapping
	public List<GroupTypeModel> list(@PathVariable Long userId){
		User user = registerUserService.findOrFail(userId);
		return groupTypeModelAssembler.toCollectionModel(user.getCategory());
	}
	
	@DeleteMapping("/{groupId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void disassossiate(@PathVariable Long userId, @PathVariable Long groupId){
		registerUserService.disassociateGroup(userId, groupId);
	}
	
	

	@PutMapping("/{groupId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void assossiate(@PathVariable Long userId, @PathVariable Long groupId){
		registerUserService.addGroup(userId, groupId);
	}
}
