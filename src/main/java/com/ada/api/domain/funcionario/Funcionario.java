package com.ada.api.domain.funcionario;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import com.ada.api.domain.cargo.Cargo;
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

@Entity(name = "Funcionario")
@Table(name = "funcionarios")
@EqualsAndHashCode(of = "id")
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String cpf;
	private String login;
	private String apelido;
	private String nomeCompleto;
	private LocalDate dataNascimento;
	private String email;
	private String telefone;
	private String senha;
	private String foto;
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
	private boolean ativo;
	
	@ManyToOne
	@JoinColumn(name="id_empresa")
	private Empresa empresa;
	
	@ManyToOne
	@JoinColumn(name="id_cargo")
	private Cargo cargo;

	
	public Funcionario() {}
	
	public Funcionario(Long id, String cpf, String login, String apelido, String nomeCompleto, LocalDate dataNascimento,
			String email, String telefone, String senha, String foto, Integer cargaHorariaDiaria,
			Integer cargaHorariaMensal, LocalTime horarioEntrada, LocalTime horarioIntervaloEntrada,
			LocalTime horarioIntervaloSaida, LocalTime horarioSaida, LocalTime horarioFolgaEntrada,
			LocalTime horarioFolgaSaida, String diaFolga, Integer quantidadeFaltas,
			Integer quantidadeFaltasJustificadas, Integer quantidadeHorasExtras, boolean ativo, Empresa empresa,
			Cargo cargo) {
	
		this.id = id;
		this.cpf = cpf;
		this.login = login;
		this.apelido = apelido;
		this.nomeCompleto = nomeCompleto;
		this.dataNascimento = dataNascimento;
		this.email = email;
		this.telefone = telefone;
		this.senha = senha;
		this.foto = foto;
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
		this.ativo = ativo;
		this.empresa = empresa;
		this.cargo = cargo;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
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

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	
	
	public Funcionario(CreateFuncionarioDTO data) {

		this.cpf = data.cpf();
		this.login = data.login();
		this.apelido = "usuário";
		this.nomeCompleto = data.nomeCompleto();
		this.dataNascimento = data.dataNascimento();
		this.email = data.email();
		this.telefone = data.telefone();
		this.senha = data.senha();
		this.foto = data.foto();
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
		this.ativo = true;
		this.empresa = data.empresa();
		this.cargo = data.cargo();

	}

	public void updateByAdmin(UpdateFuncionarioDTO funcionario) {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		if (funcionario.id() != null) {
			this.id = funcionario.id();
		}

		if (funcionario.cpf() != null && funcionario.cpf() != "") {
			this.id = funcionario.id();
		}

		if (funcionario.login() != null && funcionario.login() != "") {
			this.login = funcionario.login();
		}

		if (funcionario.nomeCompleto() != null && funcionario.nomeCompleto() != "") {
			this.nomeCompleto = funcionario.nomeCompleto();
		}

		if (funcionario.dataNascimento() != null && funcionario.dataNascimento() != "") {

			LocalDate dataNascimento = LocalDate.parse(funcionario.dataNascimento(), formatter);
			this.dataNascimento = dataNascimento;

		}

		if (funcionario.email() != null && funcionario.email() != "") {
			this.email = funcionario.email();
		}

		if (funcionario.telefone() != null && funcionario.telefone() != "") {
			this.telefone = funcionario.telefone();
		}
		
		if (funcionario.cargaHorariaDiaria() != null && funcionario.cargaHorariaDiaria() != 0) {
			this.cargaHorariaDiaria = funcionario.cargaHorariaDiaria();
		}

		if (funcionario.cargaHorariaMensal() != null && funcionario.cargaHorariaMensal() != 0) {
			this.cargaHorariaMensal = funcionario.cargaHorariaMensal();
		}

		if (funcionario.horarioEntrada() != null && funcionario.horarioEntrada() != "") {
			LocalTime horarioEntrada = LocalTime.parse(funcionario.horarioEntrada());
			this.horarioEntrada = horarioEntrada;
		}

		if (funcionario.horarioIntervaloEntrada() != null && funcionario.horarioIntervaloEntrada() != "") {
			LocalTime horarioIntervaloEntrada = LocalTime.parse(funcionario.horarioIntervaloEntrada());
			this.horarioIntervaloEntrada = horarioIntervaloEntrada;
		}

		if (funcionario.horarioIntervaloSaida() != null && funcionario.horarioIntervaloSaida() != "") {
			LocalTime horarioIntervaloSaida = LocalTime.parse(funcionario.horarioIntervaloSaida());
			this.horarioIntervaloSaida = horarioIntervaloSaida;
		}

		if (funcionario.horarioSaida() != null && funcionario.horarioSaida() != "") {
			LocalTime horarioSaida = LocalTime.parse(funcionario.horarioSaida());
			this.horarioSaida = horarioSaida;
		}

		if (funcionario.horarioFolgaEntrada() != null && funcionario.horarioFolgaEntrada() != "") {
			LocalTime horarioFolgaEntrada = LocalTime.parse(funcionario.horarioFolgaEntrada());
			this.horarioFolgaEntrada = horarioFolgaEntrada;
		}

		if (funcionario.horarioFolgaSaida() != null && funcionario.horarioFolgaSaida() != "") {
			LocalTime horarioFolgaSaida = LocalTime.parse(funcionario.horarioFolgaSaida());
			this.horarioFolgaSaida = horarioFolgaSaida;
		}

		if (funcionario.diaFolga() != null && funcionario.diaFolga() != "") {
			this.diaFolga = funcionario.diaFolga();
		}

		if (funcionario.quantidadeFaltasJustificadas() != null && funcionario.quantidadeFaltasJustificadas() != 0) {
			this.quantidadeFaltasJustificadas = funcionario.quantidadeFaltasJustificadas();
		}

		if (funcionario.quantidadeHorasExtras() != null && funcionario.quantidadeHorasExtras() != 0) {
			this.quantidadeFaltasJustificadas = funcionario.quantidadeFaltasJustificadas();
		}
		
		/*
		if (funcionario.idCargo() != null && funcionario.idCargo() != 0) {
			this.id = funcionario.id();
		}
		*/
	}

	public void toAvailable() {

		this.ativo = true;

	}
	
	public void toUnavailable() {

		this.ativo = false;

	}

	public void update(BasicUpdateFuncionarioDTO funcionario) {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		if (funcionario.id() != null) {
			this.id = funcionario.id();
		}
		
		if (funcionario.apelido() != null && funcionario.apelido() != "") {
			this.apelido = funcionario.apelido();
		}
		
		if (funcionario.nomeCompleto() != null && funcionario.nomeCompleto() != "") {
			this.nomeCompleto = funcionario.nomeCompleto();
		}
		
		if (funcionario.dataNascimento() != null && funcionario.dataNascimento() != "") {

			LocalDate dataNascimento = LocalDate.parse(funcionario.dataNascimento(), formatter);
			this.dataNascimento = dataNascimento;

		}

		if (funcionario.email() != null && funcionario.email() != "") {
			this.email = funcionario.email();
		}

		if (funcionario.telefone() != null && funcionario.telefone() != "") {
			this.telefone = funcionario.telefone();
		}
		
		if (funcionario.senha() != null && funcionario.senha() != "") {
			this.senha = funcionario.senha();
		}
		
		if (funcionario.foto() != null && funcionario.foto() != "") {
			this.foto = funcionario.foto();
		}
		
	}
	
}
