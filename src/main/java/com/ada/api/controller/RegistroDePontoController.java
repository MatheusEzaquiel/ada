package com.ada.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.ada.api.domain.empresa.Empresa;
import com.ada.api.domain.empresa.EmpresaRepository;
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
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	@GetMapping
	public ResponseEntity list() {
		
		List<ListRegistroPontoDTO> registrosDePonto = registroRepository.findAll().stream().map(ListRegistroPontoDTO::new).toList();
		
		return ResponseEntity.status(HttpStatus.OK).body(registrosDePonto);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity detail(@PathVariable Long id) {
		
		DetailRegistroDePontoDTO registroDePonto = new DetailRegistroDePontoDTO(registroRepository.getReferenceById(id));
		
		if(registroDePonto == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Este registro de ponto não existe");
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(registroDePonto);
		
	}
	
	@PostMapping
	public ResponseEntity create(@RequestBody CreateRegistroPontoDTO data, UriComponentsBuilder uriBuilder) {
		
		Funcionario funcionario = funcionarioRepository.getReferenceById(data.funcionario().getId());
		
		if( funcionario == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Funcionário não existe");
		}
		
		Empresa empresa = empresaRepository.getReferenceById(funcionario.getEmpresa().getId());

		if(!empresa.getSsid().equals(data.ssidAtual())) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Funcionário não está conectado na rede wi-fi da empresa");
		}
		
		RegistroDePonto registroDePontoCreated = registroRepository.save(new RegistroDePonto(data));
		
		registroDePontoCreated.setFuncionario(funcionario);
		
		DetailRegistroDePontoDTO registroDePonto = new DetailRegistroDePontoDTO(registroDePontoCreated);
		
		var uri = uriBuilder.path("/registro-ponto/{id}").buildAndExpand(registroDePonto.id()).toUri();

		return ResponseEntity.created(uri).body(registroDePonto);
		
	}

}
