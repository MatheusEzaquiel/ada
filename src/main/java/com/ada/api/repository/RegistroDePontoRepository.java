package com.ada.api.repository;

import com.ada.api.domain.registroDePonto.RegistroDePonto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RegistroDePontoRepository extends JpaRepository<RegistroDePonto, UUID> {

}
