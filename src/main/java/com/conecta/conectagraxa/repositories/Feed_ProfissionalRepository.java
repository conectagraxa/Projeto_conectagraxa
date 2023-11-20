package com.conecta.conectagraxa.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.conecta.conectagraxa.model.Feed_Profissional;


public interface Feed_ProfissionalRepository extends JpaRepository<Feed_Profissional, Integer>{

	
	
	
	Optional<Feed_Profissional> findById(Integer id);

	Feed_Profissional save(Optional<Feed_Profissional> obj);

}
