package com.ada.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ada.api.domain.empresa.Empresa;
import com.ada.api.repository.EmpresaRepository;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {
	
	@Autowired
	EmpresaRepository empresaRepos;
	
	@GetMapping
	public List<Empresa> list() {
		
		List<Empresa> empresas = empresaRepos.findAll();
		return empresas;
		
	}

}
