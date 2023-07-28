package com.restaurante.plataform.domain.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.restaurante.plataform.domain.exception.TableNotFoundException;
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
	
	@Transactional
	public List<Tables> saveAll(List<Tables> tables) {
		return tablesRepository.saveAll(tables);
	}
	
	
	@Transactional
	public void delete(Long tablesId) {
		try {
			
			tablesRepository.deleteById(tablesId);
		} catch (TableNotFoundException e) {
			throw new TableNotFoundException(
					String.format("Mesa de código %d não encontrada", tablesId));
		}
	}
	
	public Tables findOrFail(Long tablesId) {
		return tablesRepository.findById(tablesId)
				.orElseThrow(() -> new TableNotFoundException(tablesId));
	}
	
	public List<Tables> findOrFailList(List<Long> tablesId) {
		try {
			
			return tablesRepository.findAllById(tablesId);
		} catch (TableNotFoundException e) {
			throw new TableNotFoundException("Mesa não pode ser encontrada");
		}
				
	}
	

	
}
