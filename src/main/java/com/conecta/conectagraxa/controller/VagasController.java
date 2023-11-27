package com.conecta.conectagraxa.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.conecta.conectagraxa.model.Vagas;
import com.conecta.conectagraxa.model.dto.VagasDTO;
import com.conecta.conectagraxa.service.CategoriaService;
import com.conecta.conectagraxa.service.VagasService;

@RestController
@RequestMapping(value = "/vagas")
public class VagasController {

	@Autowired
	private VagasService service;

	@Autowired
	CategoriaService cService;
	
	// CRIAR VAGA
	@PostMapping(value = "/create")
	public ResponseEntity<VagasDTO> create(@Valid @RequestBody VagasDTO objDTO) throws Exception {
	Vagas newObj = service.createVaga(objDTO, objDTO.getEmpresaId());
	URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
	return ResponseEntity.created(uri).build();
	}
	
	@GetMapping(value = "/findAll")
	ResponseEntity<List<VagasDTO>> findAll() {
		List<Vagas> list = service.getAllVagas();
		List<VagasDTO> listDTO = list.stream().map(obj -> new VagasDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	// EDITAR VAGA
	@PutMapping("/update-vaga/{id}")
	public ResponseEntity<VagasDTO> update(@PathVariable Integer id, @RequestBody @Valid VagasDTO objDTO)throws Exception {
	Vagas obj = service.editarVaga( objDTO,id);
	return ResponseEntity.ok().body(new VagasDTO(obj));
	}

	// FILTRAR VAGA CATEGORIA
	@GetMapping("/categoria/{categoria}")
    public ResponseEntity<List<Vagas>> findByCategoria(@RequestParam Integer categoriaId) throws Exception {
		List<Vagas> vagas = service.findCategoria(categoriaId);
        return ResponseEntity.ok(vagas);
    
	}
	// LISTAR TODAS AS VAGAS POR NOME
		@GetMapping(value = "/findNome")
		public ResponseEntity<List<Vagas>> findByNome(@RequestParam(value="nome") String nome) throws Exception {
			List<Vagas> vagas = service.findByTitulo(nome);
		return ResponseEntity.ok(vagas);
		}
		
	
	// DELETAR VAGA
		@DeleteMapping(value = "/delete-vaga/{id}")
		public ResponseEntity<VagasDTO> delete(@PathVariable Integer id) throws Exception {
		service.delete(id);
		return ResponseEntity.noContent().build();
		}

	// EMPRESA VISUALIZAR CANDIDATURAS DA VAGA

	// PROFISSIONAL CANDIDATAR NA VAGA

	// PROFISSIONAL VISUALIZAR VAGAS CANDIDATADAS

	// EMPRESA VISUALIZAR FEED PROFISSIONAL CANDIDATADO NA VAGA

	// PROFISSIONAL VISUALIZAR FEED EMPRESA CANDIDATADA

}
