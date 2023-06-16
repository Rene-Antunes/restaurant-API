package com.restaurante.plataform.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restaurante.plataform.domain.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
