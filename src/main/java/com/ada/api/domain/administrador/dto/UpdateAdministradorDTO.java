package com.ada.api.domain.administrador;


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
