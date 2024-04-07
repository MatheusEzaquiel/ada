package com.ada.api.service;

import com.ada.api.domain.empresa.Empresa;
import com.ada.api.domain.empresa.dto.CreateEmpresaDTO;
import com.ada.api.domain.empresa.dto.DetailEmpresaDTO;
import com.ada.api.domain.empresa.dto.ListEmpresaDTO;
import com.ada.api.domain.empresa.dto.UpdateEmpresaDTO;
import com.ada.api.repository.EmpresaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmpresaService {

    @Autowired
    EmpresaRepository empresaRepos;


    public List<ListEmpresaDTO> list() {

        return empresaRepos.findAll()
                .stream()
                .map(ListEmpresaDTO::new)
                .toList();

    }

    public List<ListEmpresaDTO> listEnabled() {

        return empresaRepos.findByAtivo(true)
                .stream()
                .map(ListEmpresaDTO::new)
                .toList();

    }


    public DetailEmpresaDTO detail(UUID id) {

        try {

            Optional<Empresa> empresaOpt = empresaRepos.findById(id);

            if(empresaOpt.isPresent()) {
                return new DetailEmpresaDTO(empresaOpt.get());
            }

            throw new RuntimeException("Empresa not found: ");

        } catch (Exception ex) {
            throw new RuntimeException("Error to get one: " + ex.getMessage());
        }

    }

    public DetailEmpresaDTO create(CreateEmpresaDTO data) {

        try {

            Optional<Empresa> empresaOpt = Optional.ofNullable(empresaRepos.findByNome(data.nome()));
            Optional<Empresa> empresaOptCnpj = Optional.ofNullable(empresaRepos.findByCnpj(data.cnpj()));

            if(empresaOpt.isEmpty() && empresaOptCnpj.isEmpty()) {
                Empresa empresaToCreate = new Empresa(data);
                return new DetailEmpresaDTO(empresaRepos.save(empresaToCreate)) ;
            }

            throw new RuntimeException("Empresa alredy exist");

        } catch (Exception ex) {
            throw new RuntimeException("Error to save: " + ex.getMessage());
        }

    }

    @Transactional
    public DetailEmpresaDTO update(UUID id, UpdateEmpresaDTO data) {
        try {

            Optional<Empresa> empresaOpt = empresaRepos.findById(id);

            if (empresaOpt.isPresent()) {

                Empresa empresaToUpdate = empresaOpt.get();

                if(data.cnpj() != null) empresaToUpdate.setCnpj(data.cnpj());
                if(data.nome() != null) empresaToUpdate.setNome(data.nome());
                if(data.dominio() != null) empresaToUpdate.setDominio(data.dominio());
                if(data.areaAtuacao() != null) empresaToUpdate.setAreaAtuacao(data.areaAtuacao());
                if(data.ssid() != null) empresaToUpdate.setSsid(data.ssid());
                if(data.numero() != null) empresaToUpdate.setNumero(data.numero());
                if(data.rua() != null) empresaToUpdate.setRua(data.rua());
                if(data.bairro() != null) empresaToUpdate.setBairro(data.bairro());
                if(data.cidade() != null) empresaToUpdate.setCidade(data.cidade());
                if(data.uf() != null) empresaToUpdate.setUf(data.uf());
                if(data.pais() != null) empresaToUpdate.setPais(data.pais());
                if(data.ativo() != null) empresaToUpdate.setAtivo(data.ativo());

                return new DetailEmpresaDTO(empresaRepos.save(empresaToUpdate));

            }

            throw new RuntimeException("Empresa with this id not found: ");

        } catch (Exception ex) {
            throw new RuntimeException("Error to update: " + ex.getMessage());
        }
    }

    @Transactional
    public DetailEmpresaDTO delete(UUID id) {
        try {

            Optional<Empresa> empresaOpt = empresaRepos.findById(id);

            if (empresaOpt.isPresent()) {
                Empresa empresa = empresaOpt.get();
                empresa.setAtivo(false);

                return new DetailEmpresaDTO(empresaRepos.save(empresa));
            }

            throw new RuntimeException("Empresa with this id not found: ");

        } catch (Exception ex) {
            throw new RuntimeException("Error to delete: " + ex.getMessage());
        }
    }

}
