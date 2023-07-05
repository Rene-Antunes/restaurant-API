package com.restaurante.plataform.domain.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurante.plataform.domain.model.GroupType;
import com.restaurante.plataform.domain.model.Permit;
import com.restaurante.plataform.domain.repository.GroupTypeRepository;

@Service
public class RegisterGroupTypeServcice {
	
	@Autowired
	private GroupTypeRepository groupTypeRepository;
	
	@Autowired
	private RegisterPermitService registerPermitService;

	
	@Transactional
	public GroupType save(GroupType groupType){
		return groupTypeRepository.save(groupType);
	}
	
	
	@Transactional
	public void delete(Long groupTypeId) {
		try {
			groupTypeRepository.deleteById(groupTypeId);
			groupTypeRepository.flush();
		} catch (Exception e) {
			throw new RuntimeException();
		}
	
	}
	
	@Transactional
	public void associetePermitssion(Long groupId, Long permissionId) {
		GroupType groupType = findOrFail(groupId);
		Permit permit = registerPermitService.findOrFail(permissionId);
		
		groupType.addPermission(permit);
	}
	
	@Transactional
	public void dissacietePermitssion(Long groupId, Long permissionId) {
		GroupType groupType = findOrFail(groupId);
		Permit permit = registerPermitService.findOrFail(permissionId);
		
		groupType.removePermission(permit);
	}
	
	
	public GroupType findOrFail(Long groupTypeId) {
		return groupTypeRepository.findById(groupTypeId)
				.orElseThrow(() -> new RuntimeException());
	}
}
