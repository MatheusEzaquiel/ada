package com.ada.api.domain.funcionario;

import com.ada.api.domain.cargo.CargoDTO;

public record UpdateFuncionarioDTO(

		Long id,
		String cpf,
		String login,
		String nomeCompleto,
		String dataNascimento,
		String email,
		String telefone,
		Integer cargaHorariaDiaria,
		Integer cargaHorariaMensal,
		String horarioEntrada,
		String horarioIntervaloEntrada,
		String horarioIntervaloSaida,
		String horarioSaida,
		String horarioFolgaEntrada,
		String horarioFolgaSaida,
		String diaFolga,
		Integer quantidadeFaltasJustificadas,
		Integer quantidadeHorasExtras,
		CargoDTO cargo

) {


}
