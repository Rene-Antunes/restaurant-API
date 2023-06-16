package com.restaurante.plataform.domain.service;

import java.security.Permission;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurante.plataform.domain.repository.PermitionRepository;

@Service
public class RegisterPermitionService {
	
	@Autowired
	private PermitionRepository permitionRepository;
	
	public Permission findOrFail(Long permitionId) {
		return permitionRepository.findById(permitionId)
				.orElseThrow(()-> new RuntimeException());
	}
}
