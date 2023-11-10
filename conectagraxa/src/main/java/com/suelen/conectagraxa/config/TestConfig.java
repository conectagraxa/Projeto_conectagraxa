package com.suelen.conectagraxa.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.suelen.conectagraxa.resources.EditaisResource;
import com.suelen.conectagraxa.service.DBService;


@Configuration
@Profile("test")
public class TestConfig {
	
	@Autowired
	private DBService er;
	
	@Bean
	public void instaciaDB() throws IOException {
		this.er.instanciaDB();;
	}

}

