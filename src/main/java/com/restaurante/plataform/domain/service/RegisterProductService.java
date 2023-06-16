package com.restaurante.plataform.domain.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurante.plataform.domain.model.Product;
import com.restaurante.plataform.domain.repository.ProductRepository;

@Service
public class RegisterProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Transactional
	public Product save(Product product) {
		return  productRepository.save(product);
	}
	
	public Product findOrFail(Long productId) {
		return productRepository.findById(productId)
				.orElseThrow(() -> new RuntimeException());
	}

}
