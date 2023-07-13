package com.restaurante.plataform.domain.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurante.plataform.domain.exception.ExceptionBusiness;
import com.restaurante.plataform.domain.exception.PayTypeNotFoundException;
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
		} catch (PayTypeNotFoundException e) {
			throw new PayTypeNotFoundException("Forma de pagamento não encontrada");
		}
	}
	
	
	public PayType findOrFail(Long payTypeId) {
		return payTypeRepository.findById(payTypeId)
				.orElseThrow(() -> new ExceptionBusiness("Forma de pagamento não encontrada"));
	}
}	
