package com.restaurante.plataform.api.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserModel {
	
	private Long id;
	private String name;
	private String celphone;
	private String email;
	private List<TablesModel> responsibleForTables;
}
