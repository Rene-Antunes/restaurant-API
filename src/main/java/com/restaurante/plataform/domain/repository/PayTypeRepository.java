package com.restaurante.plataform.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restaurante.plataform.domain.model.Ordering;
import com.restaurante.plataform.domain.model.PayType;

public interface PayTypeRepository extends JpaRepository<PayType, Long> {

}
