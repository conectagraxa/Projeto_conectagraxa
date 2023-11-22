package com.conecta.conectagraxa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.conecta.conectagraxa.service.DBService;

@Configuration
@Profile("dev")
public class DevConfig {

	
	
	@Autowired
	DBService service;

	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String value;

	@Bean
	public boolean instaciaDB() throws Exception {
		if (value.equals("create")/* || value.equals("update")*/) {
		this.service.instanciaDB();

		}
		return false;

	}

}
