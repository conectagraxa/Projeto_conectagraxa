package com.conecta.conectagraxa.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.conecta.conectagraxa.service.DBService;



@Configuration
@Profile("test")

public class TestConfig {

	@Autowired
	DBService service;

	
	
	@Bean
	public void instaciaDB() throws Exception {
	this.service.instanciaDB();

		
	}		
	}


