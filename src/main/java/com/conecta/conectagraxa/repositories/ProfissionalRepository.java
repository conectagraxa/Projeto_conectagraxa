package com.conecta.conectagraxa.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.conecta.conectagraxa.model.Profissional;

public interface ProfissionalRepository extends JpaRepository<Profissional, Integer> {

	Optional<Profissional> findByEmail(String email);

	Optional<Profissional> findById(Integer id);


	//@Query("select u.nome from profissional u where u.nome like '%nome%'")
	//public List<Profissional> searchUser(@Param("query") String query);

	Optional<Profissional> findByNomeIgnoreCaseContaining(String nome );
	Optional<Profissional> findBySenha(String senha );
	

	
}
