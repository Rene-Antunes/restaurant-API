package com.restaurante.plataform.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
@Entity
public class PhotoProduct {
	
	@EqualsAndHashCode.Include
	@Id
	@Column
	private Long id;
	
	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	private Product product;
	
	private String fileName;
	private String description;
	private String contentType;
	private Long size;
	

}
