package com.restaurante.plataform.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.restaurante.plataform.domain.exception.ExceptionBusiness;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Tables {

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private Integer number;
	
	@Enumerated(EnumType.STRING)
	private TableStats tableStats;

	public void agending() {
		setTablesStats(TableStats.RESERVED);
	}
	
	
	private void setTablesStats(TableStats newStats) {
			if (getTableStats().cantChancheTo(newStats)) {
				throw new ExceptionBusiness(String.format("Não pode mudar Status %s %s",
						getTableStats().getDescription(), newStats.getDescription()));
			}
			
		this.tableStats = newStats;
	}
}
