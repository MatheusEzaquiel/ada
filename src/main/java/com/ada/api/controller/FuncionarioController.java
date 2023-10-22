package com.ada.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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

import com.ada.api.domain.cargo.Cargo;
import com.ada.api.domain.cargo.CargoRepository;
import com.ada.api.domain.empresa.Empresa;
import com.ada.api.domain.empresa.EmpresaRepository;
import com.ada.api.domain.funcionario.BasicUpdateFuncionarioDTO;
import com.ada.api.domain.funcionario.CreateFuncionarioDTO;
import com.ada.api.domain.funcionario.DetailFuncionarioDTO;
import com.ada.api.domain.funcionario.Funcionario;
import com.ada.api.domain.funcionario.FuncionarioRepository;
import com.ada.api.domain.funcionario.ListFuncionarioDTO;
import com.ada.api.domain.funcionario.ReportFuncionarioDTO;
import com.ada.api.domain.funcionario.ReportOneFuncionarioDTO;
import com.ada.api.domain.funcionario.UpdateFuncionarioDTO;
import com.ada.api.domain.registroDePonto.RegistroDePontoRepository;
import com.ada.api.domain.registroDePonto.ReportRegistroDePontoDTO;
import com.ada.api.service.imagem.ImageService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@Autowired
	private EmpresaRepository empresaRepository;

	@Autowired
	private ImageService imageService;
	
	@Autowired
	private CargoRepository cargoRepository;
	
	@Autowired
	private RegistroDePontoRepository registroRepository;

	@GetMapping
	public ResponseEntity list(Pageable pageable) {

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
	public ResponseEntity create(
			
			@ModelAttribute CreateFuncionarioDTO data,
			@RequestParam("foto") MultipartFile foto,
			@RequestParam("empresa.id") Long empresaId,
			@RequestParam("cargo.id") Long cargoId,
			UriComponentsBuilder uriBuilder) {

		try {

			Empresa empresa = empresaRepository.getReferenceById(empresaId);
			Cargo cargo = cargoRepository.getReferenceById(cargoId);
			
			if (empresa == null) {
				return ResponseEntity.notFound().build().ok("A empresa não está cadastrada ou não existe");
			}
			
			if (cargo == null) {
				return ResponseEntity.notFound().build().ok("O cargo mencionado não existe nesta empresa");
			}
			
			System.out.println(empresa.getNome());
			System.out.println(cargo.getArea());
			
			String dominioEmpresa = empresa.getDominio();
	
			Funcionario funcionario = new Funcionario(data, cargo, empresa);
			

			String newNameImage = imageService.saveImage(foto, "funcionario");

			funcionario.setLogin(funcionario.getLogin() + dominioEmpresa);
			funcionario.setFoto(newNameImage);
			
			
			String pathImageSaved = imageService.getImage(newNameImage, "funcionario");
			
			DetailFuncionarioDTO funcionarioCreated = new DetailFuncionarioDTO(funcionarioRepository.save(funcionario), pathImageSaved);
	
			
			var uri = uriBuilder.path("/funcionarios/{id}").buildAndExpand(funcionario.getId()).toUri();

			return ResponseEntity.created(uri).body(funcionarioCreated);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return ResponseEntity.internalServerError().body("Erro");
		}

	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity update(@RequestBody UpdateFuncionarioDTO data, @PathVariable Long id) {

		try {

			boolean funcionarioExiste = funcionarioRepository.existsById(id);

			if (funcionarioExiste != false) {

				Funcionario funcionario = funcionarioRepository.getReferenceById(id);
				
				Cargo novoCargo = null;
				
				if (data.cargo() != null) {
					System.out.println(data.cargo().id());
					novoCargo = cargoRepository.getReferenceById(data.cargo().id());
				}
				
				funcionario.updateByAdmin(data, novoCargo);

				DetailFuncionarioDTO detailFuncionarioDTO = funcionarioRepository
						.listFuncionarioJoinEmpresa(funcionario.getId());

				return ResponseEntity.ok(detailFuncionarioDTO);

			}

			return ResponseEntity.internalServerError().body("Usuário não encontrado");

		} catch (Exception e) {

			System.out.println(e.getMessage());

			return ResponseEntity.internalServerError().body("Erro ao atualizar dados do usuário");

		}

	}

	@PutMapping("/profile/basic-data/{id}")
	@Transactional
	public ResponseEntity basicUpdate(@RequestBody BasicUpdateFuncionarioDTO data, @PathVariable Long id) {

		try {

			boolean funcionarioExiste = funcionarioRepository.existsById(id);

			if (funcionarioExiste != false) {

				Funcionario funcionario = funcionarioRepository.getReferenceById(id);

				funcionario.update(data);

				DetailFuncionarioDTO detailFuncionarioDTO = funcionarioRepository
						.listFuncionarioJoinEmpresa(funcionario.getId());

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

		DetailFuncionarioDTO detailFuncionarioDTO = funcionarioRepository
				.listFuncionarioJoinEmpresa(funcionario.getId());

		return ResponseEntity.ok(detailFuncionarioDTO);

	}

	@DeleteMapping("/desativar/{id}")
	@Transactional
	public ResponseEntity toUnavailable(@PathVariable Long id) {

		Funcionario funcionario = funcionarioRepository.getReferenceById(id);
		funcionario.toUnavailable();

		DetailFuncionarioDTO detailFuncionarioDTO = funcionarioRepository
				.listFuncionarioJoinEmpresa(funcionario.getId());

		return ResponseEntity.ok(detailFuncionarioDTO);

	}
	
	@GetMapping("/relatorios/{id}")
	public ResponseEntity report(@PathVariable Long id) {
		
		Funcionario funcionario = funcionarioRepository.getReferenceById(id);
		
		ReportFuncionarioDTO funcionarioReport = funcionarioRepository.reportFuncionarioById(id);
		
		List<ReportRegistroDePontoDTO> registrosDePonto = funcionarioRepository.getRegistrosDePonto(id);
		
		ReportOneFuncionarioDTO report = new ReportOneFuncionarioDTO(funcionarioReport, registrosDePonto);
		
		
		return ResponseEntity.status(HttpStatus.OK).body(report);
		
	}

}
