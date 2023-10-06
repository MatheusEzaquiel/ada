package com.ada.api.domain.registroDePonto;

import java.time.LocalDate;
import java.time.LocalTime;

import com.ada.api.domain.funcionario.Funcionario;

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
	private LocalTime horario_entrada;
	private LocalTime horaIntervaloEntrada;
	private LocalTime horarioIntervaloSaida;
	private LocalTime horarioSaida;
	private boolean presencaWifi;
	private boolean ativo;
	//private Funcionario funcionario;
	
	
	public RegistroDePonto() {}
	
	public RegistroDePonto(Long id, LocalDate data, LocalTime horario_entrada, LocalTime horaIntervaloEntrada,
			LocalTime horarioIntervaloSaida, LocalTime horarioSaida, boolean presencaWifi, boolean ativo) {
		
		this.id = id;
		this.data = data;
		this.horario_entrada = horario_entrada;
		this.horaIntervaloEntrada = horaIntervaloEntrada;
		this.horarioIntervaloSaida = horarioIntervaloSaida;
		this.horarioSaida = horarioSaida;
		this.presencaWifi = presencaWifi;
		this.ativo = ativo;
		
	}
	
	
}
