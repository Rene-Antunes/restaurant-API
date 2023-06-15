package com.restaurante.plataform.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurante.plataform.api.assembler.TablesModelAssembler;
import com.restaurante.plataform.api.model.TablesModel;
import com.restaurante.plataform.domain.model.Tables;
import com.restaurante.plataform.domain.repository.TablesRepository;

@RestController
@RequestMapping(value = "tables")
public class TablesControllers {
	
	@Autowired
	private TablesRepository tablesRepository;
	
	@Autowired
	private TablesModelAssembler tablesModelAssembler;
	
	@GetMapping
	public List<TablesModel> listar(){
		List<Tables> AllTables = tablesRepository.findAll();
		return tablesModelAssembler.toCollectionModel(AllTables);
	}
	
}
