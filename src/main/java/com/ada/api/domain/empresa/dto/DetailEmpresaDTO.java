package com.ada.api.domain.empresa.dto;

import com.ada.api.domain.administrador.Administrador;
import com.ada.api.domain.empresa.Empresa;
import com.ada.api.domain.funcionario.Funcionario;

import java.util.List;
import java.util.UUID;

public record DetailEmpresaDTO(
        UUID id,
        String cnpj,
        String nome,
        String dominio,
        String areaAtuacao,
        String ssid,
        String numero,
        String rua,
        String bairro,
        String cidade,
        String uf,
        String pais,
        boolean ativo,
        List<Funcionario> funcionarios,
        List<Administrador> administradores) {

    public DetailEmpresaDTO(Empresa empresa) {
        this(
                empresa.getId(),
                empresa.getCnpj(),
                empresa.getNome(),
                empresa.getDominio(),
                empresa.getAreaAtuacao(),
                empresa.getSsid(),
                empresa.getNumero(),
                empresa.getRua(),
                empresa.getBairro(),
                empresa.getCidade(),
                empresa.getUf(),
                empresa.getPais(),
                empresa.isAtivo(),
                empresa.getFuncionarios(),
                empresa.getAdministradores()
        );
    }
}