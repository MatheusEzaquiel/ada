package com.ada.api.infra.security;

import java.io.IOException;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.ada.api.domain.administrador.AdministradorRepository;
import com.ada.api.domain.funcionario.Funcionario;
import com.ada.api.domain.funcionario.FuncionarioRepository;
import com.ada.api.domain.funcionario.Funcionario;
import com.ada.api.domain.person.IPersonRepository;
import com.ada.api.service.auth.TokenService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SecurityFilter extends OncePerRequestFilter {
	
    @Autowired
    TokenService tokenService;
    
    @Autowired
    IPersonRepository personRepos;
    
	@Autowired
    FuncionarioRepository funcionarioRepos;
	
	@Autowired
    AdministradorRepository adminRepos;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        
    	var token = this.recoverToken(request);
    	
        if(token != null){
        	
            var login = tokenService.validateToken(token);
            
            try {
            	
            	  UserDetails user = adminRepos.findByLogin(login);
                  
          		
          		if(user == null) {
          			
          			user = funcionarioRepos.findByLogin(login);
          		}
 
                  
                  var authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
                  
                  SecurityContextHolder.getContext().setAuthentication(authentication);
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
            
          
            
        }
        
        filterChain.doFilter(request, response);
        
    }

    private String recoverToken(HttpServletRequest request){
    	
        var authHeader = request.getHeader("Authorization");
        
        if(authHeader == null) return null;
        
        return authHeader.replace("Bearer ", "");
        
    }
}