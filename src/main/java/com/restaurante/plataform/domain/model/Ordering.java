package com.restaurante.plataform.domain.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Ordering {
	
	 @Id
	 @EqualsAndHashCode.Include
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 
	 private OrderingStats orderingStats;
	 
	 private BigDecimal subTotal;
	 private BigDecimal totalValue;
	 
	 @CreationTimestamp
	 private OffsetDateTime dateCriation;
	 
	 private OffsetDateTime dateConfirm;
	 private OffsetDateTime dateCancel;
	 
	 @ManyToOne
	 @JoinColumn(nullable = false)
	 private PayType payType;

	 @ManyToOne
	 @JoinColumn(name = "user_client_id", nullable = false)
	 private User client;

	 @OneToMany(mappedBy = "ordering") 	
	 private List<OrderingItem> itens = new ArrayList<>();

}
