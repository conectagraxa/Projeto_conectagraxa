package com.conecta.conectagraxa.service;



import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conecta.conectagraxa.model.Empresa;
import com.conecta.conectagraxa.model.Feed_Empresa;
import com.conecta.conectagraxa.model.Postagens;
import com.conecta.conectagraxa.model.Vagas;
import com.conecta.conectagraxa.model.dto.VagasDTO;
import com.conecta.conectagraxa.repositories.VagasRepository;

@Service
public class VagasService {

	
	@Autowired
	VagasRepository repository;
	
	@Autowired
	EmpresaService empService;
	
	
	@Autowired
	Feed_EmpresaService feedService;
	
	//CRIAR VAGA
	public Vagas createVaga(VagasDTO obj, Integer id) throws Exception {
		//procurando se o id da vaga e empresa existe	
		Feed_Empresa feedEmpresa = feedService.findById(id);
		Empresa empresa = empService.findById(id);			
		Vagas vagas = new Vagas(obj);

		//setando os dados passados no vagasDTO (Oque vai vai no corpo da requisição)
		vagas.setCategoria(obj.getCategoria());;
		vagas.setTitulo(obj.getTitulo());
		vagas.setFotoPath(obj.getFotoPath());
		vagas.setDescricao(obj.getDescricao());
		vagas.setCidade(obj.getCidade());
		vagas.setEstado(obj.getEstado());
		vagas.setDataPostagem(vagas.getDataPostagem());
		//seta feed e empresa
		vagas.setFeedEmpresaId(feedEmpresa);
		vagas.setEmpresaId(empresa);
		//adiciona a vaga setada no feed da empresa
		feedEmpresa.getVagas().add(vagas);
		//salva no banco
		Vagas newObj = repository.save(vagas);

		//retorna um model vagas com valor atualizado
		return newObj;
	
	}


	// EDITAR VAGA
	public Vagas editarVaga(VagasDTO obj, Integer id) throws Exception {
		//procurando se o id da vaga e empresa existe	
		Feed_Empresa feedEmpresa = feedService.findById(id);
		Empresa empresa = empService.findById(id);
		Vagas newObj = new Vagas();
		Optional <Vagas> vagas = repository.findById(id);
		if(vagas.isPresent()) {
		newObj.setId(vagas.get().getId());

		//leitura informações já existentes
		//recuperando e verificando se os dados encontrados no
		//banco estão vazios, se não estiver, pega a informação e mantém no newObj
		if (vagas.get().getCategoria() != null) {
			newObj.setCategoria(vagas.get().getCategoria());
		}
		if (vagas.get().getTitulo() != null) {
			newObj.setTitulo(vagas.get().getTitulo());
		}
		if (vagas.get().getFotoPath() != null) {
			newObj.setFotoPath(vagas.get().getFotoPath());
		}
		if (vagas.get().getDescricao() != null) {
			newObj.setDescricao(vagas.get().getDescricao());
		}
		if (vagas.get().getCidade() != null) {
			newObj.setCidade(vagas.get().getCidade());
		}
		if (vagas.get().getEstado() != null) {
			newObj.setEstado(vagas.get().getEstado());
		}
		newObj.setDataPostagem(vagas.get().getDataPostagem());
		newObj.setFeedEmpresaId(vagas.get().getFeedEmpresaId());
		newObj.setEmpresaId(vagas.get().getEmpresaId());
		newObj.setCandidaturas(vagas.get().getCandidaturas());
		
		//input novas informações
		//recuperando e verificando se os campos do update na requisição
		//estão vazios, se não estiver, pega a informação e seta no newObj
		if (obj.getCategoria() != null) {
			newObj.setCategoria(obj.getCategoria());
		}
		if (obj.getTitulo() != null) {
			newObj.setTitulo(obj.getTitulo());
		}
		if (obj.getFotoPath() != null) {
			newObj.setFotoPath(obj.getFotoPath());
		}
		if (obj.getDescricao() != null) {
			newObj.setDescricao(obj.getDescricao());
		}
		if (obj.getCidade() != null) {
			newObj.setCidade(obj.getCidade());
		}
		if (obj.getEstado() != null) {
			newObj.setEstado(obj.getEstado());
		}
		
		//salva update no banco
		newObj = repository.save(newObj);
		//retorna um model vagas com valor atualizado
		}
		return newObj;
		
	}

	// FILTRAR VAGA CATEGORIA
	
	
	
	// LISTAR VAGAS POR NOME
	@Transactional
	public Vagas findByTitulo(String titulo) throws Exception {
	Optional<Vagas> obj = repository.findByTituloIgnoreCaseContaining(titulo); 
	return obj.orElseThrow(() -> new Exception("objeto nome encontrado Nome: " + titulo ));
	}

	// DELETAR VAGA
	public void delete(Integer id) throws Exception {
		Optional<Vagas> obj = repository.findById(id);

		if (obj.get().getId().equals(id)) {
			repository.deleteById(id);
		} else {
			throw new Exception("Vaga não encontrada");
		}

	}


}
