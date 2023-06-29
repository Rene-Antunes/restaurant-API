package com.restaurante.plataform.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.restaurante.plataform.api.assembler.PayTypeModelAssembler;
import com.restaurante.plataform.api.assembler.PaytypeInputDisassembler;
import com.restaurante.plataform.api.model.PayTypeModel;
import com.restaurante.plataform.api.model.input.PayTypeInput;
import com.restaurante.plataform.domain.model.PayType;
import com.restaurante.plataform.domain.repository.PayTypeRepository;
import com.restaurante.plataform.domain.service.RegisterPayTypeService;

@RestController
@RequestMapping(value = "payTypes")
public class PayTypeController {
		
	
	@Autowired
	private RegisterPayTypeService registerPayTypeService;
	
	@Autowired
	private PayTypeModelAssembler payTypeModelAssembler;
	
	@Autowired
	private PaytypeInputDisassembler paytypeInputDisassembler;

	
	@Autowired
	private PayTypeRepository payTypeRepository;
	
	@GetMapping
	public List<PayTypeModel> list(){
		List<PayType> payTypes = payTypeRepository.findAll();
		return payTypeModelAssembler.toCollectionModel(payTypes);
	}
	
	@GetMapping("/{payTypeId}")
	public PayTypeModel search(@PathVariable Long payTypeId) {
		PayType payType = registerPayTypeService.findOrFail(payTypeId);
		return payTypeModelAssembler.toModel(payType);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public PayTypeModel add(@RequestBody @Valid PayTypeInput payTypeInput) {
		PayType payType = paytypeInputDisassembler.toDomainModel(payTypeInput);
		payType = registerPayTypeService.save(payType);
		return payTypeModelAssembler.toModel(payType);
	}
	
	@PutMapping("/{payTypeId}")
	public PayTypeModel toUpdate(@PathVariable Long payTypeId,
			@RequestBody @Valid PayTypeInput payTypeInput) {
		PayType payType = registerPayTypeService.findOrFail(payTypeId);
		paytypeInputDisassembler.copyToDomainModel(payTypeInput, payType);
		payType = registerPayTypeService.save(payType);
		return payTypeModelAssembler.toModel(payType);
	}
	
	@DeleteMapping("/{payTypeId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remove(@PathVariable Long payTypeId ) {
		registerPayTypeService.delete(payTypeId);
	}
	
	
}
