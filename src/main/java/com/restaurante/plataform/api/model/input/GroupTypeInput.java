package com.restaurante.plataform.api.model.input;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GroupTypeInput {
	
	@NotBlank
	private String name;
	private List<PermitInputGroup> permissions = new ArrayList<>();
	
}
