package com.conecta.conectagraxa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.conecta.conectagraxa.model.Habilidades;
import com.conecta.conectagraxa.model.dto.HabilidadesDTO;

public interface HabilidadesRepository extends JpaRepository<Habilidades, Integer>{

	
/*	@Modifying
	@Query(value = "insert into Habilidades (nomeHabilidade) values (:nomeHabilidade)",  nativeQuery = true)
	void saveAll(@Param("nomeHabilidade") List<Habilidades> nomeHabilidade);*/

}
