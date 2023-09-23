package com.ada.api.domain.funcionario;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Funcionario")
@Table(name = "funcionarios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
	private int idEmpresa;
	private int idCargo;

	public Funcionario(CreateFuncionarioDTO data) {

		super();
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
		this.idEmpresa = data.idEmpresa();
		this.idCargo = data.idCargo();

	}

	public void updateByAdmin(UpdateFuncionarioDTO funcionario) {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		if(funcionario.id() != null) {
			this.id = funcionario.id();
		}
		
		if(funcionario.cpf() != null && funcionario.cpf() != "") {
			this.id = funcionario.id();
		}
		
		if(funcionario.login() != null && funcionario.login() != "") {
			this.login = funcionario.login();
		}
		
		if(funcionario.nomeCompleto() != null && funcionario.nomeCompleto() != "") {
			this.nomeCompleto = funcionario.nomeCompleto();
		}
		
		if(funcionario.dataNascimento() != null && funcionario.dataNascimento() != "") {
			
			LocalDate dataNascimento = LocalDate.parse(funcionario.dataNascimento(), formatter);
			this.dataNascimento = dataNascimento;
			
		}
		
		if(funcionario.email() != null && funcionario.email() != "") {
			this.email = funcionario.email();
		}
		
		if(funcionario.telefone() != null && funcionario.telefone() != "") {
			this.telefone = funcionario.telefone();
		}
		
		if(funcionario.senha() != null && funcionario.senha() != "") {
			this.senha = funcionario.senha();
		}
		
		if(funcionario.foto() != null && funcionario.foto() != "") {
			this.foto = funcionario.foto();
		}
		
		if(funcionario.cargaHorariaDiaria() != null && funcionario.cargaHorariaDiaria() != 0) {
			this.cargaHorariaDiaria = funcionario.cargaHorariaDiaria();
		}
		
		if(funcionario.cargaHorariaMensal() != null && funcionario.cargaHorariaMensal() != 0) {
			this.cargaHorariaMensal = funcionario.cargaHorariaMensal();
		}
		
	
		if(funcionario.horarioEntrada() != null && funcionario.horarioEntrada() != "") {
			LocalTime horarioEntrada = LocalTime.parse(funcionario.horarioEntrada());
			this.horarioEntrada = horarioEntrada;
		}
		
		if(funcionario.horarioIntervaloEntrada() != null && funcionario.horarioIntervaloEntrada() != "") {
			LocalTime horarioIntervaloEntrada = LocalTime.parse(funcionario.horarioIntervaloEntrada());
			this.horarioIntervaloEntrada = horarioIntervaloEntrada;
		}
		
		if(funcionario.horarioIntervaloSaida() != null && funcionario.horarioIntervaloSaida() != "") {
			LocalTime horarioIntervaloSaida = LocalTime.parse(funcionario.horarioIntervaloSaida());
			this.horarioIntervaloSaida = horarioIntervaloSaida;
		}
		
		if(funcionario.horarioSaida() != null && funcionario.horarioSaida() != "") {
			LocalTime horarioSaida = LocalTime.parse(funcionario.horarioSaida());
			this.horarioSaida = horarioSaida;
		}
		
		if(funcionario.horarioFolgaEntrada() != null && funcionario.horarioFolgaEntrada() != "") {
			LocalTime horarioFolgaEntrada = LocalTime.parse(funcionario.horarioFolgaEntrada());
			this.horarioFolgaEntrada = horarioFolgaEntrada;
		}
		
		if(funcionario.horarioFolgaSaida() != null && funcionario.horarioFolgaSaida() != "") {
			LocalTime horarioFolgaSaida = LocalTime.parse(funcionario.horarioFolgaSaida());
			this.horarioFolgaSaida = horarioFolgaSaida;
		}
		
		if(funcionario.diaFolga() != null && funcionario.diaFolga() != "") {
			this.diaFolga = funcionario.diaFolga();
		}
		
		if(funcionario.quantidadeFaltasJustificadas() != null && funcionario.quantidadeFaltasJustificadas() != 0) {
			this.quantidadeFaltasJustificadas = funcionario.quantidadeFaltasJustificadas();
		}
		
		if(funcionario.quantidadeHorasExtras() != null && funcionario.quantidadeHorasExtras() != 0) {
			this.quantidadeFaltasJustificadas = funcionario.quantidadeFaltasJustificadas();
		}
		
		if(funcionario.idCargo() != null && funcionario.idCargo() != 0) {
			this.id = funcionario.id();
		}
		
	}

}
