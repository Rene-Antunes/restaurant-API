package com.restaurante.plataform.domain.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurante.plataform.domain.exception.EntityNotFoundException;
import com.restaurante.plataform.domain.model.Agenda;
import com.restaurante.plataform.domain.repository.AgendaRespository;

@Service
public class RegisterAgendaService {
	
	@Autowired
	private AgendaRespository agendaRespository;
	
	
	@Transactional
	public Agenda save(Agenda agenda) {
		return	agendaRespository.save(agenda);
	}
	
	
	
	public Agenda findOrFail(Long agendaId) {
		return	agendaRespository.findById(agendaId)
			.orElseThrow(() -> new EntityNotFoundException("Agendamento não pode ser encontrado"));
	} 
	
}
