package com.restaurante.plataform.api.model.input;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import com.restaurante.plataform.domain.model.TableStats;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TablesInputUpdate {
	
	@NotNull
	private TableStats tableStats = TableStats.AVAILABLE;
	
}
