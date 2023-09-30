package com.ada.api.domain.administrador;

import com.ada.api.domain.empresa.EmpresaNomeDTO;

public record ListAdministradorDTO(String Login, String apelido, String nomeCompleto, String email, String telefone, String senha, String foto, EmpresaNomeDTO empresa) {
	
	public ListAdministradorDTO(Administrador admins) {
		
		
		
		this(
		        admins.getLogin(),
		        admins.getApelido(),
		        admins.getNomeCompleto(),
		        admins.getEmail(),
		        admins.getTelefone(),
		        admins.getSenha(),
		        admins.getFoto(),
		        new EmpresaNomeDTO(admins.getEmpresa().getNome())
		);
		
	}

}
