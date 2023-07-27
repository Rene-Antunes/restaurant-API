package com.restaurante.plataform.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restaurante.plataform.domain.model.Agenda;

public interface AgendaRespository extends JpaRepository<Agenda, Long>{

}
