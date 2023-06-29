package com.restaurante.plataform.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.restaurante.plataform.api.model.PayTypeModel;
import com.restaurante.plataform.domain.model.PayType;

@Component
public class PayTypeModelAssembler {
	
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	public PayTypeModel toModel(PayType payType) {
		return modelMapper.map(payType, PayTypeModel.class);
	}

	public List<PayTypeModel> toCollectionModel(List<PayType> payTypes){
		return payTypes.stream()
				.map(payType -> toModel(payType))
				.collect(Collectors.toList());
	}

}
