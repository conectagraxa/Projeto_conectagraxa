package com.conecta.conectagraxa;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@ComponentScan("com.conecta.conectagraxa.repositories")
/*
 * Essa é a classe executável do projeto
 */
//@ComponentScan("com.conecta.conectagraxa.services")
@EnableJpaRepositories("com.conecta.conectagraxa.repositories")
@EnableSwagger2 //habilitando a api do swagger
@SpringBootApplication(exclude = SecurityAutoConfiguration.class) //desativando configurações de segurança do spring security
 //habilitando repositórios que extendem o jpa
public class ConectagraxaApplication {

	/*
	 * aqui, para ser possível chamar a classe PasswordEncoder , já que é uma classe que não é nossa
	 * e faz parte do Spring, coloco esse @Bean e agora ele pode ser "instânciado" ou na linguagem
	 * spring = injetado , mesmo sem ter um construtor, chamando com o @Autowired (digo que estou injetando
	 * uma classe e quero ter acesso a todos os atributos e métodos) exemplo : Consultar as classes
	 * @param ProfissionalService 
	 * @param EmpresaService
	 */
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	
	public static void main(String[] args) {
		SpringApplication.run(ConectagraxaApplication.class, args);
	}
}
