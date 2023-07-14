package com.restaurante.plataform.domain.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurante.plataform.domain.exception.ExceptionBusiness;
import com.restaurante.plataform.domain.exception.UserNotFoundException;
import com.restaurante.plataform.domain.model.GroupType;
import com.restaurante.plataform.domain.model.User;
import com.restaurante.plataform.domain.repository.UserRepository;

@Service
public class RegisterUserService {
	
	@Autowired
	private UserRepository userRepository;
			
	@Autowired
	private RegisterGroupTypeServcice registerGroupTypeServcice;
	
	@Transactional
	public User save(User user) {
		
//		userRepository.detach(user);
		
		Optional<User> UserAlreadyExists = 
				userRepository.findByEmail(user.getEmail());
		
		if (UserAlreadyExists.isPresent() && !UserAlreadyExists.get().equals(user)) {
			throw new ExceptionBusiness(
					String.format("Já existe um usuário cadastrado com o e-mail %s",user.getEmail()));
			
		}
		
		return userRepository.save(user);
	}
	
	
	
	@Transactional
	public void changePassword(Long userId, String currentPassword, String newPassword) {
		User user =  findOrFail(userId);
		
		if(user.passwordNotEquals(currentPassword)) {
			throw new ExceptionBusiness("Senha atual informado não coincide com a senha do usuário.");
		}
	
		user.setPassword(newPassword);
	}
	
	
	@Transactional
	public void disassociateGroup(Long userId, Long groupId) {
		User user = findOrFail(userId);
		GroupType group = registerGroupTypeServcice.findOrFail(groupId);
		
		 user.removeGroup(group);
		
	}
	
	@Transactional
	public void addGroup(Long userId, Long groupId) {
		User user = findOrFail(userId);
		GroupType group = registerGroupTypeServcice.findOrFail(groupId);
		
		 user.addGroup(group);
		
	}
	
	public User findOrFail(Long userId) {
		return userRepository.findById(userId)
				.orElseThrow(() -> new UserNotFoundException(userId));
	}
}
