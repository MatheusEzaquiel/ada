package com.ada.api.repository;

import com.ada.api.domain.empresa.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface EmpresaRepository extends JpaRepository<Empresa, UUID> {
    List<Empresa> findByAtivo(Boolean isEnabled);
    Empresa findByNome(String nomeEmpresa);
    Empresa findByCnpj(String cnpj);
}


