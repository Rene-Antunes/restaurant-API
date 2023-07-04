package com.restaurante.plataform.domain.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurante.plataform.domain.model.Ordering;
import com.restaurante.plataform.domain.model.PayType;
import com.restaurante.plataform.domain.model.Product;
import com.restaurante.plataform.domain.model.Tables;
import com.restaurante.plataform.domain.repository.OrderingRepository;

@Service
public class IssuenceOfOrderService {
	
	@Autowired
	private OrderingRepository orderingRepository;
	
	@Autowired
	private RegisterPayTypeService registerPayTypeService;
	@Autowired
	private RegisterTablesService registerTablesService;
	
	@Autowired
	private RegisterProductService registerProductService;

	
	@Transactional
	public Ordering issue(Ordering ordering) {
		orderValidate(ordering);
		itensValidate(ordering);
		
		ordering.calcTotalValue();
		
		return orderingRepository.save(ordering);
	}
	
	private void orderValidate(Ordering ordering) {
		PayType payType = registerPayTypeService.findOrFail(ordering.getPayType().getId());
		Tables tables = registerTablesService.findOrFail(ordering.getTables().getId());
		
		ordering.setPayType(payType);
		ordering.setTables(tables);
		
		if(payType.getId() == null) {
			throw new RuntimeException("Forma de pagamento não deve ser nula.") ;
		}
	}
	
	
	private void itensValidate(Ordering ordering) {
		ordering.getItens().forEach(iten -> {
			Product product = registerProductService.findOrFail(iten.getProduct().getId());
		
			iten.setOrdering(ordering);
			iten.setProduct(product);
			iten.setUnitPrice(product.getPrice());
		
		});
	}
	
	public Ordering findOrFail(String codeOrder) {
		return orderingRepository.findByCode(codeOrder)
				.orElseThrow(() -> new RuntimeException());
	}
}
