package com.ada.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ada.api.domain.funcionario.CreateFuncionarioDTO;
import com.ada.api.domain.funcionario.Funcionario;
import com.ada.api.domain.funcionario.FuncionarioRepository;


@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioRepository repository;

	@GetMapping
	public String list() {
		return "funcionarios";
	}
	
	@PostMapping
	public Funcionario create(@RequestBody CreateFuncionarioDTO data) {
		
		Funcionario funcionario = new Funcionario(data);
		
		repository.save(funcionario);
		
		return funcionario;
		
	}
	
}
