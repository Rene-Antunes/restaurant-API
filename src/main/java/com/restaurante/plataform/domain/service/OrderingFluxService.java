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
	public void confirme(String orderCode) {
		Ordering order = issuenceOfOrderService.findOrFail(orderCode);
		order.confirme();
	}
	
	@Transactional
	public void ready(String orderCode) {
		Ordering order = issuenceOfOrderService.findOrFail(orderCode);
		order.ready();
	}

	@Transactional
	public void delivered(String orderCode) {
		Ordering order = issuenceOfOrderService.findOrFail(orderCode);
		order.delivered();
	}
	
	@Transactional
	public void cancel(String orderCode) {
		Ordering order = issuenceOfOrderService.findOrFail(orderCode);
		order.cancel();
	}
	
	
	
}
