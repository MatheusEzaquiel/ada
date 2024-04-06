package com.ada.api.domain.cargo;

import java.util.List;
import java.util.UUID;

import com.ada.api.domain.empresa.Empresa;
import com.ada.api.domain.funcionario.Funcionario;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="Cargo")
@Table(name="cargos")
@EqualsAndHashCode(of = "id")
public class Cargo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	private String area;
	private boolean ativo;
	
	@ManyToOne
	@JoinColumn(name="id_empresa")
	private Empresa empresa;
	
	@OneToMany(mappedBy = "cargo")
	private List<Funcionario> funcionarios;
	
	
	public Cargo() {}
	
	public Cargo(UUID id, String area, boolean ativo, Empresa empresa, List<Funcionario> funcionarios) {
	
		this.id = id;
		this.area = area;
		this.ativo = ativo;
		this.empresa = empresa;
		this.funcionarios = funcionarios;
		
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
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

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}
	
}
