package com.ada.api.domain.administrador;

import java.util.UUID;

import com.ada.api.domain.empresa.Empresa;
import com.ada.api.domain.person.Person;
import com.ada.api.domain.person.UserRole;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.Valid;

@Entity(name = "Administrador")
@Table(name = "administradores")
public class Administrador extends Person {

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "id_empresa")
	private Empresa empresa;

	public Administrador() {
	}

	public Administrador(UUID id, String login, String apelido, String nomeCompleto, String email, String telefone,
			String senha, String foto, boolean ativo, UserRole role, Empresa empresa) {

		super(id, login, apelido, nomeCompleto, email, telefone, senha, foto, ativo, role);

		this.empresa = empresa;
		
	}

	public Administrador(@Valid CreateAdministradorDTO data, String encryptedPassword, String nomeImagem, Empresa empresa) {
		
		UUID id = UUID.randomUUID();
		
		this.id = id;
		this.login = data.login();
		this.apelido = "usuário";
		this.nomeCompleto = data.nomeCompleto();
		this.email = data.email();
		this.telefone = data.telefone();
		this.senha = encryptedPassword;
		this.foto = nomeImagem;
		this.ativo = true;
		this.empresa = empresa;
		this.role = UserRole.ADMIN;

	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public void update(UpdateAdministradorDTO admin) {

		if (admin.login() != null && admin.login() != "") {
			this.login = admin.login();
		}

		if (admin.apelido() != null && admin.apelido() != "") {
			this.apelido = admin.apelido();
		}

		if (admin.nomeCompleto() != null && admin.nomeCompleto() != "") {
			this.nomeCompleto = admin.nomeCompleto();
		}

		if (admin.email() != null && admin.email() != "") {
			this.email = admin.email();
		}

		if (admin.telefone() != null && admin.telefone() != "") {
			this.telefone = admin.telefone();
		}

		if (admin.senha() != null && admin.senha() != "") {
			this.senha = admin.senha();
		}

		if (admin.foto() != null && admin.foto() != "") {
			this.foto = admin.foto();
		}

	}

	@Override
	public String toString() {
		
		return 
				"ID: " + super.id + "\n" +
				"LOGIN: " + super.login + "\n" +
				"APELIDO: " + super.apelido + "\n" +
				"NOME COMPLETO: " + super.nomeCompleto + "\n" +
				"E-MAIL: " + super.email + "\n" +
				"TELEFONE: " + super.telefone + "\n" +
				"SENHA: " + super.senha + "\n" +
				"FOTO: " + super.foto + "\n" +
				"ATIVO: " + super.ativo + "\n" +
				"ROLE: " + super.role + "\n" +
				"EMPRESA: " + empresa.getNome();
		
	}
}
