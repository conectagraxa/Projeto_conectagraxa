package com.conecta.conectagraxa;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@ComponentScan("com.conecta.conectagraxa.repositories")

@EnableSwagger2
@SpringBootApplication
@EnableJpaRepositories
public class ConectagraxaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConectagraxaApplication.class, args);
	}
}
