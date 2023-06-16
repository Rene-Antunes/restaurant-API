package com.restaurante.plataform.domain.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurante.plataform.domain.model.Ordering;
import com.restaurante.plataform.domain.repository.OrderingRepository;

@Service
public class IssuenceOfOrderService {
	
	@Autowired
	private OrderingRepository orderingRepository;
	
	@Transactional
	public Ordering save(Ordering ordering) {
		return orderingRepository.save(ordering);
	}
	
	
	public Ordering finOrFail(Long orderingId) {
		return orderingRepository.findById(orderingId)
				.orElseThrow(() -> new RuntimeException());
	}
}
