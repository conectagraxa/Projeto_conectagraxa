package com.conecta.conectagraxa.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.conecta.conectagraxa.security.SessaoLoginProfissional;

public interface SessaoLoginProfissionalRepository extends JpaRepository<SessaoLoginProfissional, Integer>{

	//pesquisa se na tabela SessaoLoginProfissional existe o email informado.
	Optional<SessaoLoginProfissional> findByEmail(String email);
	
	//pesquisa se na tabela SessaoLoginProfissional existe o token informado.
	
//	@Query("select p.token from profissional p where p.id = :id")
//	Optional<Profissional> findByToken(@Param("id") Long id);
	
	

	SessaoLoginProfissional findByLogado(boolean b);

}
