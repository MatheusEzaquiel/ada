package com.ada.api.domain.funcionario;

import java.time.LocalDate;
import java.time.LocalTime;

import com.ada.api.domain.cargo.CargoDTO;
import com.ada.api.domain.empresa.Empresa;
import com.ada.api.domain.empresa.EmpresaDTO;

public record DetailFuncionarioDTO(
		Long id,
        String cpf,
        String login,
        String apelido,
        String nomeCompleto,
        LocalDate dataNascimento,
        String email,
        String telefone,
        String senha,
        String foto,
        Integer cargaHorariaDiaria,
        Integer cargaHorariaMensal,
        LocalTime horarioEntrada,
        LocalTime horarioIntervaloEntrada,
        LocalTime horarioIntervaloSaida,
        LocalTime horarioSaida,
        LocalTime horarioFolgaEntrada,
        LocalTime horarioFolgaSaida,
        String diaFolga,
        Integer quantidadeFaltas,
        Integer quantidadeFaltasJustificadas,
        Integer quantidadeHorasExtras,
        boolean ativo,
        EmpresaDTO empresa,
        CargoDTO cargo
        
		) {

}
