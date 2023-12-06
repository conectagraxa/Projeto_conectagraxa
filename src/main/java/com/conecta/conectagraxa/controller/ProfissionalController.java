package com.conecta.conectagraxa.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.conecta.conectagraxa.model.Profissional;
import com.conecta.conectagraxa.model.Seguidores;
import com.conecta.conectagraxa.model.dto.ProfissionalDTO;
import com.conecta.conectagraxa.response.ResponseMessage;
import com.conecta.conectagraxa.security.GoogleProfissional;
import com.conecta.conectagraxa.security.SessaoLoginProfissional;
import com.conecta.conectagraxa.service.ProfissionalService;
import com.conecta.conectagraxa.service.SeguidoresService;
import com.conecta.conectagraxa.service.SessaoLoginService;

@Controller
@RequestMapping(value = "/profissional")
@CrossOrigin(origins = "*")
public class ProfissionalController {

	// INJEÇÃO DO SERVIÇO PROFISSIONAL SERVICE
	@Autowired
	private ProfissionalService service;

	@Autowired
	private SessaoLoginService loginService;

	@Autowired
	private SeguidoresService seguidoresService;

	// BUSCAR PROFISSIONAL POR NOME
	@GetMapping(value = "/")
	public ResponseEntity<ProfissionalDTO> findByNome(@RequestParam(value = "nome") String nome) throws Exception {
		Profissional obj = service.findByNome(nome);
		return ResponseEntity.ok().body(new ProfissionalDTO(obj));
	}

	// BUSCAR PROFISSIONAL POR ID
	@GetMapping(value = "/{id}")
	public ResponseEntity<ProfissionalDTO> findById(@PathVariable int id) throws Exception {
		Profissional obj = service.findById(id);
		return ResponseEntity.ok().body(new ProfissionalDTO(obj));
	}

	// BUSCAR TODOS OS PROFISSIONAIS
	@GetMapping(value = "/findAll")
	ResponseEntity<List<ProfissionalDTO>> findAll() {
		List<Profissional> list = service.getAllProfissional();
		List<ProfissionalDTO> listDTO = list.stream().map(obj -> new ProfissionalDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	// CRIAR PROFISSIONAL
	@PostMapping(value = "/create")
	public ResponseEntity<ProfissionalDTO> create(@RequestBody @Valid ProfissionalDTO objDTO) throws Exception {
		Profissional newObj = service.createProfissional(objDTO);
		return ResponseEntity.ok(new ProfissionalDTO(newObj));
	}

	// UPDATE DO PROFISSIONAL
	@PutMapping("/update/{id}")
	public ResponseEntity<ProfissionalDTO> update(@PathVariable int id, @RequestBody @Valid ProfissionalDTO objDTO)
			throws Exception {
		Profissional obj = service.update(id, objDTO);
		return ResponseEntity.ok().body(new ProfissionalDTO(obj));

	}

	// ATUALIZAR SENHA DO PROFISSIONAL
	@PutMapping("/senha/{id}")
	public @ResponseBody ResponseEntity<ProfissionalDTO> atualizarSenha(@PathVariable Integer id,
			ProfissionalDTO objDTO) {
			Profissional obj = service.atualizaSenha(id, objDTO);
		return ResponseEntity.ok().body(new ProfissionalDTO(obj));
	}

	// LOGIN DO PROFISSIONAL
	@PutMapping("/login")
	public ResponseEntity<SessaoLoginProfissional> login(@RequestBody SessaoLoginProfissional obj) {
		SessaoLoginProfissional login = loginService.LoginProfissional(obj);
		return ResponseEntity.ok().body(new SessaoLoginProfissional(login));

	}

	// LOGIN GOOGLE DO PROFISSIONAL
	@PutMapping("/loginGoogleProfissionalService")
	public ResponseEntity<GoogleProfissional> loginGoogle(@RequestBody GoogleProfissional objDTO) {
		GoogleProfissional google = loginService.loginGoogleProfisional(objDTO);
		return ResponseEntity.ok().body(new GoogleProfissional(google));
	}
	
	// DESLOGAR DO PROFISSIONAL
	@PutMapping("/deslogar/{obj}")
	public ResponseEntity<SessaoLoginProfissional> deslogar(@RequestBody SessaoLoginProfissional objDTO) {
		SessaoLoginProfissional obj = loginService.DeslogarProfissional(objDTO);
		return ResponseEntity.ok().body(new SessaoLoginProfissional(obj));

	}

	// SEGUIR
	@PutMapping("/seguir/{seguirId}")
	public ResponseEntity<Seguidores> seguir(@RequestParam Integer seguidorId, @PathVariable Integer seguirId)
		throws Exception {
		service.findById(seguidorId);
		service.findById(seguirId);
		Seguidores obj = seguidoresService.seguir(seguidorId, seguirId);
		return ResponseEntity.ok().body(new Seguidores(obj));
	}

	// UNFOLLOW
	@PutMapping("/unfollow/{unfollow}")
	public ResponseEntity<Seguidores> unfollow(@RequestParam Integer seguir, @RequestParam Integer seguidor)
			throws Exception {
		service.findById(seguidor);
		service.findById(seguir);
		Seguidores obj = seguidoresService.unfollow(seguir, seguidor);
		return ResponseEntity.ok().body(new Seguidores(obj));

	}

}
