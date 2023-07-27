package com.restaurante.plataform.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.restaurante.plataform.api.model.AgendaModel;
import com.restaurante.plataform.domain.model.Agenda;

@Component
public class AgendaModelAssembler {
	
	@Autowired
	ModelMapper modelMapper;
	
	
	public AgendaModel toModel(Agenda agenda) {
		return modelMapper.map(agenda, AgendaModel.class);
	}
	
	public List<AgendaModel> toCollectionModel(List<Agenda> agendas){
		return agendas.stream()
				.map(agenda -> toModel(agenda))
				.collect(Collectors.toList());
	}
	
}
