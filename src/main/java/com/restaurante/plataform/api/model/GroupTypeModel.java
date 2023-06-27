package com.restaurante.plataform.api.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class GroupTypeModel {
	
	private Long id;
	private String name;
	private List<PermitModel> permissions = new ArrayList<>();
}
