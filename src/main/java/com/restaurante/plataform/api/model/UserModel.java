package com.restaurante.plataform.api.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.restaurante.plataform.domain.model.GroupType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserModel {
	
	private Long id;
	private String name;
	private String celphone;
	private String email;
	private Set<GroupType> category = new HashSet<>();
	private List<TablesModel> responsibleForTables;
}
