package com.ada.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ada.api.domain.funcionario.Funcionario;
import com.ada.api.domain.funcionario.FuncionarioRepository;
import com.ada.api.domain.registroDePonto.CreateRegistroPontoDTO;
import com.ada.api.domain.registroDePonto.DetailRegistroDePontoDTO;
import com.ada.api.domain.registroDePonto.ListRegistroPontoDTO;
import com.ada.api.domain.registroDePonto.RegistroDePonto;
import com.ada.api.domain.registroDePonto.RegistroDePontoRepository;

@RestController
@RequestMapping("/registro-ponto")
public class RegistroDePontoController {
	
	@Autowired
	private RegistroDePontoRepository registroRepository;
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@GetMapping
	public List<ListRegistroPontoDTO> list() {
		
		List<ListRegistroPontoDTO> registrosDePonto = registroRepository.findAll().stream().map(ListRegistroPontoDTO::new).toList();
		
		return registrosDePonto;
		
	}
	
	@GetMapping("/{id}")
	public DetailRegistroDePontoDTO detail(@PathVariable Long id) {
		
		DetailRegistroDePontoDTO registroDePonto = new DetailRegistroDePontoDTO(registroRepository.getReferenceById(id));
		
		return registroDePonto;
		
	}
	
	@PostMapping
	public DetailRegistroDePontoDTO create(@RequestBody CreateRegistroPontoDTO data) {
		
		RegistroDePonto registroDePontoCreated = registroRepository.save(new RegistroDePonto(data));
		
		DetailRegistroDePontoDTO registroDePonto = new DetailRegistroDePontoDTO(registroDePontoCreated);
		
		return registroDePonto;
		
	}
	
	
	
}
