package com.conecta.conectagraxa.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.conecta.conectagraxa.service.DBService;



@Configuration
@Profile("test")

public class TestConfig {

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
	


