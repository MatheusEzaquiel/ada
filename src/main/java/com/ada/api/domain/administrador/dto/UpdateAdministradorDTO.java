package com.ada.api.domain.administrador.dto;


public record UpdateAdministradorDTO(
		
		String login,
		String apelido,
		String nomeCompleto,
		String email,
		String telefone,
		String senha,
		String foto
		
		) {

}
