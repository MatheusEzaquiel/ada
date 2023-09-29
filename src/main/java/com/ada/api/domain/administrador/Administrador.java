package com.ada.api.domain.administrador;

import com.ada.api.domain.empresa.Empresa;

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
	
}
