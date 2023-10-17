package com.ada.api.domain.registroDePonto;

public record CreateRegistroPontoDTO(
		
		String horarioEntrada,
		String horarioIntervaloEntrada,
		String horarioIntervaloSaida,
		String horarioSaida,
		String ssidAtual,
		Long idFuncionario
		
		) {
	

}
