package com.restaurante.plataform.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.restaurante.plataform.api.model.input.AgendaInput;
import com.restaurante.plataform.domain.model.Agenda;

@Component
public class AgendaModelDisassembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	public Agenda toDomainObject(AgendaInput agendaInput) {
		
		return modelMapper.map(agendaInput, Agenda.class);
	}
	
	
	public void copyToDomainObject(AgendaInput agendaInput, Agenda agenda) {
		modelMapper.map(agendaInput, agenda);
	}
}
