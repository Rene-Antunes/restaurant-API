package com.restaurante.plataform.domain.repository;

import java.security.Permission;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restaurante.plataform.domain.model.Ordering;

public interface PermitionRepository extends JpaRepository<Permission, Long> {

}
