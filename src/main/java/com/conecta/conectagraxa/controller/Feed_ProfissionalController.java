package com.conecta.conectagraxa.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.conecta.conectagraxa.model.Cursos;
import com.conecta.conectagraxa.model.Feed_Profissional;
import com.conecta.conectagraxa.model.dto.CursosDTO;
import com.conecta.conectagraxa.model.dto.Feed_ProfissionalDTO;
import com.conecta.conectagraxa.service.CursosService;
import com.conecta.conectagraxa.service.Feed_ProfissionalService;
import com.conecta.conectagraxa.service.HabilidadesService;

@RestController
@RequestMapping(value = "/feedprofissional")
public class Feed_ProfissionalController {

	@Autowired
	private Feed_ProfissionalService service;
	@Autowired
	private CursosService cursosService;
	@Autowired
	private HabilidadesService habilidadesService;

	// Listar feeds
	@GetMapping(value = "/feeds")
	ResponseEntity<List<Feed_ProfissionalDTO>> findAll() {
		List<Feed_Profissional> list = service.getAllProfissional();
		List<Feed_ProfissionalDTO> listDTO = list.stream().map(obj -> new Feed_ProfissionalDTO(obj)).collect(Collectors.toList());
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
		return ResponseEntity.ok().body(new CursosDTO(newObj));

	}

	// update cursos
	@PutMapping("/update-curso/{id}")
	public ResponseEntity<CursosDTO> update(@PathVariable Integer id, @RequestBody @Valid CursosDTO objDTO)
			throws Exception {
		Cursos obj = cursosService.update(id, objDTO);
		return ResponseEntity.ok().body(new CursosDTO(obj));
	}

	// EDITAR FEED SOBRE
	@PutMapping(value = "/update-sobre/{id}")
	public ResponseEntity<Feed_ProfissionalDTO> updateSobre(@PathVariable Integer id,@Valid @RequestBody Feed_ProfissionalDTO objDTO) throws Exception {
		Feed_Profissional newObj = service.createSobre(id, objDTO);
		return ResponseEntity.ok().body(new Feed_ProfissionalDTO(newObj));

	}

	// CRIAR HABILIDADE
	@PostMapping("/submit")
	public String submitForm(@RequestParam String habilidade) {
		habilidadesService.escolherHabilidade(1, habilidade); // 1 é o id do feed, será substituida pelo
															// sessaoLoginProfissional.id
		return "/habilidade-adicionada";
	}

}
