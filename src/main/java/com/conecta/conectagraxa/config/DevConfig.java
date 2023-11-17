package com.conecta.conectagraxa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.conecta.conectagraxa.service.DBService;
import org.springframework.beans.factory.annotation.Value;


@Configuration
@Profile ("dev")
public class DevConfig {

	

		
	
		
		@Value ("${spring.jpa.hibernate.ddl-auto}")
		private String value;
		
		/*@Bean
		public boolean instaciaDB() {
			if(value.equals("create") || value.equals("update")) {
			}
			return false;

			
		}*/
			
		}

