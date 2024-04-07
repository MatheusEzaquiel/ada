package com.ada.api.service;

import com.ada.api.domain.administrador.Administrador;
import com.ada.api.domain.administrador.dto.CreateAdministradorDTO;
import com.ada.api.domain.administrador.dto.DetailAdministradorDTO;
import com.ada.api.domain.administrador.dto.ListAdministradorDTO;
import com.ada.api.domain.administrador.dto.UpdateAdministradorDTO;
import com.ada.api.domain.empresa.Empresa;
import com.ada.api.repository.AdministradorRepository;
import com.ada.api.repository.EmpresaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AdministradorService {

    @Autowired
    AdministradorRepository adminRepos;
    @Autowired
    EmpresaRepository empresaRepos;
    @Autowired
    ImageService imageService;

    public List<ListAdministradorDTO> list() {

        List<ListAdministradorDTO> admins = adminRepos.findAll()
                .stream()
                .map(admin -> new ListAdministradorDTO(admin, imageService.getImage(admin.getFoto(), "admin")))
                .toList();

        return admins;

    }

    public List<ListAdministradorDTO> listEnabled() {

        List<ListAdministradorDTO> admins = adminRepos.findByAtivo(true)
                .stream()
                .map(admin -> new ListAdministradorDTO(admin, imageService.getImage(admin.getFoto(), "admin")))
                .toList();

        return admins;

    }

    public DetailAdministradorDTO detail(UUID id) {

        try {

            Optional<Administrador> adminOptional = adminRepos.findById(id);

            if(adminOptional.isEmpty()) throw new RuntimeException("Admin not found: ");


            String linkFoto = imageService.getImage(adminOptional.get().getFoto(), "admin");

            DetailAdministradorDTO adminDTO = new DetailAdministradorDTO(adminOptional.get(), linkFoto);

            return adminDTO;

        } catch (Exception ex) {
            throw new RuntimeException("Error to get one: " + ex.getMessage());
        }

    }

    public Administrador save(CreateAdministradorDTO data, MultipartFile foto, UUID empresaId) {

        try {

            Empresa empresa = empresaRepos.getReferenceById(empresaId);
            /*
            String encryptedPassword = new BCryptPasswordEncoder().encode(data.senha());
            String encryptedPassword = data.senha();*/

            String imagem = imageService.saveImage(foto, "admin");

            Administrador admin = new Administrador(data, data.senha(), imagem, empresa);

            admin.setLogin(admin.getLogin() + empresa.getDominio());

            //ListAdministradorDTO adminDTO = new ListAdministradorDTO(adminCreated, imageService.getImage(adminCreated.getFoto(), "admin"));

            return adminRepos.save(admin);

        } catch (Exception ex) {
            throw new RuntimeException("Error to save: " + ex.getMessage());
        }

    }

    @Transactional
    public DetailAdministradorDTO update(UUID id, UpdateAdministradorDTO data) {
        try {

            Administrador admin = adminRepos.getReferenceById(id);

            if (admin == null) throw new RuntimeException("Admin with this id not found: ");


            if(data.login() != null) {
                admin.setLogin(data.login() + admin.getEmpresa().getDominio());
            }
            if(data.apelido() != null) admin.setApelido(data.apelido());
            if(data.nomeCompleto() != null) admin.setNomeCompleto(data.nomeCompleto());
            if(data.email() != null) admin.setEmail(data.email());
            if(data.telefone() != null) admin.setTelefone(data.telefone());
            if(data.senha() != null) admin.setSenha(data.senha());
            if(data.foto() != null) System.out.println("atualizar foto...");
            if(data.ativo() != null) admin.setAtivo(data.ativo());
            if(data.role() != null) admin.setRole(data.role());
            if(data.empresaId() != null) {

                Optional<Empresa> empresaOpt = empresaRepos.findById(data.empresaId());

                if(empresaOpt.isPresent()) {
                    admin.setEmpresa(empresaOpt.get());
                    admin.setLogin(data.login() + empresaOpt.get().getDominio());
                }

            }

            DetailAdministradorDTO adminUpdated = new DetailAdministradorDTO(adminRepos.save(admin), admin.getFoto());

            return adminUpdated;

        } catch (Exception ex) {
            throw new RuntimeException("Error to update: " + ex.getMessage());
        }
    }

    @Transactional
    public DetailAdministradorDTO delete(UUID id) {
        try {

            Optional<Administrador> adminOpt = adminRepos.findById(id);

            if (adminOpt.isPresent()) {

               Administrador admin = adminOpt.get();
               admin.setAtivo(false);

               DetailAdministradorDTO adminDTO = new DetailAdministradorDTO(adminRepos.save(admin), admin.getFoto());

               return adminDTO;
            }

            throw new RuntimeException("Admin with this id not found: ");

        } catch (Exception ex) {
            throw new RuntimeException("Error to delete: " + ex.getMessage());
        }
    }

}
