package com.conecta.conectagraxa.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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

import com.conecta.conectagraxa.model.Comentarios;
import com.conecta.conectagraxa.model.Postagens;
import com.conecta.conectagraxa.model.dto.ComentariosDTO;
import com.conecta.conectagraxa.model.dto.PostagensDTO;
import com.conecta.conectagraxa.repositories.PostagensRepository;
import com.conecta.conectagraxa.service.ComentariosService;
import com.conecta.conectagraxa.service.PostagensService;

@CrossOrigin("*")
@RestController
@RequestMapping("/postagens")
public class PostagensController {

	@Autowired
	private PostagensService service;
	
	@Autowired
	private ComentariosService cService;
	
	

	// CRIAR POSTAGEM
	@PostMapping(value = "/create")
	public ResponseEntity<PostagensDTO> create(@Valid @RequestBody PostagensDTO objDTO) throws Exception {

		Postagens newObj = service.createPost(objDTO.getFeedProfissionalId(),objDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	// EDITAR POSTAGEM
	@PutMapping("/update-postagem/{id}")
	public ResponseEntity<PostagensDTO> update(@PathVariable Integer id, @RequestBody @Valid PostagensDTO objDTO)
			throws Exception {
		Postagens obj = service.update(id, objDTO);
		return ResponseEntity.ok().body(new PostagensDTO(obj));
	}

	//LIKE
	@PutMapping("/curtir/{id}")
	public ResponseEntity<PostagensDTO> curtir(@PathVariable Integer id) throws Exception {
		Postagens obj = service.curtir(id);
		return ResponseEntity.ok().body(new PostagensDTO(obj));
	}

	//DESLIKE
	@PutMapping("/deslike/{id}")
	public ResponseEntity<PostagensDTO> deslike(@PathVariable Integer id) throws Exception {
		Postagens obj = service.deslike(id);
		return ResponseEntity.ok().body(new PostagensDTO(obj));
	}
	
	//DELETAR POST
	@DeleteMapping(value = "deletePost/{id}")
	public ResponseEntity<PostagensDTO> delete(@PathVariable Integer id) throws Exception {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	//LISTAR POSTAGENS
	@GetMapping(value = "/postagens")
	ResponseEntity<List<PostagensDTO>> findAll() {
		List<Postagens> list = service.getAllProfissional();
		List<PostagensDTO> listDTO = list.stream().map(obj -> new PostagensDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	
	//COMENTAR
		@PostMapping(value = "/comentario/{pid}")
		public ResponseEntity<ComentariosDTO> create(@PathVariable Integer pid, Integer prId ,@Valid @RequestBody ComentariosDTO objDTO) throws Exception {

			Comentarios newObj = cService.createComentario(objDTO, pid, prId);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
			return ResponseEntity.created(uri).build();
		}
	
	
	//EXCLUIR COMENTÁRIO
		@DeleteMapping(value = "deleteComentario/{id}")
		public ResponseEntity<ComentariosDTO> deleteComentario(@PathVariable Integer id) throws Exception {
			cService.deleteComentario(id);
			return ResponseEntity.noContent().build();
		}
}

