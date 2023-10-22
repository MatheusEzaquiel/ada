package com.ada.api.domain.funcionario;

import java.time.LocalTime;

import com.ada.api.domain.cargo.ReportCargoDTO;
import com.ada.api.domain.empresa.ReportEmpresaDTO;

public record ReportFuncionarioDTO(
		Long id,
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
