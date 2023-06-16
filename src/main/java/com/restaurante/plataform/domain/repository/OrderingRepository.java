package com.restaurante.plataform.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restaurante.plataform.domain.model.Ordering;

public interface OrderingRepository extends JpaRepository<Ordering, Long> {

}
