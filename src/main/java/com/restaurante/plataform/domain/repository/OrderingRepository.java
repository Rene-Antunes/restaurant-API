package com.restaurante.plataform.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restaurante.plataform.domain.model.Ordering;

@Repository
public interface OrderingRepository extends JpaRepository<Ordering, Long> {
	
	Optional<Ordering> findByCode(String code);
}
