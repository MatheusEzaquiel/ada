package com.ada.api.repository;

import com.ada.api.domain.cargo.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CargoRepository extends JpaRepository<Cargo, UUID> {

}
