package com.conecta.conectagraxa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conecta.conectagraxa.model.Feed_Profissional;
import com.conecta.conectagraxa.model.dto.Feed_ProfissionalDTO;
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
	
	
	//PROCURAR E NÃO ALTERAR INFORMAÇÕES
	public Feed_Profissional manterFeed(Integer id){
	Optional<Feed_Profissional> obj = repository.findById(id);
	if (obj.isPresent())
		obj.get().setId(obj.get().getId());
		obj.get().setIdProfissional(obj.get().getIdProfissional());
		obj.get().setPostagens(obj.get().getPostagens());
		obj.get().setSobre(obj.get().getSobre());
		obj.get().setHabilidades(obj.get().getHabilidades());
		Feed_Profissional newObj = obj.get();
		
		return repository.save(newObj);
	}
	//EDITAR SOBRE
	public Feed_Profissional createSobre(Integer id,Feed_ProfissionalDTO objDTO){
	Optional<Feed_Profissional> obj = repository.findById(id);
	if (obj.isPresent())

		obj.get().setId(obj.get().getId());
		obj.get().setIdProfissional(obj.get().getIdProfissional());
		obj.get().setPostagens(obj.get().getPostagens());
		obj.get().setSobre(objDTO.getSobre());
		obj.get().setHabilidades(obj.get().getHabilidades());
		Feed_Profissional newObj = obj.get();
		return repository.save(newObj);
		
	}
	
	


}
