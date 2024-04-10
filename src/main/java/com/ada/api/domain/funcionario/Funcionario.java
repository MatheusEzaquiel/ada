package com.ada.api.domain.funcionario;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

import com.ada.api.domain.funcionario.dto.CreateFuncionarioDTO;

import com.ada.api.domain.cargo.Cargo;
import com.ada.api.domain.empresa.Empresa;
import com.ada.api.domain.person.Person;
import com.ada.api.domain.person.UserRole;
import com.ada.api.domain.registroDePonto.RegistroDePonto;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity(name = "Funcionario")
@Table(name = "funcionarios")
public class Funcionario extends Person  {

	private String cpf;
	private LocalDate dataNascimento;
	private Integer cargaHorariaDiaria;
	private Integer cargaHorariaMensal;
	private LocalTime horarioEntrada;
	private LocalTime horarioIntervaloEntrada;
	private LocalTime horarioIntervaloSaida;
	private LocalTime horarioSaida;
	private LocalTime horarioFolgaEntrada;
	private LocalTime horarioFolgaSaida;
	private String diaFolga;
	private Integer quantidadeFaltas;
	private Integer quantidadeFaltasJustificadas;
	private Integer quantidadeHorasExtras;
	
	@ManyToOne
	@JoinColumn(name="id_empresa")
	private Empresa empresa;
	
	@ManyToOne
	@JoinColumn(name="id_cargo")
	private Cargo cargo;
	
	@OneToMany(mappedBy = "funcionario")
	private List<RegistroDePonto> registrosDePonto;

	
	public Funcionario() {}
	
	public Funcionario(UUID id, String cpf, String login, String apelido, String nomeCompleto, LocalDate dataNascimento,
			String email, String telefone, String senha, String foto, Integer cargaHorariaDiaria,
			Integer cargaHorariaMensal, LocalTime horarioEntrada, LocalTime horarioIntervaloEntrada,
			LocalTime horarioIntervaloSaida, LocalTime horarioSaida, LocalTime horarioFolgaEntrada,
			LocalTime horarioFolgaSaida, String diaFolga, Integer quantidadeFaltas,
			Integer quantidadeFaltasJustificadas, Integer quantidadeHorasExtras, boolean ativo, Empresa empresa,
			Cargo cargo, List<RegistroDePonto> registrosDePonto, UserRole role) {
		
		super(id, login, apelido, nomeCompleto, email, telefone, senha, foto, ativo, role);
		
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.cargaHorariaDiaria = cargaHorariaDiaria;
		this.cargaHorariaMensal = cargaHorariaMensal;
		this.horarioEntrada = horarioEntrada;
		this.horarioIntervaloEntrada = horarioIntervaloEntrada;
		this.horarioIntervaloSaida = horarioIntervaloSaida;
		this.horarioSaida = horarioSaida;
		this.horarioFolgaEntrada = horarioFolgaEntrada;
		this.horarioFolgaSaida = horarioFolgaSaida;
		this.diaFolga = diaFolga;
		this.quantidadeFaltas = quantidadeFaltas;
		this.quantidadeFaltasJustificadas = quantidadeFaltasJustificadas;
		this.quantidadeHorasExtras = quantidadeHorasExtras;
		this.empresa = empresa;
		this.cargo = cargo;
		this.registrosDePonto = registrosDePonto;
	}
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Integer getCargaHorariaDiaria() {
		return cargaHorariaDiaria;
	}

	public void setCargaHorariaDiaria(Integer cargaHorariaDiaria) {
		this.cargaHorariaDiaria = cargaHorariaDiaria;
	}

	public Integer getCargaHorariaMensal() {
		return cargaHorariaMensal;
	}

	public void setCargaHorariaMensal(Integer cargaHorariaMensal) {
		this.cargaHorariaMensal = cargaHorariaMensal;
	}

	public LocalTime getHorarioEntrada() {
		return horarioEntrada;
	}

