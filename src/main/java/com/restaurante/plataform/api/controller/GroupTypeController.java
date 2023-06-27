package com.restaurante.plataform.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.restaurante.plataform.api.assembler.GroupTypeInputDisassembler;
import com.restaurante.plataform.api.assembler.GroupTypeModelAssembler;
import com.restaurante.plataform.api.model.GroupTypeModel;
import com.restaurante.plataform.api.model.input.GroupTypeInput;
import com.restaurante.plataform.domain.model.GroupType;
import com.restaurante.plataform.domain.repository.GroupTypeRepository;
import com.restaurante.plataform.domain.service.RegisterGroupTypeServcice;

@RestController
@RequestMapping(value = "groups")
public class GroupTypeController {
	
	@Autowired
	private GroupTypeRepository groupTypeRepository;
	
	@Autowired
	private GroupTypeModelAssembler groupTypeModelAssembler;
	
	@Autowired
	private GroupTypeInputDisassembler groupTypeInputDisassembler;
	
	@Autowired
	private RegisterGroupTypeServcice registerGroupTypeServcice;
	
	
	@GetMapping
	public List<GroupTypeModel> list(){
		List<GroupType> groupsType = groupTypeRepository.findAll();
		return groupTypeModelAssembler.toCollectionModel(groupsType) ;
	}
	
	@GetMapping("/{groupId}")
	public GroupTypeModel search(@PathVariable Long groupId) {
		GroupType groupType = registerGroupTypeServcice.findOrFail(groupId);
		return groupTypeModelAssembler.toModel(groupType);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public GroupTypeModel add(@RequestBody @Valid GroupTypeInput groupTypeInput) {
		GroupType groupType	= groupTypeInputDisassembler.toDomainModel(groupTypeInput);
		groupType =	registerGroupTypeServcice.save(groupType);
		return groupTypeModelAssembler.toModel(groupType);
	}
	
	
}
