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
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="Administrador")
@Table(name="administradores")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
	
	@ManyToOne
	@JoinColumn(name="id_empresa")
	private Empresa empresa;
	
	
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
