package com.conecta.conectagraxa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.conecta.conectagraxa.model.Postagens;

@Repository
public interface PostagensRepository extends JpaRepository<Postagens, Integer>{

}
