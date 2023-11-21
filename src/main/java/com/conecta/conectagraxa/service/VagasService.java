package com.conecta.conectagraxa.service;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.conecta.conectagraxa.model.Categoria;
import com.conecta.conectagraxa.model.Empresa;
import com.conecta.conectagraxa.model.Feed_Empresa;
import com.conecta.conectagraxa.model.Vagas;
import com.conecta.conectagraxa.model.dto.VagasDTO;
import com.conecta.conectagraxa.repositories.CategoriaRepository;
import com.conecta.conectagraxa.repositories.VagasRepository;

@Service
public class VagasService {

	
	@Autowired
	VagasRepository repository;
	
	@Autowired
	CategoriaRepository cRepository;
	
	@Autowired
	EmpresaService empService;
	
	@Autowired
	CategoriaService cService;
	
	
	
	@Autowired
	Feed_EmpresaService feedService;
	
	//CRIAR VAGA
	public Vagas createVaga(VagasDTO obj, Integer id) throws Exception {
		//procurando se o id da empresa existe	
		Feed_Empresa feedEmpresa = feedService.findById(id);
		Empresa empresa = empService.findById(id);	
		
		Categoria categoria = cService.CategoriaById(obj.getCategoriaId());
		categoria.setId(obj.getCategoriaId());
		obj.setCategoriaId(obj.getCategoriaId());
		Vagas vagas = new Vagas(obj);
		
		//setando os dados passados no vagasDTO (Oque vai vai no corpo da requisição)
		vagas.setTitulo(obj.getTitulo());
		vagas.setFotoPath(obj.getFotoPath());
		vagas.setDescricao(obj.getDescricao());
		vagas.setCidade(obj.getCidade());
		vagas.setEstado(obj.getEstado());
		vagas.setDataPostagem(vagas.getDataPostagem());
		//seta feed e empresa
		vagas.setFeedEmpresaId(feedEmpresa);
		vagas.setEmpresaId(empresa);
		vagas.setCategoriaId(categoria);
		//adiciona a vaga setada no feed da empresa
		categoria.getVagas().add(vagas);
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
		Categoria categoria = cService.CategoriaById(obj.getCategoriaId());
		Vagas newObj = new Vagas();
		Optional <Vagas> vagas = repository.findById(id);
		if(vagas.isPresent()) {
		newObj.setId(vagas.get().getId());

		//leitura informações já existentes
		//recuperando e verificando se os dados encontrados no
		//banco estão vazios, se não estiver, pega a informação e mantém no newObj
		if (vagas.get().getCategoriaId() != null) {
			newObj.setCategoriaId(vagas.get().getCategoriaId());
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
		
		}if(vagas.get().getCategoriasUp() !=null) {
			newObj.setCategoriasUp(vagas.get().getCategoriasUp());
		}
		newObj.setDataPostagem(vagas.get().getDataPostagem());
		newObj.setFeedEmpresaId(vagas.get().getFeedEmpresaId());
		newObj.setEmpresaId(vagas.get().getEmpresaId());
		newObj.setCandidaturas(vagas.get().getCandidaturas());
		
		//input novas informações
		//recuperando e verificando se os campos do update na requisição
		//estão vazios, se não estiver, pega a informação e seta no newObj
		
		if (obj.getCategoriaId() != null) {
			newObj.setCategoriaId(categoria);
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
		}if(obj.getCategoriaId() !=null) {
			
			newObj.setCategoriasUp(obj.getCategoriaId());
		}
		
		
		//salva update no banco
		newObj = repository.save(newObj);
		//retorna um model vagas com valor atualizado
		}
		return newObj;
		
	}
	//FILTRAR VAGA CATEGORIA 
//	@Query("SELECT categoria FROM vagas WHERE categoria LIKE '%1%'")
	//@Query("select vagas.titulo from vagas where vagas.categoriaId = :categoriaId")
	@Transactional
	public List<Vagas> findCategoria(Integer categoriaId) throws Exception {
		Optional <Categoria> v1 = cRepository.findById(categoriaId);
	   // List<Vagas> obj = repository.findAll();
	    
	    
	    if (v1.isPresent()) {
	    	return	    //	repository.findByCategoriaIdContaining(v1.get());
	    	repository.findByCategoriasUp(categoriaId);

	    }
	    return new ArrayList<>();
	}

	
	
	// LISTAR VAGAS POR NOME
	@Transactional
	public Vagas findByTitulo(String titulo) throws Exception {
	Optional<Vagas> obj = repository.findByTituloIgnoreCaseContaining(titulo); 
	return obj.orElseThrow(() -> new Exception("objeto nome encontrado Nome: " + titulo ));
	}

	// DELETAR VAGA
	@Transactional
	public void delete(Integer id) throws Exception {
		Optional<Vagas> obj = repository.findById(id);

		if (obj.get().getId().equals(id)) {
			repository.deleteById(id);
		} else {
			throw new Exception("Vaga não encontrada");
		}

	}


}
