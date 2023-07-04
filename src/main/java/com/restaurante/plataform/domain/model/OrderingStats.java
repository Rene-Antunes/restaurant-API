package com.restaurante.plataform.domain.model;

import java.util.Arrays;
import java.util.List;

public enum OrderingStats {
	
	CREATED("Created"),
	CONFIRMED("Confirmado", CREATED),
	READY_TO_SERVE("Ready", CONFIRMED),
	RECEVEID("Receveid", READY_TO_SERVE),
	CANCELED("Canceled", CREATED, CONFIRMED, READY_TO_SERVE);
	
	private String description;
	private List<OrderingStats> previousStats;
	
	private OrderingStats(String description, OrderingStats... orderingStats ) {
		this.description = description;
		this.previousStats = Arrays.asList(orderingStats);
	}

	public String getDescription() {
		return description;
	}

	public boolean cantChangeTo(OrderingStats newStats){
		return !newStats.previousStats.contains(this);
	}
	

}
