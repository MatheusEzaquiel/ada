package com.ada.api.domain.funcionario;

import java.time.LocalDate;
import java.time.LocalTime;

public record CreateFuncionarioDTO(
		
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
		int idEmpresa,
		int idCargo) {

}
