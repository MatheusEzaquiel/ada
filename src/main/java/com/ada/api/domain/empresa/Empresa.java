package com.ada.api.domain.empresa;

import java.util.List;
import java.util.UUID;

import com.ada.api.domain.administrador.Administrador;
import com.ada.api.domain.empresa.dto.CreateEmpresaDTO;
import com.ada.api.domain.funcionario.Funcionario;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;

@Entity(name = "Empresa")
@Table(name = "empresas")
@EqualsAndHashCode(of = "id")
public class Empresa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	@Column(name = "cnpj", unique = true)
	private String cnpj;
	@Column(name = "nome", unique = true)
	private String nome;
	@Column(name = "dominio", unique = true)
	private String dominio;
	@Column(name = "area_atuacao", unique = true)
	private String areaAtuacao;
	@Column(name="ssid")
	private String ssid;
	@Column(name="numero")
	private String numero;
	@Column(name="rua")
	private String rua;
	@Column(name="bairro")
	private String bairro;
	@Column(name="cidade")
	private String cidade;
	@Column(name="uf", length = 2)
	private String uf;
	@Column(name="pais")
	private String pais;
	@Column(name="ativo")
	private boolean ativo;

	@OneToMany(mappedBy = "empresa")
	private List<Funcionario> funcionarios;

	@JsonManagedReference
	@OneToMany(mappedBy = "empresa")
	private List<Administrador> administradores;
	
	public Empresa() {}
	
	public Empresa(UUID id, String cnpj, String nome, String dominio, String areaAtuacao, String ssid,
			String numero, String rua, String bairro, String cidade, String uf, String pais, boolean ativo,
			List<Funcionario> funcionarios, List<Administrador> administradores) {
		
		this.id = id;
		this.cnpj = cnpj;
		this.nome = nome;
		this.dominio = dominio;
		this.areaAtuacao = areaAtuacao;
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
	public Empresa(CreateEmpresaDTO empresaDTO) {
		this.id = UUID.randomUUID();
		this.cnpj = empresaDTO.cnpj();
		this.nome = empresaDTO.nome();
		this.dominio = empresaDTO.dominio();
		this.areaAtuacao = empresaDTO.areaAtuacao();
		this.ssid = empresaDTO.ssid();
		this.numero = empresaDTO.numero();
		this.rua = empresaDTO.rua();
		this.bairro = empresaDTO.bairro();
		this.cidade = empresaDTO.cidade();
		this.uf = empresaDTO.uf();
		this.pais = empresaDTO.pais();
		this.ativo = true;
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

	public String getAreaAtuacao() {
		return areaAtuacao;
	}

	public void setAreaAtuacao(String areaAtuacao) {
		this.areaAtuacao = areaAtuacao;
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
