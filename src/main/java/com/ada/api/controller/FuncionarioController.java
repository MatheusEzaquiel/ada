package com.ada.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ada.api.domain.funcionario.CreateFuncionarioDTO;
import com.ada.api.domain.funcionario.Funcionario;
import com.ada.api.domain.funcionario.FuncionarioRepository;
import com.ada.api.domain.funcionario.ListFuncionarioDTO;


@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioRepository repository;

	@GetMapping
	public ResponseEntity<Page<ListFuncionarioDTO>> list(@PageableDefault(size=10) Pageable paginacao) {
		
		var page = repository.findAll(paginacao).map(ListFuncionarioDTO::new);
		
		return ResponseEntity.ok(page);
		
	}
	
	@PostMapping
	public ResponseEntity create(@RequestBody CreateFuncionarioDTO data) {
		
		Funcionario funcionario = new Funcionario(data);
		
		repository.save(funcionario);
		
		return ResponseEntity.ok(null);
		
	}
	
}
