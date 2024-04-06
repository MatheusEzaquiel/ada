package com.ada.api.domain.registroDePonto.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public record ReportRegistroDePontoDTO(
		Long id,
		LocalDate data,
		LocalTime horarioEntrada,
		LocalTime horarioIntervaloEntrada,
		LocalTime horarioIntervaloSaida,
		LocalTime horarioSaida
		) {

}
