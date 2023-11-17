package com.conecta.conectagraxa.controller;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.conecta.conectagraxa.model.Empresa;
import com.conecta.conectagraxa.model.Profissional;
import com.conecta.conectagraxa.model.dto.EmpresaDTO;
import com.conecta.conectagraxa.model.dto.ProfissionalDTO;
import com.conecta.conectagraxa.service.EmpresaService;

@RestController
@RequestMapping(value = "/empresa")
public class EmpresaController {

	@Autowired
	private EmpresaService service;
	
	private final Logger logger = LoggerFactory.getLogger(EmpresaController.class);

	//trazer empresa por nome
	@GetMapping(value = "/")
	public ResponseEntity<EmpresaDTO> findByNome(@RequestParam(value="nome") String nome) throws Exception {
		Empresa obj = service.findByNomeFantasia(nome);
		return ResponseEntity.ok().body(new EmpresaDTO(obj));
	}
	
	//trazer empresa por cpf ou cnpj
	@GetMapping(value = "/{cpfCnpj}")
	public ResponseEntity<EmpresaDTO> findByCpfCnpj(@PathVariable String cpfCnpj) throws Exception {
		Empresa obj = service.findByCpfCnpj(cpfCnpj);
		return ResponseEntity.ok().body(new EmpresaDTO(obj));
	}

	
	//listar todas empresas
	@GetMapping("/empresas")
	ResponseEntity<List<EmpresaDTO>> findAll() {
		List<Empresa> list = service.getAllEmpresas();
		List<EmpresaDTO> listDTO = list.stream().map(obj -> new EmpresaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);	}
		
	//criar empresa
	@PostMapping
	public ResponseEntity<EmpresaDTO> create(@Valid @RequestBody EmpresaDTO objDTO) throws Exception {
		Empresa newObj = service.createEmpresa(objDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getCpfCnpj())
		.toUri();
		return ResponseEntity.created(uri).build();
	}

	//UPDATE Da empresa 
		@PutMapping("/update/{id}")
		public ResponseEntity<EmpresaDTO> update( @PathVariable int id, @RequestBody @Valid EmpresaDTO objDTO)throws Exception {
			Empresa obj = service.update(id, objDTO);
		return ResponseEntity.ok().body(new EmpresaDTO(obj));
		

		}


	//update senha empresa
	@PutMapping("/senha/{id}")
    public ResponseEntity<EmpresaDTO> atualizarSenha(@PathVariable Integer id ,@RequestBody EmpresaDTO objDTO) {
        Empresa obj = service.atualizaSenha(id ,objDTO);
        return ResponseEntity.ok().body(new EmpresaDTO(obj));
    }
	

	
	

}
