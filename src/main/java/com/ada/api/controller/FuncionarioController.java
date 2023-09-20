package com.ada.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ada.api.domain.funcionario.CreateFuncionarioDTO;


@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

	@GetMapping
	public String list() {
		return "funcionarios";
	}
	
	@PostMapping
	public CreateFuncionarioDTO create(@RequestBody CreateFuncionarioDTO data) {
		return data;
	}
	
}
