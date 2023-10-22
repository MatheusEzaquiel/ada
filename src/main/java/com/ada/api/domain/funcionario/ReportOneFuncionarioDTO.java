package com.ada.api.domain.funcionario;

import java.util.List;

import com.ada.api.domain.registroDePonto.ReportRegistroDePontoDTO;

public record ReportOneFuncionarioDTO(
		ReportFuncionarioDTO funcionario,
	    List<ReportRegistroDePontoDTO> registrosDePonto
		) {
}
