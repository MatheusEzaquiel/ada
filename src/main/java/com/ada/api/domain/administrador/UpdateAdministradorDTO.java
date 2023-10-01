package com.ada.api.domain.administrador;

public record UpdateAdministradorDTO(
		
		Long id,
		String login,
		String apelido,
		String nomeCompleto,
		String email,
		String telefone,
		String senha,
		String foto
		
		) {

}
