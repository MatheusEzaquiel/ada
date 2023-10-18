package com.ada.api.domain.registroDePonto;

import java.time.LocalDate;
import java.time.LocalTime;

public record DetailRegistroDePontoDTO(
		Long id,
		LocalDate data,
		LocalTime horarioEntrada,
		LocalTime horarioIntervaloEntrada,
		LocalTime horarioIntervaloSaida,
		LocalTime horarioSaida,
		String ssidAtual,
		boolean ativo,
		Long idFuncionario) {

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
				registroDePonto.getIdFuncionario()
				);
	}

}
