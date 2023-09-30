package com.ada.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ada.api.domain.administrador.AdministradorRepository;
import com.ada.api.domain.administrador.ListAdministradorDTO;

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
	
}
