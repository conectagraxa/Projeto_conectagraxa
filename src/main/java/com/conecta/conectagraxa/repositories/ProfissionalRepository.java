package com.conecta.conectagraxa.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.conecta.conectagraxa.model.Profissional;


@Repository
public interface ProfissionalRepository extends JpaRepository<Profissional, Integer> {

	Optional<Profissional> findByEmail(String email);

	Optional<Profissional> findById(Integer id);


	//@Query("select u.nome from profissional u where u.nome like '%nome%'")
	//public List<Profissional> searchUser(@Param("query") String query);
	//@Query("select profissional.token from profissional  where profissional.id = :id")


	
	Optional<Profissional> findByNomeIgnoreCaseContaining(String nome );
	Optional<Profissional> findBySenha(String senha);
	

	
}
