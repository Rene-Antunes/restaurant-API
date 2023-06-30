package com.restaurante.plataform.api.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderingItemModel {
	
	private Long productId;
	private Integer quantity;
	private BigDecimal unitPrice;
	private BigDecimal totalPrice;
	private String observation;
}
