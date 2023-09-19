package com.ada.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

	@GetMapping
	public String list() {
		return "funcionarios";
	}
	
	@PostMapping
	public String create() {
		return "Criado";
	}
	
}
