package com.ada.api.domain.funcionario.dto;

import java.time.LocalTime;
import java.util.UUID;

import com.ada.api.domain.cargo.dto.CargoDTO;
import com.ada.api.domain.empresa.dto.EmpresaDTO;

public record ListFuncionarioDTO(
		
		UUID id,
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
        EmpresaDTO empresa,
        CargoDTO cargo
		
		) {

}
