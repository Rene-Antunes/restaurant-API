package com.restaurante.plataform.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.restaurante.plataform.api.assembler.OrderingInputDisassembler;
import com.restaurante.plataform.api.assembler.OrderingModelAssembler;
import com.restaurante.plataform.api.assembler.OrderingResumeModelAssembler;
import com.restaurante.plataform.api.model.OrderingModel;
import com.restaurante.plataform.api.model.OrderingResumeModel;
import com.restaurante.plataform.api.model.input.OrderingInput;
import com.restaurante.plataform.domain.model.Ordering;
import com.restaurante.plataform.domain.model.Tables;
import com.restaurante.plataform.domain.repository.OrderingRepository;
import com.restaurante.plataform.domain.service.IssuenceOfOrderService;

@RestController
@RequestMapping(value = "orderings")
public class OrderingController {
	
	@Autowired
	private OrderingRepository orderingRepository;
	
	@Autowired
	private OrderingResumeModelAssembler orderingResumeModelAssembler;
	
	@Autowired
	private OrderingInputDisassembler orderingInputDisassembler;
	
	@Autowired
	private OrderingModelAssembler orderingModelAssembler;
	
	@Autowired
	private IssuenceOfOrderService issuenceOfOrderService;
	
	@GetMapping
	public List<OrderingResumeModel> list(){
		List<Ordering> orderings = orderingRepository.findAll();
		return orderingResumeModelAssembler.toCollectionModel(orderings);
	
	}
	
	@GetMapping("/{orderingId}")
	public OrderingModel search(@PathVariable Long orderingId) {
		Ordering ordering =	issuenceOfOrderService.finOrFail(orderingId);
		return orderingModelAssembler.toModel(ordering);
		
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public OrderingModel add(@Valid @RequestBody OrderingInput orderingInput) {
			Ordering newOrdering = orderingInputDisassembler.toDomainObject(orderingInput);
			newOrdering =  issuenceOfOrderService.issue(newOrdering);
			return orderingModelAssembler.toModel(newOrdering);
	}
	
	
}
