package com.ada.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ada.api.domain.auth.LoginDTO;
import com.ada.api.domain.auth.LoginResponseDTO;
import com.ada.api.domain.funcionario.Funcionario;
import com.ada.api.domain.person.Person;
import com.ada.api.service.auth.TokenService;


@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	TokenService tokenService;
	
	@PostMapping("/login")
	public ResponseEntity login(@RequestBody LoginDTO data) {
	
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(data.login(), data.senha());
		
		Authentication authenticate = this.authenticationManager.authenticate(usernamePasswordAuthenticationToken);
		
		Person person = (Person) authenticate.getPrincipal();
		
		LoginResponseDTO token = new LoginResponseDTO(person.getId(), person.getRole(), tokenService.generateToken(person));
		
		return ResponseEntity.status(HttpStatus.OK).body(token);
		
	}
	
}
