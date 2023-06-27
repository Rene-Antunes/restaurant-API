package com.restaurante.plataform.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.restaurante.plataform.api.assembler.TablesInputDisassembler;
import com.restaurante.plataform.api.assembler.TablesModelAssembler;
import com.restaurante.plataform.api.model.TablesModel;
import com.restaurante.plataform.api.model.input.TablesInput;
import com.restaurante.plataform.api.model.input.TablesInputUpdate;
import com.restaurante.plataform.domain.model.Tables;
import com.restaurante.plataform.domain.repository.TablesRepository;
import com.restaurante.plataform.domain.service.RegisterTablesService;

@RestController
@RequestMapping(value = "tables")
public class TablesControllers {
	
	@Autowired
	private TablesRepository tablesRepository;
	
	@Autowired
	private TablesModelAssembler tablesModelAssembler;
	
	@Autowired
	private RegisterTablesService registerTablesService;
	
	@Autowired
	private TablesInputDisassembler tablesInputDisassembler;
	
	@GetMapping
	public List<TablesModel> list(){
		List<Tables> AllTables = tablesRepository.findAll();
		return tablesModelAssembler.toCollectionModel(AllTables);
	}
	
	@GetMapping("/{tablesId}")
	public TablesModel search(@PathVariable Long tablesId) {
		Tables table = registerTablesService.findOrFail(tablesId);
		
		return tablesModelAssembler.toModel(table);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public TablesModel add(@RequestBody @Valid TablesInput tablesInput) {
		Tables table = tablesInputDisassembler.toDomainObject(tablesInput);
		table = registerTablesService.save(table);
		
		return tablesModelAssembler.toModel(table);
	}
	
	@PostMapping("/saveTables")
	@ResponseStatus(HttpStatus.CREATED)
	public List<TablesModel> addTables(@RequestBody @Valid List<TablesInput> tablesInputs ){
	
		List<Tables> newtables = tablesInputDisassembler.toDomainObjectList(tablesInputs);
		newtables = registerTablesService.saveAll(newtables);
		return tablesModelAssembler.toCollectionModel(newtables);
	}
	
	@PutMapping("/{tablesId}")
	public TablesModel toUpdate(@PathVariable Long tablesId,
			@RequestBody TablesInputUpdate tablesInputUpdate) {
		
		Tables currentTables =	registerTablesService.findOrFail(tablesId);
		tablesInputDisassembler.copyToDomainObject(tablesInputUpdate, currentTables);
		currentTables = registerTablesService.save(currentTables);
		
		return tablesModelAssembler.toModel(currentTables);
	}
	
	@DeleteMapping("/{tablesId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remove(@PathVariable Long tablesId) {
		registerTablesService.delete(tablesId);
	}
	
	
}
