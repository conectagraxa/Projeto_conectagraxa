package com.conecta.conectagraxa.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.conecta.conectagraxa.model.Feed_Profissional;
import com.conecta.conectagraxa.model.Profissional;
import com.conecta.conectagraxa.model.dto.Feed_ProfissionalDTO;
import com.conecta.conectagraxa.model.dto.ProfissionalDTO;
import com.conecta.conectagraxa.repositories.Feed_ProfissionalRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class Feed_ProfissionalService {

	@Autowired
	private Feed_ProfissionalRepository repository;

	@Autowired
	ProfissionalService profissionalService;
	
	//busca por id
	public Feed_Profissional findById(Integer id) throws ObjectNotFoundException {
		Optional<Feed_Profissional> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("objeto não encontrado Id: " + id));
	}

	
	//lista todos os feeds dos profissionais
	public List<Feed_Profissional> getAllProfissional() {
	return repository.findAll();
	}
	
	//CRIAR SOBRE

	
	//EDITAR SOBRE 
	


}
