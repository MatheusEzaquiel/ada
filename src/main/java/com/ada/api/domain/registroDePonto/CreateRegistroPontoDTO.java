package com.ada.api.domain.registroDePonto;

import com.ada.api.domain.funcionario.Funcionario;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public record CreateRegistroPontoDTO(
		
		String horarioEntrada,
		String horarioIntervaloEntrada,
		String horarioIntervaloSaida,
		String horarioSaida,
		String ssidAtual,
		
		@ManyToOne
		@JoinColumn(name="id_funcionario")
		Funcionario funcionario
		
		) {
	

}
