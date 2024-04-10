package com.ada.api.controller;

import java.net.URI;
import java.util.List;
import java.util.UUID;

import com.ada.api.domain.administrador.dto.DetailAdministradorDTO;
import com.ada.api.domain.funcionario.dto.*;
import com.ada.api.domain.registroDePonto.dto.ReportRegistroDePontoDTO;
import com.ada.api.repository.RegistroDePontoRepository;
import com.ada.api.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import com.ada.api.domain.cargo.Cargo;
import com.ada.api.repository.CargoRepository;
import com.ada.api.domain.empresa.Empresa;
import com.ada.api.repository.EmpresaRepository;


import com.ada.api.domain.funcionario.Funcionario;
import com.ada.api.repository.FuncionarioRepository;

import com.ada.api.service.ImageService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

	@Autowired
	FuncionarioService funcionarioService;


	@GetMapping
	public ResponseEntity<Page<ListFuncionarioDTO>> list(Pageable pageable) {
		Page<ListFuncionarioDTO> funcionarios = funcionarioService.list(pageable);
		return ResponseEntity.ok(funcionarios);
	}

	@GetMapping("/enabled")
	public ResponseEntity<Page<ListFuncionarioDTO>> listEnabled(Pageable pageable) {
		Page<ListFuncionarioDTO> funcionarios = funcionarioService.listEnabled(	pageable);
		return ResponseEntity.ok(funcionarios);
	}

	@GetMapping("/{id}")
	public ResponseEntity<DetailFuncionarioDTO> detail(@PathVariable UUID id) {
		DetailFuncionarioDTO funcionarioDTO = funcionarioService.detail(id);
		return ResponseEntity.status(HttpStatus.CREATED).body(funcionarioDTO);
	}

	@PostMapping
	public ResponseEntity<DetailFuncionarioDTO> create(

			@ModelAttribute CreateFuncionarioDTO data,
			@RequestParam("foto") MultipartFile foto,
			@RequestParam("empresaId") UUID empresaId,
			@RequestParam("cargoId") UUID cargoId,
			UriComponentsBuilder uriBuilder) {

		DetailFuncionarioDTO funcionarioDTO = funcionarioService.create(data, foto, empresaId, cargoId);

		URI uri = uriBuilder.path("/funcionarios/{id}").buildAndExpand(funcionarioDTO.id()).toUri();

		return ResponseEntity.created(uri).body(funcionarioDTO);

	}

	@PutMapping("/{id}")
	public ResponseEntity<DetailFuncionarioDTO> update(@ModelAttribute UpdateFuncionarioDTO data,
			@RequestParam(value = "foto", required = false) MultipartFile foto,
			@RequestParam(value = "empresaId", required= false) UUID empresaId,
			@RequestParam(value = "cargoId", required = false) UUID cargoId,
			@PathVariable UUID id) {
		DetailFuncionarioDTO funcionarioDTO = funcionarioService.update(id, data, foto, empresaId, cargoId);
		return ResponseEntity.status(HttpStatus.OK).body(funcionarioDTO);
	}


	@PatchMapping("/basic-data/{id}")
	public ResponseEntity<DetailFuncionarioDTO> basicUpdate(
			@PathVariable UUID id,
			@ModelAttribute BasicUpdateFuncionarioDTO data,
			@RequestParam(value = "foto", required = false) MultipartFile foto
	) {
		DetailFuncionarioDTO funcionarioDTO = funcionarioService.basicUpdate(id, data, foto);
		return ResponseEntity.status(HttpStatus.OK).body(funcionarioDTO);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<DetailFuncionarioDTO> delete(@PathVariable UUID id) {
		DetailFuncionarioDTO funcionarioDTO = funcionarioService.delete(id);
		return ResponseEntity.status(HttpStatus.OK).body(funcionarioDTO);
	}

/*
	@GetMapping("/relatorios/{id}")
	public ResponseEntity report(@PathVariable UUID id) {

		Funcionario funcionario = funcionarioRepository.getReferenceById(id);

		ReportFuncionarioDTO funcionarioReport = funcionarioRepository.reportFuncionarioById(id);

		List<ReportRegistroDePontoDTO> registrosDePonto = funcionarioRepository.getRegistrosDePonto(id);

		ReportOneFuncionarioDTO report = new ReportOneFuncionarioDTO(funcionarioReport, registrosDePonto);


		return ResponseEntity.status(HttpStatus.OK).body(report);

	}
*/
}
