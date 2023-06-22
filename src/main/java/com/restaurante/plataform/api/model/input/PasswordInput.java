package com.restaurante.plataform.api.model.input;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PasswordInput {
	
	private String currentPassword;
	private String newPassword;
}
