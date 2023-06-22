package com.restaurante.plataform.api.model.input;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class UserInput {
	
	@NotBlank
	private String name;
	@NotBlank
	private String celphone;
	@NotBlank
	private String email;
	
	private List<TablesInput> responsibleForTables = new ArrayList<>(); 
}
