package com.ada.api.domain.funcionario.dto;

import java.util.List;

import com.ada.api.domain.registroDePonto.dto.ReportRegistroDePontoDTO;

public record ReportOneFuncionarioDTO(
		ReportFuncionarioDTO funcionario,
	    List<ReportRegistroDePontoDTO> registrosDePonto
		) {
}
