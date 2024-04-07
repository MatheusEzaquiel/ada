package com.ada.api.domain.administrador.dto;

import java.util.UUID;

import com.ada.api.domain.administrador.Administrador;
import com.ada.api.domain.empresa.EmpresaNomeDTO;

public record ListAdministradorDTO(UUID id, String Login, String apelido, String nomeCompleto, String email, String telefone, String foto, EmpresaNomeDTO empresa) {
	
	public ListAdministradorDTO(Administrador admins, String foto) {
		
		this(
				admins.getId(),
		        admins.getLogin(),
		        admins.getApelido(),
		        admins.getNomeCompleto(),
		        admins.getEmail(),
		        admins.getTelefone(),
		        foto,

		        new EmpresaNomeDTO(admins.getEmpresa().getNome())
		);
		
	}
	
	public ListAdministradorDTO(Administrador admins) {
		
		this(
				admins.getId(),
		        admins.getLogin(),
		        admins.getApelido(),
		        admins.getNomeCompleto(),
		        admins.getEmail(),
		        admins.getTelefone(),
		        admins.getFoto(),
		        new EmpresaNomeDTO(admins.getEmpresa().getNome())
		);
		
	}

}
