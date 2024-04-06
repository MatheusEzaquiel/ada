package com.ada.api.domain.administrador;

import java.util.UUID;

import com.ada.api.domain.administrador.dto.CreateAdministradorDTO;
import com.ada.api.domain.administrador.dto.UpdateAdministradorDTO;
import com.ada.api.domain.empresa.Empresa;
import com.ada.api.domain.person.Person;
import com.ada.api.domain.person.UserRole;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import jakarta.validation.Valid;

@Entity(name = "Administrador")
@Table(name = "administradores")
public class Administrador {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	@Column(name = "login")
	private String login;
	@Column(name = "apelido")
	private String apelido;
	@Column(name = "nome_completo")
	private String nomeCompleto;
	@Column(name = "email")
	private String email;
	@Column(name = "telefone")
	private String telefone;
	@Column(name = "senha")
	private String senha;
	@Column(name = "foto")
	private String foto;
	@Column(name = "ativo")
	private boolean ativo;
	@Column(name = "role")
	private UserRole role;
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "id_empresa")
	private Empresa empresa;


	public Administrador() {}

	public Administrador(UUID id, String login, String apelido, String nomeCompleto, String email, String telefone,
						 String senha, String foto, boolean ativo, UserRole role, Empresa empresa) {

		this.id = id;
		this.login = login;
		this.apelido = apelido;
		this.nomeCompleto = nomeCompleto;
		this.email = email;
		this.telefone = telefone;
		this.senha = senha;
		this.foto = foto;
		this.ativo = ativo;
		this.role = role;
		this.empresa = empresa;

	}

	public Administrador(@Valid CreateAdministradorDTO data, String encryptedPassword, String nomeImagem, Empresa empresa) {
		
		this.id = UUID.randomUUID();
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

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	@Override
	public String toString() {
		return "Administrador{" +
				"id=" + id +
				", login='" + login + '\'' +
				", apelido='" + apelido + '\'' +
				", nomeCompleto='" + nomeCompleto + '\'' +
				", email='" + email + '\'' +
				", telefone='" + telefone + '\'' +
				", senha='" + senha + '\'' +
				", foto='" + foto + '\'' +
				", ativo=" + ativo +
				", role=" + role.name() +
				", empresa=" + empresa.getNome() +
				'}';
	}

}
