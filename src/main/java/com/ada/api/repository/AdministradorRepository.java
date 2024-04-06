package com.ada.api.domain.administrador;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.security.core.userdetails.UserDetails;

public interface AdministradorRepository extends JpaRepository<Administrador, UUID> {
	
	//UserDetails findByLogin(String login);

	Optional<Administrador> findById(UUID id);

	Administrador getReferenceById(UUID id);
	
}
