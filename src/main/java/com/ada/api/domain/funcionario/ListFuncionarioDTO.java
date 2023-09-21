package com.ada.api.domain.funcionario;

import java.time.LocalDate;
import java.time.LocalTime;

public record ListFuncionarioDTO(
		
		Long id,
		String cpf,
		String login,
		String nomeCompleto,
		LocalDate dataNascimento,
		String email,
		String telefone,
		String senha,
		String foto,
		int cargaHorariaDiaria,
		int cargaHorariaMensal,
		LocalTime horarioEntrada,
		LocalTime horarioIntervaloEntrada,
		LocalTime horarioIntervaloSaida,
		LocalTime horarioSaida,
		LocalTime horarioFolgaEntrada,
		LocalTime horarioFolgaSaida,
		String diaFolga,
		int quantidadeFaltas,
		int quantidadeFaltasJustificadas,
		int quantidadeHorasExtras,
		boolean ativo,
		int idEmpresa,
		int idCargo
		
		) {
	
	public ListFuncionarioDTO(Funcionario funcionario) {
		this(
				funcionario.getId(),
				funcionario.getCpf(),
				funcionario.getLogin(),
				funcionario.getNomeCompleto(),
				funcionario.getDataNascimento(),
				funcionario.getEmail(),
				funcionario.getTelefone(),
				funcionario.getSenha(),
				funcionario.getFoto(),
				funcionario.getCargaHorariaDiaria(),
				funcionario.getCargaHorariaMensal(),
				funcionario.getHorarioEntrada(),
				funcionario.getHorarioIntervaloEntrada(),
				funcionario.getHorarioIntervaloSaida(),
				funcionario.getHorarioSaida(),
				funcionario.getHorarioFolgaEntrada(),
				funcionario.getHorarioFolgaSaida(),
				funcionario.getDiaFolga(),
				funcionario.getQuantidadeFaltas(),
				funcionario.getQuantidadeFaltasJustificadas(),
				funcionario.getQuantidadeHorasExtras(),
				funcionario.isAtivo(),
				funcionario.getIdEmpresa(),
				funcionario.getIdCargo()
				);
	}

}
