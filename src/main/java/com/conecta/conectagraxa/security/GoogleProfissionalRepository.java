package com.conecta.conectagraxa.security;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GoogleProfissionalRepository extends JpaRepository<GoogleProfissional, Integer>{

	Optional<GoogleProfissional> findByEmail(String email);

}
