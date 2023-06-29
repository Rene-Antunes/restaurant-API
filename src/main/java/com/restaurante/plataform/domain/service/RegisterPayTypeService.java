package com.restaurante.plataform.domain.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.restaurante.plataform.domain.model.PayType;
import com.restaurante.plataform.domain.repository.PayTypeRepository;

@Service
public class RegisterPayTypeService {
	
	@Autowired
	private PayTypeRepository payTypeRepository;
	
	
	@Transactional
	public PayType save(PayType payType) {
		return payTypeRepository.save(payType);
	}
	
	
	@Transactional
	public void delete(Long payTypeId) {
		try {
			
			payTypeRepository.deleteById(payTypeId);
		} catch (Exception e) {
			throw new EmptyResultDataAccessException("Forma de pagamento não encontrada", 0);
		}
	}
	
	
	public PayType findOrFail(Long payTypeId) {
		return payTypeRepository.findById(payTypeId)
				.orElseThrow(() -> new RuntimeException());
	}
}	
