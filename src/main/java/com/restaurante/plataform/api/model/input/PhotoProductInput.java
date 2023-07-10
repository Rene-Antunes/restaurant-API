package com.restaurante.plataform.api.model.input;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PhotoProductInput {
	
	private MultipartFile file;
	
	private String description;
	
}
