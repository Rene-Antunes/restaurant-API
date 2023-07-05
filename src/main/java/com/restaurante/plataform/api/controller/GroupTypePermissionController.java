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

import com.restaurante.plataform.api.assembler.PermitModelAssembler;
import com.restaurante.plataform.api.model.PermitModel;
import com.restaurante.plataform.domain.model.GroupType;
import com.restaurante.plataform.domain.service.RegisterGroupTypeServcice;

@RestController
@RequestMapping(value = "groups/{groupId}/permissions")
public class GroupTypePermissionController {
	
	
	@Autowired
	private RegisterGroupTypeServcice registerGroupTypeServcice;
	
	@Autowired
	private PermitModelAssembler permitModelAssembler;
	
	@GetMapping
	public List<PermitModel> list (@PathVariable Long groupId){
		GroupType groupType = registerGroupTypeServcice.findOrFail(groupId);
		return permitModelAssembler.toCollectionModel(groupType.getPermissions());
	}
	
	
	@PutMapping("{permissionId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void associetion(@PathVariable Long groupId, @PathVariable Long permissionId) {
		registerGroupTypeServcice.associetePermitssion(groupId, permissionId);
	}
	
	@DeleteMapping("{permissionId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void dissacietion(@PathVariable Long groupId, @PathVariable Long permissionId) {
		registerGroupTypeServcice.dissacietePermitssion(groupId, permissionId);
	}
}
