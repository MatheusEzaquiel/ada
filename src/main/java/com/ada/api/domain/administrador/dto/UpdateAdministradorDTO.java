package com.ada.api.domain.administrador.dto;

import com.ada.api.domain.person.UserRole;

import java.util.UUID;

public record UpdateAdministradorDTO(
		
		String login,
		String apelido,
		String nomeCompleto,
		String email,
		String telefone,
		String senha,
		String foto,
		UserRole role,
		Boolean ativo,
		UUID empresaId
		
		) {

}
