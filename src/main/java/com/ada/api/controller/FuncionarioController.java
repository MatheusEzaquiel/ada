package com.ada.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.ada.api.domain.empresa.EmpresaRepository;
import com.ada.api.domain.funcionario.BasicUpdateFuncionarioDTO;
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
	private FuncionarioRepository funcionarioRepository;

	@Autowired
	private EmpresaRepository empresaRepository;
	
	@GetMapping
	public ResponseEntity list( Pageable pageable) {

		try {
			
			Page<ListFuncionarioDTO> funcionarios = funcionarioRepository.listAllFuncionarios(pageable);

			return ResponseEntity.ok(funcionarios);

		} catch (Exception e) {

			System.out.println(e.getMessage());
			
			return ResponseEntity.notFound().build();

		}

	}

	@GetMapping("/{funcionarioId}")
	public ResponseEntity detail(@PathVariable Long funcionarioId) {
		
		try {

			DetailFuncionarioDTO funcionarioDTO = funcionarioRepository.listFuncionarioJoinEmpresa(funcionarioId);

			if (funcionarioDTO != null) {

				return ResponseEntity.ok(funcionarioDTO);

			} else {

				return ResponseEntity.notFound().build();
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return ResponseEntity.internalServerError().body("Erro ao buscar o funcionário");
		}
		
	}

	@PostMapping
	public ResponseEntity create(@RequestBody @Valid CreateFuncionarioDTO data, UriComponentsBuilder uriBuilder) {

		try {

			boolean empresaOptional = empresaRepository.existsById((long) data.empresa().getId());

			if (empresaOptional != true) {

				return ResponseEntity.notFound().build().ok("A empresa não está cadastrada ou não existe");

			}

			Funcionario funcionario = new Funcionario(data);
			
			funcionarioRepository.save(funcionario);

			DetailFuncionarioDTO detailFuncionarioDTO = funcionarioRepository
					.listFuncionarioJoinEmpresa(funcionario.getId());

			var uri = uriBuilder.path("/funcionarios/{id}").buildAndExpand(funcionario.getId()).toUri();

			return ResponseEntity.created(uri).body(detailFuncionarioDTO);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return ResponseEntity.internalServerError().body("erro");
		}

	}

	@PutMapping
	@Transactional
	public ResponseEntity update(@RequestBody UpdateFuncionarioDTO data) {

		try {
			
			boolean funcionarioExiste = funcionarioRepository.existsById(data.id());
			
			if(funcionarioExiste != false) {
				
				Funcionario funcionario = funcionarioRepository.getReferenceById(data.id());
				
				funcionario.updateByAdmin(data);

				DetailFuncionarioDTO detailFuncionarioDTO = funcionarioRepository.listFuncionarioJoinEmpresa(funcionario.getId());

				return ResponseEntity.ok(detailFuncionarioDTO);
				
			}
			
			return ResponseEntity.internalServerError().body("Usuário não encontrado");

		} catch (Exception e) {
			
			System.out.println(e.getMessage());
			
			return ResponseEntity.internalServerError().body("Erro ao atualizar dados do usuário");
			
		}

	}
	
	@PutMapping("/profile/basic-data")
	public ResponseEntity basicUpdate(@RequestBody BasicUpdateFuncionarioDTO data) {

		try {
			
			boolean funcionarioExiste = funcionarioRepository.existsById(data.id());
			
			if(funcionarioExiste != false) {
				
				Funcionario funcionario = funcionarioRepository.getReferenceById(data.id());
				
				funcionario.update(data);

				DetailFuncionarioDTO detailFuncionarioDTO = funcionarioRepository.listFuncionarioJoinEmpresa(funcionario.getId());

				return ResponseEntity.ok(detailFuncionarioDTO);
				
			}
			
			return ResponseEntity.internalServerError().body("Usuário não encontrado");

		} catch (Exception e) {
			
			System.out.println(e.getMessage());
			
			return ResponseEntity.internalServerError().body("Erro ao atualizar dados do usuário");
			
		}

	}

	@PutMapping("/ativar/{id}")
	@Transactional
	public ResponseEntity toAvailable(@PathVariable Long id) {

		Funcionario funcionario = funcionarioRepository.getReferenceById(id);
		funcionario.toAvailable();

		DetailFuncionarioDTO detailFuncionarioDTO = funcionarioRepository.listFuncionarioJoinEmpresa(funcionario.getId());

		return ResponseEntity.ok(detailFuncionarioDTO);

	}

	@DeleteMapping("/desativar/{id}")
	@Transactional
	public ResponseEntity toUnavailable(@PathVariable Long id) {

		Funcionario funcionario = funcionarioRepository.getReferenceById(id);
		funcionario.toUnavailable();

		DetailFuncionarioDTO detailFuncionarioDTO = funcionarioRepository.listFuncionarioJoinEmpresa(funcionario.getId());

		return ResponseEntity.ok(detailFuncionarioDTO);
		
	}

}
