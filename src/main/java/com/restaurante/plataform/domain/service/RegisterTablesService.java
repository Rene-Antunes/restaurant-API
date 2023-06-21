package com.restaurante.plataform.domain.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurante.plataform.domain.model.Tables;
import com.restaurante.plataform.domain.repository.TablesRepository;

@Service
public class RegisterTablesService {
	
	@Autowired
	private TablesRepository tablesRepository;
	
	
	@Transactional
	public Tables save(Tables table) {
		return tablesRepository.save(table);
	}
	
	public Tables findOrFail(Long tablesId) {
		return tablesRepository.findById(tablesId)
				.orElseThrow(() -> new RuntimeException());
	}
	
}
