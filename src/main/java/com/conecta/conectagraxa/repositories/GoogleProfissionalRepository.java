package com.conecta.conectagraxa.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.conecta.conectagraxa.security.GoogleProfissional;

public interface GoogleProfissionalRepository extends JpaRepository<GoogleProfissional, Integer>{

	Optional<GoogleProfissional> findByEmail(String email);

}
