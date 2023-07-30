package com.restaurante.plataform.domain.model;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Agenda {
	
	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomeClient;
	private String email;
	private String phoneNumber;
	private OffsetDateTime date;
	private OffsetDateTime hour;
	
	@OneToMany
	private List<Tables> tables = new ArrayList<>();
	
	public List<Long> gettablesIds(){
	     return	tables.stream()
			.map(Tables::getId)
			.collect(Collectors.toList());
	}
	
}