	public void setHorarioEntrada(LocalTime horarioEntrada) {
		this.horarioEntrada = horarioEntrada;
	}

	public LocalTime getHorarioIntervaloEntrada() {
		return horarioIntervaloEntrada;
	}

	public void setHorarioIntervaloEntrada(LocalTime horarioIntervaloEntrada) {
		this.horarioIntervaloEntrada = horarioIntervaloEntrada;
	}

	public LocalTime getHorarioIntervaloSaida() {
		return horarioIntervaloSaida;
	}

	public void setHorarioIntervaloSaida(LocalTime horarioIntervaloSaida) {
		this.horarioIntervaloSaida = horarioIntervaloSaida;
	}

	public LocalTime getHorarioSaida() {
		return horarioSaida;
	}

	public void setHorarioSaida(LocalTime horarioSaida) {
		this.horarioSaida = horarioSaida;
	}

	public LocalTime getHorarioFolgaEntrada() {
		return horarioFolgaEntrada;
	}

	public void setHorarioFolgaEntrada(LocalTime horarioFolgaEntrada) {
		this.horarioFolgaEntrada = horarioFolgaEntrada;
	}

	public LocalTime getHorarioFolgaSaida() {
		return horarioFolgaSaida;
	}

	public void setHorarioFolgaSaida(LocalTime horarioFolgaSaida) {
		this.horarioFolgaSaida = horarioFolgaSaida;
	}

	public String getDiaFolga() {
		return diaFolga;
	}

	public void setDiaFolga(String diaFolga) {
		this.diaFolga = diaFolga;
	}

	public Integer getQuantidadeFaltas() {
		return quantidadeFaltas;
	}

	public void setQuantidadeFaltas(Integer quantidadeFaltas) {
		this.quantidadeFaltas = quantidadeFaltas;
	}

	public Integer getQuantidadeFaltasJustificadas() {
		return quantidadeFaltasJustificadas;
	}

	public void setQuantidadeFaltasJustificadas(Integer quantidadeFaltasJustificadas) {
		this.quantidadeFaltasJustificadas = quantidadeFaltasJustificadas;
	}

	public Integer getQuantidadeHorasExtras() {
		return quantidadeHorasExtras;
	}

	public void setQuantidadeHorasExtras(Integer quantidadeHorasExtras) {
		this.quantidadeHorasExtras = quantidadeHorasExtras;
	}
	
	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public List<RegistroDePonto> getRegistrosDePonto() {
		return registrosDePonto;
	}

	public void setRegistrosDePonto(List<RegistroDePonto> registrosDePonto) {
		this.registrosDePonto = registrosDePonto;
	}


	public Funcionario(CreateFuncionarioDTO data, String encryptedPassword, Cargo cargo, Empresa empresa) {
		super.id = UUID.randomUUID();
		this.cpf = data.cpf();
		super.login = data.login();
		super.apelido = "usuário";
		super.nomeCompleto = data.nomeCompleto();
		this.dataNascimento = data.dataNascimento();
		super.email = data.email();
		super.telefone = data.telefone();
		super.senha = encryptedPassword;
		this.cargaHorariaDiaria = data.cargaHorariaDiaria();
		this.cargaHorariaMensal = data.cargaHorariaMensal();
		this.horarioEntrada = data.horarioEntrada();
		this.horarioIntervaloEntrada = data.horarioIntervaloEntrada();
		this.horarioIntervaloSaida = data.horarioIntervaloSaida();
		this.horarioSaida = data.horarioSaida();
		this.horarioFolgaEntrada = data.horarioFolgaEntrada();
		this.horarioFolgaSaida = data.horarioFolgaSaida();
		this.diaFolga = data.diaFolga();
		this.quantidadeFaltas = 0;
		this.quantidadeFaltasJustificadas = 0;
		this.quantidadeHorasExtras = 0;
		super.ativo = true;
		this.empresa = empresa;
		this.cargo = cargo;
		super.role = UserRole.FUNCIONARIO;
	}
		
}
