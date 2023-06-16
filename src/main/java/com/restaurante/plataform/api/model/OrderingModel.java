package com.restaurante.plataform.api.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;

import com.restaurante.plataform.domain.model.OrderingItem;
import com.restaurante.plataform.domain.model.PayType;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderingModel {
	
	
	 private Long id;
	 private String orderingStats;
	 private BigDecimal subTotal;
	 private BigDecimal totalValue;
	 private OffsetDateTime dateCriation;
	 private OffsetDateTime dateConfirm;
	 private OffsetDateTime dateCancel;
	 private PayType payType;
	 private TablesModel tables;
	 private List<OrderingItemModel> itens = new ArrayList<>();

}
