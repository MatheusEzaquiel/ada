package com.ada.api.domain.funcionario.dto;

import java.time.LocalTime;
import java.util.UUID;

import com.ada.api.domain.cargo.dto.ReportCargoDTO;
import com.ada.api.domain.empresa.dto.ReportEmpresaDTO;

public record ReportFuncionarioDTO(
		UUID id,
		String cpf,
        String login,
        String nomeCompleto,
        Integer cargaHorariaDiaria,
        Integer cargaHorariaMensal,
        LocalTime horarioEntrada,
        LocalTime horarioIntervaloEntrada,
        LocalTime horarioIntervaloSaida,
        LocalTime horarioSaida,
        Integer quantidadeFaltas,
        Integer quantidadeFaltasJustificadas,
        Integer quantidadeHorasExtras,
        boolean ativo,
        ReportEmpresaDTO empresa,
        ReportCargoDTO cargo
        ) {

}
