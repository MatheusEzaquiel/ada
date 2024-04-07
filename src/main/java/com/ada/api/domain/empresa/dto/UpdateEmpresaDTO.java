package com.ada.api.domain.empresa.dto;

public record UpdateEmpresaDTO(
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
        Boolean ativo
    ) {
}
