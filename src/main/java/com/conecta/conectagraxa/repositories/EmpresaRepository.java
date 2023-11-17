package com.conecta.conectagraxa.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.conecta.conectagraxa.model.Empresa;
import com.conecta.conectagraxa.model.Profissional;


@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {
	Optional<Empresa> findByCpfCnpj(String cpfCnpj);

	Optional<Empresa> findByEmail(String email);

	Optional<Empresa> findByNomeFantasiaIgnoreCaseContaining(String nome );
}
