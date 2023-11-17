package com.conecta.conectagraxa.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.conecta.conectagraxa.model.Profissional;
import com.conecta.conectagraxa.model.Seguidores;

public interface SeguidoresRepository extends JpaRepository<Seguidores, Integer>{


	Optional<Seguidores> findBySeguindoId(Integer id);
	
    boolean existsBySeguidoresIdAndSeguindoId(Profissional seguidor, Profissional seguindo);

}
