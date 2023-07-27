package com.restaurante.plataform.api.model.input;

import java.time.OffsetDateTime;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AgendaInput {

	@NotBlank
	private String nomeCliente;
	@NotNull
	private OffsetDateTime date;
	@NotNull
	private OffsetDateTime hour;
	
	@Valid
	@NotNull
	private TablesIdInput tables;

}
