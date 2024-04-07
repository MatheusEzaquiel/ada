package com.ada.api.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.ada.api.domain.administrador.dto.DetailAdministradorDTO;
import com.ada.api.repository.EmpresaRepository;
import com.ada.api.service.AdministradorService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import com.ada.api.domain.administrador.Administrador;
import com.ada.api.repository.AdministradorRepository;
import com.ada.api.domain.administrador.dto.CreateAdministradorDTO;
import com.ada.api.domain.administrador.dto.ListAdministradorDTO;
import com.ada.api.domain.administrador.dto.UpdateAdministradorDTO;
import com.ada.api.service.ImageService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/administradores")
public class AdministradorController {

	@Autowired
	AdministradorRepository adminRepos;
	@Autowired
	AdministradorService adminService;

	@Autowired
	EmpresaRepository empresaRepos;
	
	@Autowired
	ImageService imageService;


	@GetMapping
	public ResponseEntity<List<ListAdministradorDTO>> list() {
		List<ListAdministradorDTO> admins = adminService.list();
		return ResponseEntity.status(HttpStatus.OK).body(admins);
	}

	@GetMapping("/enabled")
	public ResponseEntity<List<ListAdministradorDTO>> listEnabled() {
		List<ListAdministradorDTO> admins = adminService.listEnabled();
		return ResponseEntity.status(HttpStatus.OK).body(admins);
	}

	@GetMapping("/{id}")
	public ResponseEntity<DetailAdministradorDTO> detail(@PathVariable UUID id) {
		DetailAdministradorDTO admin = adminService.detail(id);
		return ResponseEntity.ok().body(admin);
	}
	
	@PostMapping
	public ResponseEntity<Administrador> create(@ModelAttribute CreateAdministradorDTO data, @RequestParam("foto") MultipartFile foto,
						 @RequestParam("empresa.id") UUID empresaId, UriComponentsBuilder uriBuilder) {
		Administrador admin = adminService.save(data, foto, empresaId);
		URI uri = uriBuilder.path("/administradores/{id}").buildAndExpand(admin.getId()).toUri();

		return ResponseEntity.created(uri).body(admin);
	}

	@PutMapping("/{id}")
	public ResponseEntity<DetailAdministradorDTO> update(@PathVariable UUID id, @RequestBody UpdateAdministradorDTO data) {
		DetailAdministradorDTO admin = adminService.update(id, data);
		return ResponseEntity.ok().body(admin);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<DetailAdministradorDTO> delete(@PathVariable UUID id) {
		DetailAdministradorDTO admin = adminService.delete(id);
		return ResponseEntity.status(HttpStatus.OK).body(admin);
	}

}
