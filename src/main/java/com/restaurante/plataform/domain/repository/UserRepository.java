package com.restaurante.plataform.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restaurante.plataform.domain.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	Optional<User> findByEmail(String email);
}
