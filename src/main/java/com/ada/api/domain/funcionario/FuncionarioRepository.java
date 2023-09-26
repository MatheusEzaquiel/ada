package com.ada.api.domain.funcionario;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{
	
	@Query("SELECT new com.ada.api.domain.funcionario.DetailFuncionarioDTO" +
	        "(f.id, f.cpf, f.login, f.apelido, f.nomeCompleto, f.dataNascimento, f.email, " +
	        "f.telefone, f.senha, f.foto, f.cargaHorariaDiaria, f.cargaHorariaMensal, " +
	        "f.horarioEntrada, f.horarioIntervaloEntrada, f.horarioIntervaloSaida, " +
	        "f.horarioSaida, f.horarioFolgaEntrada, f.horarioFolgaSaida, f.diaFolga, " +
	        "f.quantidadeFaltas, f.quantidadeFaltasJustificadas, f.quantidadeHorasExtras, " +
	        "f.ativo, f.empresa.id AS idEmpresa, f.empresa.nome AS nomeEmpresa, f.idCargo) " +
	        "FROM Funcionario f " +
	        "WHERE f.id = :funcionarioId")
	DetailFuncionarioDTO listFuncionarioJoinEmpresa(@Param("funcionarioId") Long funcionarioId);
	
	
	@Query("SELECT new com.ada.api.domain.funcionario.DetailFuncionarioDTO" +
	        "(f.id, f.cpf, f.login, f.apelido, f.nomeCompleto, f.dataNascimento, f.email, " +
	        "f.telefone, f.senha, f.foto, f.cargaHorariaDiaria, f.cargaHorariaMensal, " +
	        "f.horarioEntrada, f.horarioIntervaloEntrada, f.horarioIntervaloSaida, " +
	        "f.horarioSaida, f.horarioFolgaEntrada, f.horarioFolgaSaida, f.diaFolga, " +
	        "f.quantidadeFaltas, f.quantidadeFaltasJustificadas, f.quantidadeHorasExtras, " +
	        "f.ativo, f.empresa.id AS idEmpresa, f.empresa.nome AS nomeEmpresa, f.idCargo) " +
	        "FROM Funcionario f INNER JOIN f.empresa.id"
	        )
	List<DetailFuncionarioDTO>listFuncionariosJoinEmpresa(@Param("funcionarioId") Long funcionarioId);

	
	@Query("SELECT new com.ada.api.domain.funcionario.ListFuncionarioDTO" +
	        "(f.id, f.login, f.apelido, f.nomeCompleto, " +
	        "f.foto, f.cargaHorariaDiaria, f.cargaHorariaMensal, " +
	        "f.horarioEntrada, f.horarioIntervaloEntrada, f.horarioIntervaloSaida, f.horarioSaida, " +
	        "f.quantidadeFaltas, f.quantidadeFaltasJustificadas, f.quantidadeHorasExtras, " +
	        "f.empresa.id AS idEmpresa, f.empresa.nome AS nomeEmpresa, f.idCargo) " +
	        "FROM Funcionario f INNER JOIN f.empresa"
	        )
	List<ListFuncionarioDTO>listAllFuncionarios();

}
