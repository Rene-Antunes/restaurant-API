package com.restaurante.plataform.api.controller;

import java.nio.file.Path;
import java.util.UUID;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/products/{productId}/photo")
public class ProductPhotoController {
	
	
	
	@PutMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public void updatePhoto(@PathVariable Long productId,
			@RequestParam MultipartFile file) {
		
		var fileName = UUID.randomUUID().toString()
				+ "_" + file.getOriginalFilename();
		
		var filePhoto = Path.of("C:\\Users\\renea\\OneDrive\\Imagens\\catalogo", fileName);
		
		
		try {
			file.transferTo(filePhoto);
		} catch (Exception e) {
			throw new RuntimeException();		}
	}
}
