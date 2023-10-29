package com.ada.api.domain.funcionario;

import java.time.LocalDate;
import java.time.LocalTime;

import com.ada.api.domain.person.UserRole;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateFuncionarioDTO(
		
		@NotBlank String cpf,
		@NotBlank String login,
		@NotBlank String nomeCompleto,
		@NotNull LocalDate dataNascimento,
		@Email String email,
		@NotBlank String telefone,
		String senha,
		@NotNull int cargaHorariaDiaria,
		@NotNull int cargaHorariaMensal,
		@NotNull LocalTime horarioEntrada,
		@NotNull LocalTime horarioIntervaloEntrada,
		@NotNull LocalTime horarioIntervaloSaida,
		@NotNull LocalTime horarioSaida,
		LocalTime horarioFolgaEntrada,
		LocalTime horarioFolgaSaida,
		String diaFolga,
		UserRole role
		
		) {

}
