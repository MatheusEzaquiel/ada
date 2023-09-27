package com.ada.api.domain.empresa;


import java.util.List;

import com.ada.api.domain.cargo.Cargo;
import com.ada.api.domain.funcionario.Funcionario;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Empresa")
@Table(name = "empresas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Empresa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String cnpj;
	private String nome;
	private String dominio;
	private String area_atuacao;
	private String localizacao;
	private String numero;
	private String rua;
	private String bairro;
	private String cidade;
	private String uf;
	private String pais;
	private boolean ativo;
	
	@OneToMany(mappedBy = "empresa")
	private List<Funcionario> funcionarios;
	
}
