package com.ada.api.repository;

import java.util.List;
import java.util.UUID;

import com.ada.api.domain.funcionario.Funcionario;
import com.ada.api.domain.funcionario.dto.DetailFuncionarioDTO;
import com.ada.api.domain.funcionario.dto.ListFuncionarioDTO;
import com.ada.api.domain.funcionario.dto.ReportFuncionarioDTO;
import com.ada.api.domain.person.Person;
import com.ada.api.domain.registroDePonto.dto.ReportRegistroDePontoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
//import org.springframework.security.core.userdetails.UserDetails;

import com.ada.api.domain.registroDePonto.dto.ReportRegistroDePontoDTO;

public interface FuncionarioRepository extends JpaRepository<Funcionario, UUID>{

	
	@Query("SELECT new com.ada.api.domain.funcionario.dto.ListFuncionarioDTO" +
		       "(f.id, f.login, f.apelido, f.nomeCompleto, " +
		       "f.foto, f.cargaHorariaDiaria, f.cargaHorariaMensal, " +
		       "f.horarioEntrada, f.horarioIntervaloEntrada, f.horarioIntervaloSaida, f.horarioSaida, " +
		       "f.quantidadeFaltas, f.quantidadeFaltasJustificadas, f.quantidadeHorasExtras, " +
		       "new com.ada.api.domain.empresa.dto.EmpresaDTO(f.empresa.id, f.empresa.nome)," +
		       "new com.ada.api.domain.cargo.dto.CargoDTO(f.cargo.id, f.cargo.area)) " +
		       "FROM Funcionario f INNER JOIN f.empresa INNER JOIN f.cargo")
	Page<ListFuncionarioDTO> listAllFuncionarios(Pageable pageable);

	

	@Query("SELECT new com.ada.api.domain.funcionario.dto.DetailFuncionarioDTO" +
	        "(f.id, f.cpf, f.login, f.apelido, f.nomeCompleto, f.dataNascimento, f.email, " +
	        "f.telefone, f.senha, f.foto, f.cargaHorariaDiaria, f.cargaHorariaMensal, " +
	        "f.horarioEntrada, f.horarioIntervaloEntrada, f.horarioIntervaloSaida, " +
	        "f.horarioSaida, f.horarioFolgaEntrada, f.horarioFolgaSaida, f.diaFolga, " +
	        "f.quantidadeFaltas, f.quantidadeFaltasJustificadas, f.quantidadeHorasExtras, f.ativo," +
	        "new com.ada.api.domain.empresa.dto.EmpresaDTO(f.empresa.id, f.empresa.nome)," +
	        "new com.ada.api.domain.cargo.dto.CargoDTO(f.cargo.id, f.cargo.area)) " +
	        "FROM Funcionario f INNER JOIN f.empresa INNER JOIN f.cargo " +
	        "WHERE f.id = :funcionarioId"
	        )
	DetailFuncionarioDTO listFuncionarioJoinEmpresa(@Param("funcionarioId") UUID funcionarioId);

	
	@Query("SELECT new com.ada.api.domain.funcionario.dto.ReportFuncionarioDTO(f.id, f.cpf, f.login, f.nomeCompleto,"
			+ " f.cargaHorariaDiaria, f.cargaHorariaMensal,"
			+ " f.horarioEntrada, f.horarioIntervaloEntrada, f.horarioIntervaloSaida, f.horarioSaida,"
			+ " f.quantidadeFaltas, f.quantidadeFaltasJustificadas, f.quantidadeHorasExtras, f.ativo,"
			+ " new com.ada.api.domain.empresa.dto.ReportEmpresaDTO(f.empresa.id, f.empresa.cnpj, f.empresa.nome),"
	        + " new com.ada.api.domain.cargo.dto.ReportCargoDTO(f.cargo.id, f.cargo.area))"
	        + " FROM Funcionario f"
	        + " INNER JOIN f.empresa"
	        + " INNER JOIN f.cargo"
			+ " WHERE f.id = :funcionarioId"
			)
	ReportFuncionarioDTO reportFuncionarioById(@Param("funcionarioId") UUID funcionarioId);
	
	@Query("SELECT new com.ada.api.domain.registroDePonto.dto.ReportRegistroDePontoDTO("
			+ "rp.id, rp.data, rp.horarioEntrada, rp.horarioIntervaloEntrada, rp.horarioIntervaloSaida, rp.horarioSaida)"
	        + " FROM RegistroDePonto rp WHERE rp.funcionario.id = :funcionarioId")
	List<ReportRegistroDePontoDTO> getRegistrosDePonto(@Param("funcionarioId") UUID funcionarioId);

	//UserDetails findByLogin(String login);
	Person findByLogin(String login);

	Funcionario getReferenceById(UUID id);
}
