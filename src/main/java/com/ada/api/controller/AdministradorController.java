package com.ada.api.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.ada.api.repository.EmpresaRepository;
import com.ada.api.service.AdministradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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
	public ResponseEntity list() {

		try {
			
			List<ListAdministradorDTO> admins = adminRepos.findAll()
					.stream()
					.map(admin -> new ListAdministradorDTO(admin, imageService.getImage(admin.getFoto(), "admin")))
					.toList();
			

			return ResponseEntity.ok(admins);

		} catch (Exception e) {

			System.out.println(e);

			return ResponseEntity.badRequest().build();
		}

	}
	
	@PostMapping
	public ResponseEntity<Administrador> create(@ModelAttribute CreateAdministradorDTO data, @RequestParam("foto") MultipartFile foto,
						 @RequestParam("empresa.id") UUID empresaId, UriComponentsBuilder uriBuilder) {

		Administrador admin = adminService.save(data, foto, empresaId);
		URI uri = uriBuilder.path("/administradores/{id}").buildAndExpand(admin.getId()).toUri();

		return ResponseEntity.created(uri).body(admin);

	}


	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity update(@RequestBody UpdateAdministradorDTO data, @PathVariable UUID id) {

		try {

			Administrador admin = adminRepos.getReferenceById(id);
			
			if (admin == null) return ResponseEntity.badRequest().body("Erro: Não existe um administrador com este ID");

			//admin.update(data);

			ListAdministradorDTO adminDTO = new ListAdministradorDTO(admin);

			return ResponseEntity.ok().body(adminDTO);

		} catch (Exception e) {

			System.out.println(e);

			return ResponseEntity.badRequest().build();
		}

	}
	
	@GetMapping("/{id}")
	public ResponseEntity detail(@PathVariable UUID id) {

		try {

			Optional<Administrador> adminOptional = adminRepos.findById(id);
			
			if(adminOptional == null) {
				return ResponseEntity.notFound().build();
			}
			
			String linkFoto = imageService.getImage(adminOptional.get().getFoto(), "admin");
			
			ListAdministradorDTO adminDTO = new ListAdministradorDTO(adminOptional.get(), linkFoto);
			
			return ResponseEntity.ok().body(adminDTO);

		} catch (Exception e) {

			return ResponseEntity.badRequest().build();

		}

	}

}
