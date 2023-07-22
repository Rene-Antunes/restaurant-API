package com.restaurante.plataform.api.model.input;

import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PhotoProductInput {
	
	@NotNull
	private MultipartFile file;
	
	@NotNull
	private String description;
	
}
