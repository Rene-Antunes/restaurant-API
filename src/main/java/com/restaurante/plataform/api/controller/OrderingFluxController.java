package com.restaurante.plataform.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.restaurante.plataform.domain.service.OrderingFluxService;

@RestController
@RequestMapping(value = "/orders/{orderId}")
public class OrderingFluxController {
	
	
	@Autowired
	private OrderingFluxService orderingFluxService ;
	
	
	@PutMapping("/confirme")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void confirme(@PathVariable Long orderId) {
		orderingFluxService.confirme(orderId);
	}
	
	@PutMapping("/ready")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void ready(@PathVariable Long orderId) {
		orderingFluxService.ready(orderId);
	}
	
	@PutMapping("/delivered")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delivered(@PathVariable Long orderId) {
		orderingFluxService.delivered(orderId);
	}
	
	@PutMapping("/cancel")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void cancel(@PathVariable Long orderId) {
		orderingFluxService.cancel(orderId);
	}
}
