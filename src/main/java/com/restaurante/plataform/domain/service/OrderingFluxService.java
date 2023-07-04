package com.restaurante.plataform.domain.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurante.plataform.domain.model.Ordering;

@Service
public class OrderingFluxService {
	
	
	@Autowired
	private IssuenceOfOrderService issuenceOfOrderService;
	
	
	@Transactional
	public void confirme(Long orderId) {
		Ordering order = issuenceOfOrderService.finOrFail(orderId);
		order.confirme();
	}
	
	@Transactional
	public void ready(Long orderId) {
		Ordering order = issuenceOfOrderService.finOrFail(orderId);
		order.ready();
	}

	@Transactional
	public void delivered(Long orderId) {
		Ordering order = issuenceOfOrderService.finOrFail(orderId);
		order.delivered();
	}
	
	@Transactional
	public void cancel(Long orderId) {
		Ordering order = issuenceOfOrderService.finOrFail(orderId);
		order.cancel();
	}
	
	
	
}
