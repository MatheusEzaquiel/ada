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
	private String nome_completo;
	private LocalDate data_nascimento;
	private String email;
	private String telefone;
	private String senha;
	private String foto;
	private int carga_horaria_diaria;
	private int carga_horaria_mensal;
	private LocalTime horario_entrada;
	private LocalTime horario_intervalo_entrada;
	private LocalTime horario_intervalo_saida;
	private LocalTime horario_saida;
	private LocalTime horario_folga_entrada;
	private LocalTime horario_folga_saida;
	private String dia_folga;
	private int quantidade_faltas;
	private int quantidade_faltas_justificadas;
	private int quantidade_horas_extras;
	private boolean ativo;
	private int id_empresa;
	private int id_cargo;
	
}
