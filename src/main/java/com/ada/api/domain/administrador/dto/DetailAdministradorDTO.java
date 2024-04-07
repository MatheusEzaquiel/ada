package com.ada.api.domain.administrador.dto;

import com.ada.api.domain.administrador.Administrador;
import com.ada.api.domain.empresa.EmpresaNomeDTO;
import com.ada.api.domain.person.UserRole;

import java.util.UUID;

public record DetailAdministradorDTO(
        UUID id,
        String Login,
        String apelido,
        String nomeCompleto,
        String email,
        String telefone,
        String senha,
        String foto,
        UserRole role,
        Boolean ativo,
        EmpresaNomeDTO empresa) {

    public DetailAdministradorDTO(Administrador admin, String foto) {

        this(
                admin.getId(),
                admin.getLogin(),
                admin.getApelido(),
                admin.getNomeCompleto(),
                admin.getEmail(),
                admin.getTelefone(),
                admin.getSenha(),
                foto,
                admin.getRole(),
                admin.isAtivo(),
                new EmpresaNomeDTO(admin.getEmpresa().getNome())
        );

    }

}
