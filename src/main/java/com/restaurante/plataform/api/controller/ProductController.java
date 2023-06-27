package com.restaurante.plataform.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.restaurante.plataform.api.assembler.ProductModelAssembler;
import com.restaurante.plataform.api.assembler.ProductModelDisassembler;
import com.restaurante.plataform.api.model.ProductModel;
import com.restaurante.plataform.api.model.input.ProductInput;
import com.restaurante.plataform.domain.model.Product;
import com.restaurante.plataform.domain.repository.ProductRepository;
import com.restaurante.plataform.domain.service.RegisterProductService;

@RestController
@RequestMapping(value = "products")
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductModelAssembler productModelAssembler;
	
	@Autowired
	private ProductModelDisassembler productModelDisassembler;
	
	@Autowired
	private RegisterProductService registerProductService;
	
	@GetMapping
	public List<ProductModel> list() {
		List<Product> produts =	productRepository.findAll();
		return productModelAssembler.toCollectionModel(produts);
	}
	
	@GetMapping("/{productId}")
	public ProductModel search(@PathVariable Long productId ) {
		Product product =	registerProductService.findOrFail(productId);
		return productModelAssembler.toModel(product);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ProductModel add(@RequestBody @Valid ProductInput productInput) {
		Product product =	productModelDisassembler.toDomainObject(productInput);
		product = registerProductService.save(product);
		return productModelAssembler.toModel(product);
	}
	
	
	@PutMapping("/{productId}")
	public ProductModel toUpdate(@PathVariable Long productId,
			@RequestBody @Valid ProductInput productInput) {
		Product currentProduct = registerProductService.findOrFail(productId);
		productModelDisassembler.copyToDomainObject(productInput, currentProduct);
		currentProduct = registerProductService.save(currentProduct);

		return productModelAssembler.toModel(currentProduct);
	}
	
	
	@PutMapping("/{productId}/active")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void activation(@PathVariable Long productId) {
		registerProductService.active(productId);
		
	}
	
	@PutMapping("/{productId}/inactive")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void inactivation(@PathVariable Long productId) {
		registerProductService.inactive(productId);
		
	}
	
	
}
