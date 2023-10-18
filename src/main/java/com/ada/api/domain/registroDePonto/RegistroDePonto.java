package com.ada.api.domain.registroDePonto;

import java.time.LocalDate;
import java.time.LocalTime;

import com.ada.api.domain.funcionario.Funcionario;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="RegistroDePonto")
@Table(name="registro_ponto")
public class RegistroDePonto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDate data;
	private LocalTime horarioEntrada;
	private LocalTime horarioIntervaloEntrada;
	private LocalTime horarioIntervaloSaida;
	private LocalTime horarioSaida;
	private String ssidAtual;
	private boolean ativo;
	private Long idFuncionario;
	//private Funcionario funcionario;
	
	
	public RegistroDePonto() {}

	public RegistroDePonto(Long id, LocalDate data, LocalTime horarioEntrada, LocalTime horarioIntervaloEntrada,
			LocalTime horarioIntervaloSaida, LocalTime horarioSaida, String ssidAtual, boolean ativo) {
	
		this.id = id;
		this.data = data;
		this.horarioEntrada = horarioEntrada;
		this.horarioIntervaloEntrada = horarioIntervaloEntrada;
		this.horarioIntervaloSaida = horarioIntervaloSaida;
		this.horarioSaida = horarioSaida;
		this.ssidAtual = ssidAtual;
		this.ativo = ativo;
		
	}
	
	public RegistroDePonto(CreateRegistroPontoDTO registro) {
		
		this.data = LocalDate.now();
		this.horarioEntrada = LocalTime.parse(registro.horarioEntrada());
		this.horarioIntervaloEntrada = LocalTime.parse(registro.horarioIntervaloEntrada());
		this.horarioIntervaloSaida = LocalTime.parse(registro.horarioIntervaloSaida());
		this.horarioSaida = LocalTime.parse(registro.horarioSaida());
		this.ssidAtual = registro.ssidAtual();
		this.ativo = true;
		this.idFuncionario = registro.idFuncionario();
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
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

	public void setHoraIntervaloEntrada(LocalTime horarioIntervaloEntrada) {
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

	public String getSsidAtual() {
		return ssidAtual;
	}

	public void setSsidAtual(String ssidAtual) {
		this.ssidAtual = ssidAtual;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public Long getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(Long idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public void setHorarioIntervaloEntrada(LocalTime horarioIntervaloEntrada) {
		this.horarioIntervaloEntrada = horarioIntervaloEntrada;
	}
	
	/*
	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	*/
	
	
}
