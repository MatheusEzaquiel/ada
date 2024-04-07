package com.ada.api.domain.empresa.dto;

import java.util.UUID;

import com.ada.api.domain.empresa.Empresa;

public record ListEmpresaDTO(UUID id, String cnpj, String nome, String dominio, String areaAtuacao, String ssid,
							 String numero, String rua, String bairro, String cidade, String uf, String pais, boolean ativo) {

	public ListEmpresaDTO(Empresa empresa) {
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
				empresa.isAtivo()
				);
	}

}