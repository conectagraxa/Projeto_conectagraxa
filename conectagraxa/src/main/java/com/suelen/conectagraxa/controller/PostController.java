package com.suelen.conectagraxa.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suelen.conectagraxa.model.Post;
import com.suelen.conectagraxa.model.dto.PostDTO;
import com.suelen.conectagraxa.repositories.PostRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/post")
public class PostController {

	@Autowired
	private PostRepository postRepository;

	
	// GetAll
	@GetMapping
	public List<PostDTO> getAllPosts() {
		
		// Guardando todos os post no banco na lista
		List<Post> posts = postRepository.findAll();
		
		// Covertente uma list de Post em uma lista de PostDTO e ent retornando ela
		return posts.stream().map(this::convertToDto).collect(Collectors.toList());
	}

	// GetByID
	@GetMapping("/{id}")
	public ResponseEntity<PostDTO> getPostById(@Valid @PathVariable Integer id) {
		
		Optional<Post> postOptional = postRepository.findById(id);
		
		// tem algo
		if (postOptional.isPresent()) {
			
			// Instanciando
			PostDTO postDto = new PostDTO();
			
			// Convertendo PostModel para Post
			BeanUtils.copyProperties(postOptional.get(), postDto);
			return ResponseEntity.ok(postDto);
		} 
		
		// Se estiver vázio não retorna nada
		return ResponseEntity.notFound().build();
	
	}
	
	 
	// Criando uma nova postagem
	@PostMapping()
	public ResponseEntity<Post> createPost(@Valid @RequestBody PostDTO postDto) {
		
		// Converte o postDTo para post
		Post post = new Post();
		BeanUtils.copyProperties(postDto, post);
		
		// retornando.
		return ResponseEntity.status(HttpStatus.CREATED).body(postRepository.save(post));
	}


	@PutMapping("/{id}")
	public ResponseEntity<PostDTO> updatePost(@Valid @PathVariable Integer id, @RequestBody PostDTO postDto) {
		
		// Localizando id...
		Optional<Post> postOptional = postRepository.findById(id);
		
		
		// Achou o id do put
		if (postOptional.isEmpty()) 
		{
			// Não encontrado
			return ResponseEntity.notFound().build();
		}
		
		
		// Guardando o post recebido numa outra variável.
		Post oldPost = postOptional.get();
			
		// Convertendo o postDto num post
		Post newPost = new Post();
		BeanUtils.copyProperties(postDto, newPost);
				

		
		//Atualização pacial:
		
			// A Data da postagem não se altera.
			oldPost.setId_profissional_id(newPost.getId_profissional_id());
			oldPost.setFeed_profissional_id(newPost.getFeed_profissional_id());
			oldPost.setFoto_postagem(newPost.getFoto_postagem());
			oldPost.setDescricao(newPost.getDescricao());
			oldPost.setCurtidas(newPost.getCurtidas());
			
			
		//Salvando 
		Post savePost = postRepository.save(oldPost);
		
		// convertendo o post para dto
		BeanUtils.copyProperties(savePost, postDto);
		
		// retornando
		return ResponseEntity.ok(postDto);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePost(@Valid @PathVariable Integer id) {
		
		Optional<Post> postOptional = postRepository.findById(id);
		
		// Se tem um post
		if (postOptional.isPresent()) {
			
			// deletar pelo id
			postRepository.deleteById(id);
			
			return ResponseEntity.noContent().build();
		} 
		
		// Se não foi encontrado nada
		return ResponseEntity.notFound().build();
		
	}


	private PostDTO convertToDto(Post post) {
		
		// retornando um novo objeto da classe PostDTO
		return new PostDTO(
				post.getId(),
				post.getId_profissional_id(),
				post.getFeed_profissional_id(),
				post.getDescricao(),
				post.getData_postagem(),
				post.getFoto_postagem(),
				post.getCurtidas());
	}

}
