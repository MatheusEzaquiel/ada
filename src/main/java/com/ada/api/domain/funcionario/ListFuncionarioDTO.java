package com.ada.api.domain.funcionario;

import java.time.LocalTime;

public record ListFuncionarioDTO(
		
		Long id,
        String login,
        String apelido,
        String nomeCompleto,
        String foto,
        Integer cargaHorariaDiaria,
        Integer cargaHorariaMensal,
        LocalTime horarioEntrada,
        LocalTime horarioIntervaloEntrada,
        LocalTime horarioIntervaloSaida,
        LocalTime horarioSaida,
        Integer quantidadeFaltas,
        Integer quantidadeFaltasJustificadas,
        Integer quantidadeHorasExtras,
        Long idEmpresa,
        String nomeEmpresa,
        int idCargo
		
		) {

}
