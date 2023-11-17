package com.conecta.conectagraxa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conecta.conectagraxa.model.Feed_Empresa;
import com.conecta.conectagraxa.repositories.Feed_EmpresaRepository;


@Service
public class Feed_EmpresaService {

	@Autowired
	private Feed_EmpresaRepository repository;

	@Autowired
	EmpresaService empresaService;
	

	//lista todos os feeds dos profissionais
	public List<Feed_Empresa> getAllProfissional() {
	return repository.findAll();
	}

	//busca por id

	
	//EDITAR SOBRE 

	//CRIAR SOBRE
}
