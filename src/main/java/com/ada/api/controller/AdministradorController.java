package com.ada.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ada.api.domain.administrador.Administrador;
import com.ada.api.domain.administrador.AdministradorRepository;
import com.ada.api.domain.administrador.ListAdministradorDTO;
import com.ada.api.domain.administrador.UpdateAdministradorDTO;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/administradores")
public class AdministradorController {

	@Autowired
	AdministradorRepository repository;

	@GetMapping
	public ResponseEntity list() {

		try {

			List<ListAdministradorDTO> admins = repository.findAll().stream().map(ListAdministradorDTO::new).toList();

			System.out.println(admins);
			return ResponseEntity.ok(admins);

		} catch (Exception e) {

			System.out.println(e);

			return ResponseEntity.badRequest().build();
		}

	}
	
	@GetMapping("/{id}")
	public ResponseEntity listById(@PathVariable Long id) {

		try {

			Optional<Administrador> adminOptional = repository.findById(id);
			
			if(adminOptional == null) {
				return ResponseEntity.notFound().build();
			}
			
			ListAdministradorDTO adminDTO = new ListAdministradorDTO(adminOptional.get());
			
			return ResponseEntity.ok().body(adminDTO);

		} catch (Exception e) {

			return ResponseEntity.badRequest().build();

		}

	}

}