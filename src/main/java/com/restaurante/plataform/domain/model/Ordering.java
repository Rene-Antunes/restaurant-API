package com.restaurante.plataform.domain.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
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
	 
	 @Enumerated(EnumType.STRING)
	 private OrderingStats orderingStats;
	 
	 private BigDecimal subTotal;
	 private BigDecimal totalValue;
	 private BigDecimal serverTax;
	 
	 @CreationTimestamp
	 private OffsetDateTime dateCriation;
	 
	 private OffsetDateTime dateConfirm;
	 private OffsetDateTime dateCancel;
	 
	 @ManyToOne
	 @JoinColumn(nullable = false)
	 private PayType payType;

	 @ManyToOne
	 @JoinColumn(name = "table_id", nullable = false)
	 private Tables tables;

	 @OneToMany(mappedBy = "ordering",  cascade = CascadeType.ALL)
	 private List<OrderingItem> itens = new ArrayList<>();
	 
	 
	 public void calcTotalValue() {
		 getItens().forEach(OrderingItem::calcValuePrice);
		 
		 this.subTotal = getItens().stream()
				 .map(iten -> iten.getTotalPrice())
				 .reduce(BigDecimal.ZERO,  BigDecimal::add);
		 
		 BigDecimal porcent = totalValue = this.subTotal.add(this.serverTax).multiply(serverTax);
		 
		 this.totalValue = this.subTotal.add(porcent.divide(new BigDecimal(100)));
		
	 }
	 
	 
	 
}
