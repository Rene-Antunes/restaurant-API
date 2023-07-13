package com.restaurante.plataform.domain.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurante.plataform.domain.exception.EntityNotFoundException;
import com.restaurante.plataform.domain.exception.PermissionNotFoundException;
import com.restaurante.plataform.domain.model.Permit;
import com.restaurante.plataform.domain.repository.PermitRepository;

@Service
public class RegisterPermitService {
	
	@Autowired
	private PermitRepository permitionRepository;
	
	@Transactional
	public Permit save(Permit permit) {
		return permitionRepository.save(permit);
	}
	
	@Transactional
	public void delete(Long permitId) {
	try {
		permitionRepository.deleteById(permitId);
		
	} catch (PermissionNotFoundException e) {
			throw new PermissionNotFoundException(permitId);
		}
	}

	
	public Permit findOrFail(Long permissionId) {
		return permitionRepository.findById(permissionId)
				.orElseThrow(()-> new PermissionNotFoundException(permissionId));
	}
}
