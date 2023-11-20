package com.conecta.conectagraxa.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.conecta.conectagraxa.model.Vagas;

@Repository
public interface VagasRepository extends JpaRepository<Vagas, Integer> {

	
	Optional<Vagas> findByTituloIgnoreCaseContaining(String titulo);

}
