package com.restaurante.plataform.domain.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class OrderingItem {
	
	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Integer quantity;
	private BigDecimal unitPrice;
	private BigDecimal totalPrice;
	private String observation;
	
	@ManyToOne
	@JoinColumn(name = "ordering_id", nullable = false)
	private Ordering ordering;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Product product;
}
