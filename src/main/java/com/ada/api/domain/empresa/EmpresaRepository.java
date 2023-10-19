package com.ada.api.domain.empresa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
	Empresa findBySsid(String ssid);
}
