package com.restaurante.plataform.domain.model;

import java.util.Arrays;
import java.util.List;

public enum TableStats {
	
	AVAILABLE("Available"),
	BUSY("Busy",AVAILABLE),
	ATTEND("Attend",BUSY),
	NOT_ATTEND("Not attend",BUSY),
	RECEIVED("received",ATTEND),
	RESERVED("reserved",AVAILABLE,BUSY,ATTEND,NOT_ATTEND,RECEIVED);
	
	private String description;
	private List<TableStats> previousStats;
	
	private TableStats(String description, TableStats... tableStats) {
		this.description = description;
		this.previousStats = Arrays.asList(tableStats);
	}
	
	public String getDescription() {
		return description;
	}
	
	public boolean cantChancheTo(TableStats newStats) {
		return !newStats.previousStats.contains(this);
	}
	
	
	//TODO implementar verificação de mudança de status
}
