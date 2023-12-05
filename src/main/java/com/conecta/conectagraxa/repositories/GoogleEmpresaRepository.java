package com.conecta.conectagraxa.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.conecta.conectagraxa.security.GoogleEmpresa;

public interface GoogleEmpresaRepository extends JpaRepository<GoogleEmpresa, Integer>{

	Optional<GoogleEmpresa> findByEmail(String email);

}
