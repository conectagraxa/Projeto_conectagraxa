package com.conecta.conectagraxa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conecta.conectagraxa.model.Feed_Empresa;
import com.conecta.conectagraxa.model.dto.Feed_EmpresaDTO;
import com.conecta.conectagraxa.repositories.Feed_EmpresaRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class Feed_EmpresaService {

	@Autowired
	private Feed_EmpresaRepository repository;

	@Autowired
	EmpresaService empresaService;

	// lista todos os feeds dos profissionais
	public List<Feed_Empresa> getAllProfissional() {
		return repository.findAll();
	}

	// busca por id
	public Feed_Empresa findById(Integer id) throws ObjectNotFoundException {
	Optional<Feed_Empresa> obj = repository.findById(id);
	return obj.orElseThrow(() -> new ObjectNotFoundException("objeto não encontrado Id: " + id));
	}

	// EDITAR SOBRE
	public Feed_Empresa createSobre(Integer id, Feed_EmpresaDTO objDTO) {
		Optional<Feed_Empresa> obj = repository.findById(id);
		if (obj.isPresent())

			obj.get().setId(obj.get().getId());
		obj.get().setIdEmpresa(obj.get().getIdEmpresa());
		obj.get().setVagas(obj.get().getVagas());
		obj.get().setSobre(objDTO.getSobre());
		Feed_Empresa newObj = obj.get();
		return repository.save(newObj);

	}
}
