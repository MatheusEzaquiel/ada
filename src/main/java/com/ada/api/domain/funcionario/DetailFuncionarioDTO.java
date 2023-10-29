package com.ada.api.domain.funcionario;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

import com.ada.api.domain.cargo.CargoDTO;
import com.ada.api.domain.empresa.EmpresaDTO;

public record DetailFuncionarioDTO(
		UUID id,
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

	public DetailFuncionarioDTO(Funcionario f, String foto) {
		this(
				f.getId(),
				f.getCpf(),
				f.getLogin(),
		        f.getApelido(),
		        f.getNomeCompleto(),
		        f.getDataNascimento(),
		        f.getEmail(),
		        f.getTelefone(),
		        f.getSenha(),
		        foto,
		        f.getCargaHorariaDiaria(),
		        f.getCargaHorariaMensal(),
		        f.getHorarioEntrada(),
		        f.getHorarioIntervaloEntrada(),
		        f.getHorarioIntervaloSaida(),
		        f.getHorarioSaida(),
		        f.getHorarioFolgaEntrada(),
		        f.getHorarioFolgaSaida(),
		        f.getDiaFolga(),
		        f.getQuantidadeFaltas(),
		        f.getQuantidadeFaltasJustificadas(),
		        f.getQuantidadeHorasExtras(),
		        f.isAtivo(),
		        new  EmpresaDTO(f.getEmpresa().getId(), f.getEmpresa().getNome()),
		        new CargoDTO(f.getCargo().getId(), f.getCargo().getArea())
				);
	}


}
