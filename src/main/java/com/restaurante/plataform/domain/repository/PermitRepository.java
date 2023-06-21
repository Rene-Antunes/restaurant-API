package com.restaurante.plataform.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restaurante.plataform.domain.model.Permit;

public interface PermitRepository extends JpaRepository<Permit, Long> {

}
