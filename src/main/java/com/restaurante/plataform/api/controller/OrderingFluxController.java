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
@RequestMapping(value = "/orders/{orderCode}")
public class OrderingFluxController {
	
	
	@Autowired
	private OrderingFluxService orderingFluxService ;
	
	
	@PutMapping("/confirme")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void confirme(@PathVariable String orderCode) {
		orderingFluxService.confirme(orderCode);
	}
	
	@PutMapping("/ready")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void ready(@PathVariable String orderCode) {
		orderingFluxService.ready(orderCode);
	}
	
	@PutMapping("/delivered")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delivered(@PathVariable String orderCode) {
		orderingFluxService.delivered(orderCode);
	}
	
	@PutMapping("/cancel")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void cancel(@PathVariable String orderCode) {
		orderingFluxService.cancel(orderCode);
	}
}
