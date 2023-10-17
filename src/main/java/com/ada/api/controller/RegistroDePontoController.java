package com.ada.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ada.api.domain.registroDePonto.CreateRegistroPontoDTO;
import com.ada.api.domain.registroDePonto.RegistroDePonto;
import com.ada.api.domain.registroDePonto.RegistroDePontoRepository;

@RestController
@RequestMapping("/registro-ponto")
public class RegistroDePontoController {
	
	@Autowired
	private RegistroDePontoRepository registroRepository;
	
	@PostMapping
	public RegistroDePonto create(@RequestBody CreateRegistroPontoDTO data) {
		
		RegistroDePonto registroDePonto = registroRepository.save(new RegistroDePonto(data));
		
		return registroDePonto;
		
	}
	
}
