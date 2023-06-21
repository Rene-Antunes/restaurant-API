package com.restaurante.plataform.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurante.plataform.domain.model.Permit;
import com.restaurante.plataform.domain.repository.PermitRepository;

@Service
public class RegisterPermitService {
	
	@Autowired
	private PermitRepository permitionRepository;
	
	public Permit findOrFail(Long permitionId) {
		return permitionRepository.findById(permitionId)
				.orElseThrow(()-> new RuntimeException());
	}
}
