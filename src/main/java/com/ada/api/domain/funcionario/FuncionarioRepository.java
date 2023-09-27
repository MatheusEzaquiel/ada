package com.ada.api.domain.funcionario;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{

	
	@Query("SELECT new com.ada.api.domain.funcionario.ListFuncionarioDTO" +
	        "(f.id, f.login, f.apelido, f.nomeCompleto, " +
	        "f.foto, f.cargaHorariaDiaria, f.cargaHorariaMensal, " +
	        "f.horarioEntrada, f.horarioIntervaloEntrada, f.horarioIntervaloSaida, f.horarioSaida, " +
	        "f.quantidadeFaltas, f.quantidadeFaltasJustificadas, f.quantidadeHorasExtras, " +
	        "new com.ada.api.domain.empresa.EmpresaDTO(f.empresa.id, f.empresa.nome)," +
	        "new com.ada.api.domain.cargo.CargoDTO(f.cargo.id, f.cargo.area)) " +
	        "FROM Funcionario f INNER JOIN f.empresa INNER JOIN f.cargo"
	        )
	List<ListFuncionarioDTO>listAllFuncionarios();
	
	
	@Query("SELECT new com.ada.api.domain.funcionario.DetailFuncionarioDTO" +
	        "(f.id, f.cpf, f.login, f.apelido, f.nomeCompleto, f.dataNascimento, f.email, " +
	        "f.telefone, f.senha, f.foto, f.cargaHorariaDiaria, f.cargaHorariaMensal, " +
	        "f.horarioEntrada, f.horarioIntervaloEntrada, f.horarioIntervaloSaida, " +
	        "f.horarioSaida, f.horarioFolgaEntrada, f.horarioFolgaSaida, f.diaFolga, " +
	        "f.quantidadeFaltas, f.quantidadeFaltasJustificadas, f.quantidadeHorasExtras, f.ativo," +
	        "new com.ada.api.domain.empresa.EmpresaDTO(f.empresa.id, f.empresa.nome)," +
	        "new com.ada.api.domain.cargo.CargoDTO(f.cargo.id, f.cargo.area)) " +
	        "FROM Funcionario f INNER JOIN f.empresa INNER JOIN f.cargo " +
	        "WHERE f.id = :funcionarioId"
	        )
	DetailFuncionarioDTO listFuncionarioJoinEmpresa(@Param("funcionarioId") Long funcionarioId);

}
