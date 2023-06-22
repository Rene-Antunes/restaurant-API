package com.restaurante.plataform.domain.model;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class User {
	
	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String celphone;
	@Column(nullable = false)
	private String email;
	@Column(nullable = false)
	private String password;
	@CreationTimestamp
	@Column(nullable = false, columnDefinition = "datetime")
	private OffsetDateTime dateRegister;
	
	@OneToMany
	@JoinColumn(name = "server_tables_id" , nullable = false)
	@Cascade(value = CascadeType.ALL)
	private List<Tables> responsibleForTables = new ArrayList<>();
	
	@ManyToMany
	private Set<GroupType> category = new HashSet<>();
	
	public boolean passwordEquals(String password) {
		return getPassword().equals(password);
	}
	
	public boolean passwordNotEquals(String password) {
		return !passwordEquals(password);
	}
	
	
	
}
