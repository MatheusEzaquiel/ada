package com.ada.api.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.ada.api.domain.administrador.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.security.core.userdetails.UserDetails;

public interface AdministradorRepository extends JpaRepository<Administrador, UUID> {
	
	//UserDetails findByLogin(String login);
	List<Administrador> findByAtivo(Boolean isEnabled);
	Optional<Administrador> findById(UUID id);

	Administrador getReferenceById(UUID id);
	
}
