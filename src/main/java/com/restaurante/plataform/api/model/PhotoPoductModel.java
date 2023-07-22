package com.restaurante.plataform.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PhotoPoductModel {
	
	private String fileName;
	private String description;
	private String contentType;
	private Long size;
}
