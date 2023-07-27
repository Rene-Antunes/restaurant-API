package com.restaurante.plataform.api.model;

import java.time.OffsetDateTime;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AgendamentoModel {
	
	private Long id;
	private String nomeCliente;
	private OffsetDateTime date;
	private OffsetDateTime hour;
}
