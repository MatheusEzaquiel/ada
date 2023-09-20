package com.ada.api.domain.funcionario;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Funcionario {
	
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
	private int cargaHorariaDiaria;
	private int cargaHorariaMensal;
	private LocalTime horarioEntrada;
	private LocalTime horarioIntervaloEntrada;
	private LocalTime horarioIntervaloSaida;
	private LocalTime horarioSaida;
	private LocalTime horarioFolgaEntrada;
	private LocalTime horarioFolgaSaida;
	private String diaFolga;
	private int quantidadeFaltas;
	private int quantidadeFaltasJustificadas;
	private int quantidadeHorasExtras;
	private boolean ativo;
	private int idEmpresa;
	private int idCargo;
	
	public Funcionario(CreateFuncionarioDTO data) {
			
			super();
			this.cpf = data.cpf();
			this.login = data.login();
			this.apelido = "usuário";
			this.nomeCompleto = data.nome_completo();
			this.dataNascimento = data.data_nascimento();
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
	}
