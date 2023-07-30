package com.restaurante.plataform.api.model;

import java.time.OffsetDateTime;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AgendaModel {
	
	private Long id;
	private String nomeClient;
	private String email;
	private String phoneNumber;
	private OffsetDateTime date;
	private OffsetDateTime hour;
	private List<TablesModel> tables;
	
}
