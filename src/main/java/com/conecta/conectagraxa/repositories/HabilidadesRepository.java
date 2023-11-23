package com.conecta.conectagraxa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.conecta.conectagraxa.model.Habilidades;

public interface HabilidadesRepository extends JpaRepository<Habilidades, Integer>{

	
/*	@Modifying
	@Query(value = "insert into Habilidades (nomeHabilidade) values (:nomeHabilidade)",  nativeQuery = true)
	void saveAll(@Param("nomeHabilidade") List<Habilidades> nomeHabilidade);*/

}
