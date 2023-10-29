package com.ada.api.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
	AdministradorRepository adminRepos;
	
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
	public ResponseEntity create(@ModelAttribute CreateAdministradorDTO data, @RequestParam("foto") MultipartFile foto,
            @RequestParam("empresa.id") Long empresaId, UriComponentsBuilder uriBuilder) {

		try {
			
			String encryptedPassword = new BCryptPasswordEncoder().encode(data.senha());

			Empresa empresa = new Empresa();
			empresa.setId(empresaId);
			
			empresa = empresaRepos.getReferenceById(empresaId);
			
			
			String dominioEmpresa = empresa.getDominio();
			
			
			String imagem = imageService.saveImage(foto, "admin");
			
			Administrador admin = new Administrador(data, encryptedPassword, imagem, empresa);
			
			
			admin.setLogin(admin.getLogin() + dominioEmpresa);
			
			Administrador adminCreated = adminRepos.save(admin);
			
			ListAdministradorDTO adminDTO = new ListAdministradorDTO(adminCreated, imageService.getImage(adminCreated.getFoto(), "admin"));
			
			URI uri = uriBuilder.path("/administradores/{id}").buildAndExpand(adminDTO.id()).toUri();
			
			return ResponseEntity.created(uri).body(adminDTO);

		} catch (Exception e) {
			
			System.out.println(e.getMessage());
			return ResponseEntity.internalServerError().body("Erro:" + e.getMessage());
			
		}

	}


	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity update(@RequestBody UpdateAdministradorDTO data, @PathVariable UUID id) {

		try {

			Administrador admin = adminRepos.getReferenceById(id);
			
			if (admin == null) return ResponseEntity.badRequest().body("Erro: Não existe um administrador com este ID");

			admin.update(data);

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
