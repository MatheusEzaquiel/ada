package com.ada.api.domain.funcionario.dto;

import java.time.LocalDate;

public record BasicUpdateFuncionarioDTO(
        String apelido,
        LocalDate dataNascimento,
        String email,
        String senha,
        String telefone) {}
