package com.restaurante.plataform.domain.service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.restaurante.plataform.domain.model.Agenda;
import com.restaurante.plataform.domain.model.TableStats;
import com.restaurante.plataform.domain.model.Tables;
import com.restaurante.plataform.domain.repository.AgendaRespository;

@Component
public class ReservationSchedulerService {
	
	
	@Autowired
	private RegisterTablesService registerTablesService;
	
	@Autowired
	private AgendaRespository agendaRespository;
	
	@Scheduled(fixedRate = 60000)
	public void processReservations() {
		
		List<Agenda> pendingReservations = getPendingReservations();
		
		OffsetDateTime currentDateTime = OffsetDateTime.now();
		
		for (Agenda agenda : pendingReservations) {
			if (agenda.getDate().getDayOfYear() - currentDateTime.getDayOfYear() == 0 ) {
				setStatusTable(pendingReservations);
			}
		}
		
	}

	private void setStatusTable(List<Agenda> pendingReservations) {
		List<List<Tables>> tables =	pendingReservations.stream()
			.map(table -> registerTablesService.findOrFailList(table.getTablesIds()))
			.collect(Collectors.toList());
		tables.stream()
		.forEach(table -> table.forEach( tableStatus -> tableStatus.setTableStats(TableStats.RESERVED)));
			
		registerTablesService.saveAllNewStatus(tables);
	}

	private List<Agenda> getPendingReservations() {
		return agendaRespository.findAll();
	}
	
	
}
