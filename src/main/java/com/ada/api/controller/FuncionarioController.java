package com.ada.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.ada.api.domain.funcionario.CreateFuncionarioDTO;
import com.ada.api.domain.funcionario.DetailFuncionarioDTO;
import com.ada.api.domain.funcionario.Funcionario;
import com.ada.api.domain.funcionario.FuncionarioRepository;
import com.ada.api.domain.funcionario.ListFuncionarioDTO;
import com.ada.api.domain.funcionario.UpdateFuncionarioDTO;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

	@Autowired
	private FuncionarioRepository repository;

	@GetMapping
	public ResponseEntity<Page<ListFuncionarioDTO>> list(@PageableDefault(size = 10) Pageable paginacao) {

		var page = repository.findAll(paginacao).map(ListFuncionarioDTO::new);

		return ResponseEntity.ok(page);

	}

	@GetMapping("/{id}")
	public ResponseEntity detail(@PathVariable Long id) {

		var funcionario = repository.getReferenceById(id);

		return ResponseEntity.ok(new DetailFuncionarioDTO(funcionario));

	}

	@PostMapping
	@Transactional
	public ResponseEntity create(@RequestBody @Valid CreateFuncionarioDTO data, UriComponentsBuilder uriBuilder) {

		Funcionario funcionario = new Funcionario(data);

		repository.save(funcionario);

		var uri = uriBuilder.path("/funcionarios/{id}").buildAndExpand(funcionario.getId()).toUri();

		return ResponseEntity.created(uri).body(new DetailFuncionarioDTO(funcionario));

	}

	@PutMapping
	@Transactional
	public ResponseEntity update(@RequestBody UpdateFuncionarioDTO data) {

		Funcionario funcionario = repository.getReferenceById(data.id());
		funcionario.updateByAdmin(data);

		return ResponseEntity.ok(new DetailFuncionarioDTO(funcionario));

	}
	
	@PutMapping("/ativar/{id}")
	@Transactional
	public ResponseEntity toAvailable(@PathVariable Long id) {

		Funcionario funcionario = repository.getReferenceById(id);
		funcionario.toAvailable();

		return ResponseEntity.ok(new DetailFuncionarioDTO(funcionario));

	}

	@PutMapping("/desativar/{id}")
	@Transactional
	public ResponseEntity toUnavailable(@PathVariable Long id) {

		Funcionario funcionario = repository.getReferenceById(id);
		funcionario.toUnavailable();

		return ResponseEntity.ok(new DetailFuncionarioDTO(funcionario));

	}

}
