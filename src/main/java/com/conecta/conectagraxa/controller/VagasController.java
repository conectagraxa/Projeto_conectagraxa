package com.conecta.conectagraxa.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.conecta.conectagraxa.model.Postagens;
import com.conecta.conectagraxa.model.Vagas;
import com.conecta.conectagraxa.model.dto.PostagensDTO;
import com.conecta.conectagraxa.model.dto.VagasDTO;
import com.conecta.conectagraxa.service.VagasService;

@RestController
@RequestMapping(value = "/vagas")
public class VagasController {

	@Autowired
	private VagasService service;

	// CRIAR VAGA
	@PostMapping(value = "/create")
	public ResponseEntity<VagasDTO> create(@Valid @RequestBody VagasDTO objDTO) throws Exception {
	Vagas newObj = service.createVaga(objDTO, objDTO.getEmpresaId());
	URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
	return ResponseEntity.created(uri).build();
	}

	// EDITAR VAGA
	@PutMapping("/update-postagem/{id}")
	public ResponseEntity<VagasDTO> update(@PathVariable Integer id, @RequestBody @Valid VagasDTO objDTO)throws Exception {
	Vagas obj = service.editarVaga( objDTO,id);
	return ResponseEntity.ok().body(new VagasDTO(obj));
	}

	// FILTRAR VAGA CATEGORIA

	// LISTAR TODAS AS VAGAS POR NOME

	// DELETAR VAGA

	// EMPRESA VISUALIZAR CANDIDATURAS DA VAGA

	// PROFISSIONAL CANDIDATAR NA VAGA

	// PROFISSIONAL VISUALIZAR VAGAS CANDIDATADAS

	// EMPRESA VISUALIZAR FEED PROFISSIONAL CANDIDATADO NA VAGA

	// PROFISSIONAL VISUALIZAR FEED EMPRESA CANDIDATADA

}
