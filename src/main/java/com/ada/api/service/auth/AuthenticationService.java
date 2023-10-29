package com.ada.api.service.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ada.api.domain.administrador.AdministradorRepository;
import com.ada.api.domain.funcionario.FuncionarioRepository;

@Service
public class AuthenticationService implements UserDetailsService{
	
	@Autowired
    FuncionarioRepository funcionarioRepos;
	
	@Autowired
    AdministradorRepository adminRepos;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserDetails user = funcionarioRepos.findByLogin(username);
		
		if(user == null) return adminRepos.findByLogin(username);
		
		return user;
		
	}

}
