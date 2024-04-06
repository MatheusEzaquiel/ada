package com.ada.api.service;

import com.ada.api.domain.administrador.Administrador;
import com.ada.api.domain.administrador.dto.CreateAdministradorDTO;
import com.ada.api.domain.empresa.Empresa;
import com.ada.api.repository.AdministradorRepository;
import com.ada.api.repository.EmpresaRepository;
import org.apache.tomcat.util.http.fileupload.impl.FileSizeLimitExceededException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Service
public class AdministradorService {

    @Autowired
    AdministradorRepository adminRepos;
    @Autowired
    EmpresaRepository empresaRepos;
    @Autowired
    ImageService imageService;

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

}
