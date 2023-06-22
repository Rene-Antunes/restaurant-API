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
	
	
	
	@Transactional
	public void changePassword(Long userId, String currentPassword, String newPassword) {
		User user =  findOrFail(userId);
		
		if(user.passwordNotEquals(currentPassword)) {
			throw new IllegalArgumentException();
		}
	
		user.setPassword(newPassword);
	}
	
	public User findOrFail(Long userId) {
		return userRepository.findById(userId)
				.orElseThrow(() -> new RuntimeException());
	}
}
