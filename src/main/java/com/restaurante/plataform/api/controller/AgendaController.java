package com.restaurante.plataform.api.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.restaurante.plataform.api.assembler.AgendaModelAssembler;
import com.restaurante.plataform.api.assembler.AgendaModelDisassembler;
import com.restaurante.plataform.api.assembler.AgendamentoModelAssembler;
import com.restaurante.plataform.api.model.AgendaModel;
import com.restaurante.plataform.api.model.AgendamentoModel;
import com.restaurante.plataform.api.model.input.AgendaInput;
import com.restaurante.plataform.domain.model.Agenda;
import com.restaurante.plataform.domain.model.Tables;
import com.restaurante.plataform.domain.repository.AgendaRespository;
import com.restaurante.plataform.domain.service.RegisterAgendaService;
import com.restaurante.plataform.domain.service.RegisterTablesService;
import com.restaurante.plataform.domain.service.ReservationSchedulerService;

@RestController
@RequestMapping(value = "agendas")
public class AgendaController {
	
	@Autowired
	public AgendaRespository agendaRespository;
	
	@Autowired
	private RegisterAgendaService registerAgendaService;
	
	@Autowired
	private RegisterTablesService registerTablesService;
	
	@Autowired
	private AgendamentoModelAssembler agedAgendamentoModelAssembler;
	
	@Autowired
	private AgendaModelAssembler agendaModelAssembler;
	
	@Autowired
	private AgendaModelDisassembler agendaModelDisassembler;
	
	@GetMapping
	public List<AgendaModel> list(){
		List<Agenda> agendas = agendaRespository.findAll();
		
		return agendaModelAssembler.toCollectionModel(agendas);
	}
	
	@GetMapping("{agendaId}")
	public AgendaModel search(@PathVariable Long agendaId) {
		Agenda agenda = registerAgendaService.findOrFail(agendaId);
		return agendaModelAssembler.toModel(agenda);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public AgendamentoModel add(@RequestBody @Valid AgendaInput agendaInput ) {
		Agenda agenda = agendaModelDisassembler.toDomainObject(agendaInput);
		registerAgendaService.save(agenda);
		
		return agedAgendamentoModelAssembler.toModel(agenda);
	}
	
	//TODO implementar exclusão de agendamento com mudança de status automático
}
