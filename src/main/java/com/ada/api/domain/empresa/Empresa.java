package com.ada.api.domain.empresa;

import java.util.List;
import java.util.UUID;

import com.ada.api.domain.administrador.Administrador;
import com.ada.api.domain.funcionario.Funcionario;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;

@Entity(name = "Empresa")
@Table(name = "empresas")
@EqualsAndHashCode(of = "id")
public class Empresa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	private String cnpj;
	private String nome;
	private String dominio;
	private String area_atuacao;
	private String ssid;
	private String numero;
	private String rua;
	private String bairro;
	private String cidade;
	private String uf;
	private String pais;
	private boolean ativo;

	@OneToMany(mappedBy = "empresa")
	private List<Funcionario> funcionarios;

	@JsonManagedReference
	@OneToMany(mappedBy = "empresa")
	private List<Administrador> administradores;
	
	public Empresa() {}
	
	public Empresa(Long id, String cnpj, String nome, String dominio, String area_atuacao, String ssid,
			String numero, String rua, String bairro, String cidade, String uf, String pais, boolean ativo,
			List<Funcionario> funcionarios, List<Administrador> administradores) {
		
		this.id = UUID.randomUUID();
		this.cnpj = cnpj;
		this.nome = nome;
		this.dominio = dominio;
		this.area_atuacao = area_atuacao;
		this.ssid = ssid;
		this.numero = numero;
		this.rua = rua;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.pais = pais;
		this.ativo = ativo;
		this.funcionarios = funcionarios;
		this.administradores = administradores;
		
	}
	
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDominio() {
		return dominio;
	}

	public void setDominio(String dominio) {
		this.dominio = dominio;
	}

	public String getArea_atuacao() {
		return area_atuacao;
	}

	public void setArea_atuacao(String area_atuacao) {
		this.area_atuacao = area_atuacao;
	}

	public String getSsid() {
		return ssid;
	}

	public void setSsid(String ssid) {
		this.ssid = ssid;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public List<Administrador> getAdministradores() {
		return administradores;
	}

	public void setAdministradores(List<Administrador> administradores) {
		this.administradores = administradores;
	}

	
}
