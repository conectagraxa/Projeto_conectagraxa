package com.conecta.conectagraxa.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.conecta.conectagraxa.model.Cursos;
import com.conecta.conectagraxa.model.Feed_Profissional;
import com.conecta.conectagraxa.model.dto.CursosDTO;
import com.conecta.conectagraxa.model.dto.Feed_ProfissionalDTO;
import com.conecta.conectagraxa.service.CursosService;
import com.conecta.conectagraxa.service.Feed_ProfissionalService;

@RestController
@RequestMapping(value = "/feedprofissional")
public class Feed_ProfissionalController {

	@Autowired
	private Feed_ProfissionalService service;
	@Autowired
	private CursosService cursosService;
	
	// Listar feeds
	@GetMapping(value = "/feeds")
	ResponseEntity<List<Feed_ProfissionalDTO>> findAll() {
		List<Feed_Profissional> list = service.getAllProfissional();
		List<Feed_ProfissionalDTO> listDTO = list.stream().map(obj -> new Feed_ProfissionalDTO(obj))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	// Listar cursos
	@GetMapping(value = "/cursos")
	ResponseEntity<List<CursosDTO>> findAllCursos() {
		List<Cursos> list = cursosService.getAllCursos();
		List<CursosDTO> listDTO = list.stream().map(obj -> new CursosDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	// Criar cursos
	@PostMapping(value = "/criar-curso")
	public ResponseEntity<CursosDTO> create(@Valid @RequestBody CursosDTO objDTO) throws Exception {
		Cursos newObj = cursosService.createCurso(objDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	// update cursos
	@PutMapping("/update-curso/{id}")
	public ResponseEntity<CursosDTO> update(@PathVariable Integer id, @RequestBody @Valid CursosDTO objDTO)
			throws Exception {
		Cursos obj = cursosService.update(id, objDTO);
		return ResponseEntity.ok().body(new CursosDTO(obj));
	}

	//EDITAR FEED SOBRE
	
	//LISTAR HABILIDADES PRÉ DEFINIDAS NA LISTA
	
	//SELECIONAR HABILIDADE
	


}
