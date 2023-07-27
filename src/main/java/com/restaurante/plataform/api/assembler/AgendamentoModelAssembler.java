package com.restaurante.plataform.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.restaurante.plataform.api.model.AgendamentoModel;
import com.restaurante.plataform.domain.model.Agenda;

@Component
public class AgendamentoModelAssembler {
	
	@Autowired
	ModelMapper modelMapper;
	
	
	public AgendamentoModel toModel(Agenda agenda) {
		return modelMapper.map(agenda, AgendamentoModel.class);
	}
	
	public List<AgendamentoModel> toCollectionModel(List<Agenda> agendas){
		return agendas.stream()
				.map(agenda -> toModel(agenda))
				.collect(Collectors.toList());
	}
	
}
