package com.restaurante.plataform.domain.service;

import java.io.InputStream;
import java.util.UUID;

import lombok.Builder;
import lombok.Getter;

public interface PhotoStorageService {

	void toStore(NewPhoto newPhoto);
	
	void remove(String fileName);
	
	InputStream toRecover(String fileName);
	
	
	default String generateNameFile(String originName) {
		return UUID.randomUUID().toString() + "_" + originName;
	}
	
	default void toReplace(String oldFileName, NewPhoto newPhoto) {
		this.toStore(newPhoto);
		
		if (oldFileName != null) {
			this.remove(oldFileName);
		}
	}
	
	
	@Builder
	@Getter
	class NewPhoto {
		private String fileName;
		private InputStream inputStream;
	}
	
}
