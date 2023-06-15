package com.restaurante.plataform.domain.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurante.plataform.domain.model.User;
import com.restaurante.plataform.domain.repository.UserRepository;

@Service
public class RegisterUserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public User save(User user) {
		
		return userRepository.save(user);
	}
	
	
	public User findOrFail(Long userId) {
		return userRepository.findById(userId)
				.orElseThrow(() -> new RuntimeException());
	}
}
