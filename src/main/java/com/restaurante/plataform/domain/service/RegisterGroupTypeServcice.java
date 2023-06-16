package com.restaurante.plataform.domain.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurante.plataform.domain.model.GroupType;
import com.restaurante.plataform.domain.repository.GroupTypeRepository;

@Service
public class RegisterGroupTypeServcice {
	
	
	@Autowired
	private GroupTypeRepository groupTypeRepository;

	
	@Transactional
	public GroupType save(GroupType groupType){
		return groupTypeRepository.save(groupType);
	}
	
	public GroupType findOrFail(Long groupTypeId) {
		return groupTypeRepository.findById(groupTypeId)
				.orElseThrow(() -> new RuntimeException());
	}
}
