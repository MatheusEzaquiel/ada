package com.ada.api.domain.registroDePonto;

import java.time.LocalDate;
import java.time.LocalTime;

import com.ada.api.domain.funcionario.Funcionario;
import com.ada.api.domain.funcionario.FuncionarioNameDTO;

public record DetailRegistroDePontoDTO(
		Long id,
		LocalDate data,
		LocalTime horarioEntrada,
		LocalTime horarioIntervaloEntrada,
		LocalTime horarioIntervaloSaida,
		LocalTime horarioSaida,
		String ssidAtual,
		boolean ativo,
		FuncionarioNameDTO funcionario) {

	public DetailRegistroDePontoDTO (RegistroDePonto registroDePonto){
		
		this(
				registroDePonto.getId(),
				registroDePonto.getData(),
				registroDePonto.getHorarioEntrada(),
				registroDePonto.getHorarioIntervaloEntrada(),
				registroDePonto.getHorarioIntervaloSaida(),
				registroDePonto.getHorarioSaida(),
				registroDePonto.getSsidAtual(),
				registroDePonto.isAtivo(),
				new FuncionarioNameDTO(registroDePonto.getFuncionario().getNomeCompleto())
		);
	}


}
