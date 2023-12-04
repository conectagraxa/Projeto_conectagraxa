package com.conecta.conectagraxa.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.conecta.conectagraxa.security.SessaoLoginEmpresa;
import com.conecta.conectagraxa.security.SessaoLoginProfissional;

public interface SessaoLoginEmpresaRepository extends JpaRepository<SessaoLoginEmpresa, Integer>{

	//pesquisa se na tabela SessaoLoginProfissional existe o email informado.
	Optional<SessaoLoginEmpresa> findByEmail(String email);
	
	//pesquisa se na tabela SessaoLoginProfissional existe o token informado.
	
//	@Query("select p.token from profissional p where p.id = :id")
//	Optional<Profissional> findByToken(@Param("id") Long id);
	
	

	SessaoLoginProfissional findByLogado(boolean b);

}
