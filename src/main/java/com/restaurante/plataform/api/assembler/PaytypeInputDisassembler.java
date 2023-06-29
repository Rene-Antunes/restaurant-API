package com.restaurante.plataform.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.restaurante.plataform.api.model.input.PayTypeInput;
import com.restaurante.plataform.domain.model.PayType;

@Component
public class PaytypeInputDisassembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public PayType toDomainModel(PayTypeInput payTypeInput) {
		return modelMapper.map(payTypeInput, PayType.class);
	}
	
	public void copyToDomainModel(PayTypeInput payTypeInput, PayType payType) {
		modelMapper.map(payTypeInput, payType);
	}
}	
