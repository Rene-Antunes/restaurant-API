package com.restaurante.plataform.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restaurante.plataform.domain.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
