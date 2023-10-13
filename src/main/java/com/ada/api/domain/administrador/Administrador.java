package com.ada.api.domain.administrador;

import com.ada.api.domain.empresa.Empresa;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="Administrador")
@Table(name="administradores")
@EqualsAndHashCode(of = "id")
public class Administrador {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String login;
	private String apelido;
	private String nomeCompleto;
	private String email;
	private String telefone;
	private String senha;
	private String foto;
	private boolean ativo;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="id_empresa")
	private Empresa empresa;
	
	
	public Administrador() {}
	
	public Administrador(Long id, String login, String apelido, String nomeCompleto, String email, String telefone,
			String senha, String foto, boolean ativo, Empresa empresa) {
		
		this.id = id;
		this.login = login;
		this.apelido = apelido;
		this.nomeCompleto = nomeCompleto;
		this.email = email;
		this.telefone = telefone;
		this.senha = senha;
		this.foto = foto;
		this.ativo = ativo;
		this.empresa = empresa;
		
	}
	
	public Administrador(@Valid CreateAdministradorDTO data, String nomeImagem, Empresa empresa) {
	
		this.login = data.login();
		this.apelido = "usuário";
		this.nomeCompleto = data.nomeCompleto();
		this.email = data.email();
		this.telefone = data.telefone();
		this.senha = data.senha();
		this.foto = nomeImagem;
		this.ativo = true;
		this.empresa = empresa;
		
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
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
	
}
