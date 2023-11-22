package com.conecta.conectagraxa.security;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.conecta.conectagraxa.model.Profissional;

public interface SessaoLoginProfissionalRepository extends JpaRepository<SessaoLoginProfissional, Integer>{

	//pesquisa se na tabela SessaoLoginProfissional existe o email informado.
	Optional<SessaoLoginProfissional> findByEmail(String email);
	
	//pesquisa se na tabela SessaoLoginProfissional existe o token informado.
	Optional<SessaoLoginProfissional> findByToken(String string);

}
