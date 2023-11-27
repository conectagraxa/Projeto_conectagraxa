package com.conecta.conectagraxa.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.conecta.conectagraxa.model.Empresa;


public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {
	Optional<Empresa> findByCpfCnpj(String cpfCnpj);

	Optional<Empresa> findByEmail(String email);

	Optional<Empresa> findByNomeFantasiaIgnoreCaseContaining(String nome );
}
