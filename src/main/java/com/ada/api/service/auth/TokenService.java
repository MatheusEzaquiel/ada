package com.ada.api.service.auth;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ada.api.domain.person.Person;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;

@Service
public class TokenService {
	
    @Value("${api.security.token.secret}")
    
    private String secret;

    public String generateToken(Person person){
    	
        try{
        	
            Algorithm algorithm = Algorithm.HMAC256(secret);
            
            String token = JWT.create()
                    .withIssuer("auth-api")
                    .withSubject(person.getLogin())
                    .withExpiresAt(genExpirationDate())
                    .sign(algorithm);
            
            return token;
            
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Error while generating token", exception);
        }
    }

    public String validateToken(String token){
    	
        try {
        	
            Algorithm algorithm = Algorithm.HMAC256(secret);
            
            return JWT.require(algorithm)
                    .withIssuer("auth-api")
                    .build()
                    .verify(token)
                    .getSubject();
            
        } catch (JWTVerificationException e){
            return "Error: " + e.getMessage();
        }
        
    }

    private Instant genExpirationDate(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}