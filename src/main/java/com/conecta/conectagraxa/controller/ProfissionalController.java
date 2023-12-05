package com.conecta.conectagraxa.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.conecta.conectagraxa.model.Profissional;
import com.conecta.conectagraxa.model.dto.ProfissionalDTO;
import com.conecta.conectagraxa.response.ResponseMessage;
import com.conecta.conectagraxa.security.GoogleProfissional;
import com.conecta.conectagraxa.security.SessaoLoginProfissional;
import com.conecta.conectagraxa.service.ProfissionalService;
import com.conecta.conectagraxa.service.SeguidoresService;
import com.conecta.conectagraxa.service.SessaoLoginService;

@CrossOrigin
@Controller
@RequestMapping(value = "/profissional")
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
		return ResponseEntity.ok(new ProfissionalDTO (newObj));
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
	public @ResponseBody ResponseEntity<ProfissionalDTO> atualizarSenha(
		@PathVariable Integer id, ProfissionalDTO objDTO) {
		Profissional obj = service.atualizaSenha(id, objDTO);
		return ResponseEntity.ok().body(new ProfissionalDTO(obj));
	}

	// LOGIN DO PROFISSIONAL
	@PutMapping("/login")
	public ResponseEntity<ResponseMessage> login(@RequestBody SessaoLoginProfissional obj) {
		String message = loginService.LoginProfissional(obj);
		ResponseMessage res = new ResponseMessage(message);
		return new ResponseEntity<ResponseMessage>(res, HttpStatus.OK);
	}

	// LOGIN GOOGLE DO PROFISSIONAL
		@PutMapping("/loginGoogle")
		public ResponseEntity<ResponseMessage> loginGoogle(@RequestBody GoogleProfissional obj) {
			String message = loginService.loginGoogleProfisional(obj);
			ResponseMessage res = new ResponseMessage(message);
			return new ResponseEntity<ResponseMessage>(res, HttpStatus.OK);
		}

	
	// DESLOGAR DO PROFISSIONAL
	@PutMapping("/deslogar/{obj}")
	public ResponseEntity<ResponseMessage> deslogar(@RequestBody SessaoLoginProfissional obj) {
		String message = loginService.DeslogarProfissional(obj);
		ResponseMessage res = new ResponseMessage(message);
		return new ResponseEntity<ResponseMessage>(res, HttpStatus.OK);
	}

	// SEGUIR
	@PutMapping("/seguir/{seguirId}")
	public ResponseEntity<ResponseMessage> seguir(@RequestParam Integer seguidorId, @PathVariable Integer seguirId)
			throws Exception {
		service.findById(seguidorId);
		service.findById(seguirId);
		String message = seguidoresService.seguir(seguidorId, seguirId);
		ResponseMessage res = new ResponseMessage(message);
		return new ResponseEntity<ResponseMessage>(res, HttpStatus.OK);
	}

	// UNFOLLOW
	@PutMapping("/unfollow/{unfollow}")
	public ResponseEntity<ResponseMessage> unfollow(@RequestParam Integer seguir, @RequestParam Integer seguidor)
			throws Exception {
		service.findById(seguidor);
		service.findById(seguir);

		String message = seguidoresService.unfollow(seguir, seguidor);
		ResponseMessage res = new ResponseMessage(message);
		return new ResponseEntity<ResponseMessage>(res, HttpStatus.OK);
	}

}