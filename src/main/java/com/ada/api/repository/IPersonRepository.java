package com.ada.api.domain.person;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.security.core.userdetails.UserDetails;

public interface IPersonRepository extends JpaRepository<Person, UUID>{
	
	//UserDetails findByLogin(String login);
	Person findByLogin(String login);
	
}
