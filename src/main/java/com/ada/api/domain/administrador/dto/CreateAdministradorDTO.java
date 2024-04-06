package com.ada.api.domain.administrador.dto;

public record CreateAdministradorDTO(
		String login,
		String nomeCompleto,
		String email,
		String telefone,
		String senha) {

}
