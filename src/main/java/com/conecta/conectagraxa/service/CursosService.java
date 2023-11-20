package com.conecta.conectagraxa.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conecta.conectagraxa.model.Cursos;
import com.conecta.conectagraxa.model.Feed_Profissional;
import com.conecta.conectagraxa.model.dto.CursosDTO;
import com.conecta.conectagraxa.repositories.CursosRepository;
@Service
public class CursosService {
	@Autowired
	Feed_ProfissionalService feedService;

	@Autowired
	CursosRepository repository;
	
	public Cursos createCurso(CursosDTO objDTO) throws Exception {
	  Cursos cursos = new Cursos();
	  Feed_Profissional feed = feedService.findById(objDTO.getFeedProfissionalId());		

	  validaPorData(objDTO);
      feed.setId(objDTO.getFeedProfissionalId());
      
      cursos.setFeedProfissionalId(feed);
      
      
      cursos.setTitulo(objDTO.getTitulo());
      cursos.setInicio(objDTO.getInicio());
      cursos.setInstituicao(objDTO.getInstituicao());
      cursos.setFim(objDTO.getFim());
      
     Cursos novoCurso = repository.save(cursos);

     return novoCurso;
	}


public List<Cursos> getAllCursos() {
	return repository.findAll();
	}


//cursos update
public Cursos update( Integer id, @Valid CursosDTO objDTO) throws Exception {
	objDTO.setId(id);
	Optional<Cursos> obj = repository.findById(id);
	Cursos newObj = new Cursos();
	validaPorData(objDTO);

	if (obj.isPresent()) {

	newObj.setId(obj.get().getId());
	newObj.setFeedProfissionalId(obj.get().getFeedProfissionalId());

	if (obj.get().getTitulo() != null) {
		newObj.setTitulo(obj.get().getTitulo());
	}
	if (obj.get().getInstituicao() != null) {
		newObj.setInstituicao(obj.get().getInstituicao());
	}
	
	if (obj.get().getInicio() != null) {
		newObj.setInicio(obj.get().getInicio());
	}
	
	if (obj.get().getFim() != null) {
		newObj.setFim(obj.get().getFim());
	}
	

	// atualiza os campos do objeto com os valores preenchidos no body do objeto DTO
	if (objDTO.getTitulo() != null) {
		newObj.setTitulo(objDTO.getTitulo());
	}
	if (objDTO.getInstituicao() != null) {
		newObj.setInstituicao(objDTO.getInstituicao());
	}

	if (objDTO.getInicio() != null) {
		newObj.setInicio(objDTO.getInicio());
	}
	if (objDTO.getFim() != null) {
		newObj.setFim(objDTO.getFim());
	}

	}
	

	
Cursos old = (newObj);
Cursos atualizado = repository.save(old);
return atualizado;
}




//validação se a data de inicio é menor que o término
private void validaPorData(CursosDTO objDTO) throws Exception {
	if (objDTO.getInicio().after( objDTO.getFim()) ) {
		throw new Exception("A data de inicio do curso deve ser menor que o fim! ");
	}
}



}