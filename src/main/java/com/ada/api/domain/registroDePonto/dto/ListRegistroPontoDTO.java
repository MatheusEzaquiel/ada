package com.ada.api.domain.registroDePonto.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import com.ada.api.domain.funcionario.dto.FuncionarioNameDTO;
import com.ada.api.domain.registroDePonto.RegistroDePonto;

public record ListRegistroPontoDTO(
		Long id,
		LocalDate data,
		LocalTime horarioEntrada,
		LocalTime horarioIntervaloEntrada,
		LocalTime horarioIntervaloSaida,
		LocalTime horarioSaida,
		FuncionarioNameDTO funcionarioName
		)
{
	
	public ListRegistroPontoDTO (RegistroDePonto registroDePonto){
		
		this(
				registroDePonto.getId(),
				registroDePonto.getData(),
				registroDePonto.getHorarioEntrada(),
				registroDePonto.getHorarioIntervaloEntrada(),
				registroDePonto.getHorarioIntervaloSaida(),
				registroDePonto.getHorarioSaida(),
				new FuncionarioNameDTO(registroDePonto.getFuncionario().getNomeCompleto())
		);
	}
}