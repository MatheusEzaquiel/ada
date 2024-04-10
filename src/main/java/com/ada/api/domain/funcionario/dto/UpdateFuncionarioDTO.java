package com.ada.api.domain.funcionario.dto;

import com.ada.api.domain.person.UserRole;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.time.LocalTime;

public record UpdateFuncionarioDTO(

		String cpf,
		String login,
		String nomeCompleto,
		String apelido,
		LocalDate dataNascimento,
		String email,
		String telefone,
		String senha,
		Integer cargaHorariaDiaria,
		Integer cargaHorariaMensal,
		LocalTime horarioEntrada,
		LocalTime horarioIntervaloEntrada,
		LocalTime horarioIntervaloSaida,
		LocalTime horarioSaida,
		LocalTime horarioFolgaEntrada,
		LocalTime horarioFolgaSaida,
		String diaFolga,
		Integer quantidadeFaltas,
		Integer quantidadeFaltasJustificadas,
		Integer quantidadeHorasExtras,
		Boolean ativo,
		UserRole role

) {


}
