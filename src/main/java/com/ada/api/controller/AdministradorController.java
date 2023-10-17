package com.ada.api.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
import com.ada.api.domain.administrador.AdministradorRepository;
import com.ada.api.domain.administrador.CreateAdministradorDTO;
import com.ada.api.domain.administrador.ListAdministradorDTO;
import com.ada.api.domain.administrador.UpdateAdministradorDTO;
import com.ada.api.domain.empresa.Empresa;
import com.ada.api.domain.empresa.EmpresaRepository;
import com.ada.api.service.imagem.ImageService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/administradores")
public class AdministradorController {

	@Autowired
	AdministradorRepository repository;
	
	@Autowired
	EmpresaRepository empresaRepository;
	
	@Autowired
	ImageService imageService;


	@GetMapping
	public ResponseEntity list() {

		try {
			
			List<ListAdministradorDTO> admins = repository.findAll()
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
	public ResponseEntity create(@ModelAttribute CreateAdministradorDTO data, @RequestParam("foto") MultipartFile foto,
            @RequestParam("empresa.id") Long empresaId, UriComponentsBuilder uriBuilder) {

		try {

			Empresa empresa = new Empresa();
			empresa.setId(empresaId);
			
			empresa = empresaRepository.getReferenceById(empresaId);
			
			String dominioEmpresa = empresa.getDominio();
			
			
			String imagem = imageService.saveImage(foto, "admin");
			
			Administrador admin = new Administrador(data, imagem, empresa);
			
			
			admin.setLogin(admin.getLogin() + dominioEmpresa);
			
			repository.save(admin);
			
			
			Administrador adminQuery = repository.getReferenceById(admin.getId());
			
			System.out.println(adminQuery.getEmpresa().getId());
			
			ListAdministradorDTO adminDTO = new ListAdministradorDTO(adminQuery, imageService.getImage(adminQuery.getFoto(), "admin"));
			
			URI uri = uriBuilder.path("/administradores/{id}").buildAndExpand(adminDTO.id()).toUri();

			return ResponseEntity.created(uri).body(adminDTO);

		} catch (Exception e) {
			
			System.out.println(e.getMessage());
			return ResponseEntity.internalServerError().body("erro");
			
		}

	}


	@PutMapping
	@Transactional
	public ResponseEntity update(@RequestBody UpdateAdministradorDTO data) {

		try {

			if (!repository.existsById(data.id())) return ResponseEntity.badRequest().body("Erro: Não existe um administrador com este ID");

			Administrador admin = repository.getReferenceById(data.id());

			admin.update(data);

			ListAdministradorDTO adminDTO = new ListAdministradorDTO(admin);

			return ResponseEntity.ok().body(adminDTO);

		} catch (Exception e) {

			System.out.println(e);

			return ResponseEntity.badRequest().build();
		}

	}
	
	@GetMapping("/{id}")
	public ResponseEntity detail(@PathVariable Long id) {

		try {

			Optional<Administrador> adminOptional = repository.findById(id);
			
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
