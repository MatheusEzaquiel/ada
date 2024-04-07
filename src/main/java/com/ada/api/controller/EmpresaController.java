package com.ada.api.controller;

import java.net.URI;
import java.util.List;
import java.util.UUID;

import com.ada.api.domain.empresa.dto.CreateEmpresaDTO;
import com.ada.api.domain.empresa.dto.DetailEmpresaDTO;
import com.ada.api.domain.empresa.dto.ListEmpresaDTO;
import com.ada.api.domain.empresa.dto.UpdateEmpresaDTO;
import com.ada.api.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {
	
	@Autowired
	EmpresaService empresaService;


	@GetMapping
	public ResponseEntity<List<ListEmpresaDTO>> list() {
		List<ListEmpresaDTO> empresas = empresaService.list();
		return ResponseEntity.status(HttpStatus.OK).body(empresas);
	}

	@GetMapping("/enabled")
	public ResponseEntity<List<ListEmpresaDTO>> listEnabled() {
		List<ListEmpresaDTO> admins = empresaService.listEnabled();
		return ResponseEntity.status(HttpStatus.OK).body(admins);
	}

	@GetMapping("/{id}")
	public ResponseEntity<DetailEmpresaDTO> detail(@PathVariable UUID id) {
		DetailEmpresaDTO empresa = empresaService.detail(id);
		return ResponseEntity.ok().body(empresa);
	}

	@PostMapping
	public ResponseEntity<DetailEmpresaDTO> create(@ModelAttribute CreateEmpresaDTO data, UriComponentsBuilder uriBuilder) {
		DetailEmpresaDTO empresa = empresaService.create(data);
		URI uri = uriBuilder.path("/empresas/{id}").buildAndExpand(empresa.id()).toUri();

		return ResponseEntity.created(uri).body(empresa);
	}

	@PutMapping("/{id}")
	public ResponseEntity<DetailEmpresaDTO> update(@PathVariable UUID id, @RequestBody UpdateEmpresaDTO data) {
		DetailEmpresaDTO empresa = empresaService.update(id, data);
		return ResponseEntity.ok().body(empresa);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<DetailEmpresaDTO> delete(@PathVariable UUID id) {
		DetailEmpresaDTO empresa = empresaService.delete(id);
		return ResponseEntity.status(HttpStatus.OK).body(empresa);
	}

}
