package com.restaurante.plataform.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.restaurante.plataform.api.assembler.PermitModelAssembler;
import com.restaurante.plataform.api.assembler.PermitModelDisassembler;
import com.restaurante.plataform.api.model.PermitModel;
import com.restaurante.plataform.api.model.input.PermitInput;
import com.restaurante.plataform.domain.model.Permit;
import com.restaurante.plataform.domain.repository.PermitRepository;
import com.restaurante.plataform.domain.service.RegisterPermitService;

@RestController
@RequestMapping("permissions")
public class PermitController {
	
	@Autowired
	private PermitRepository permitRepository;
	
	@Autowired
	private PermitModelAssembler permitModelAssembler;
	
	@Autowired
	private PermitModelDisassembler permitModelDisassembler;
	
	@Autowired
	private RegisterPermitService registerPermitService;
	
	@GetMapping
	public List<PermitModel> list() {
		
		List<Permit> permissions = permitRepository.findAll();
		return permitModelAssembler.toCollectionModel(permissions);
	
	}
	
	
	@GetMapping("{permitId}")
	public PermitModel search(@PathVariable Long permitId) {
		Permit permit = registerPermitService.findOrFail(permitId);
		
		return permitModelAssembler.toModel(permit);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public PermitModel add(@RequestBody @Valid PermitInput permitInput) {
		Permit permit = permitModelDisassembler.toDomainObject(permitInput);
		registerPermitService.save(permit);
		return permitModelAssembler.toModel(permit);
	}
	
	@DeleteMapping("{permitId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remove(@PathVariable Long permitId) {
		registerPermitService.delete(permitId);
	}
}
