package com.conecta.conectagraxa.service;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conecta.conectagraxa.model.Comentarios;
import com.conecta.conectagraxa.model.Postagens;
import com.conecta.conectagraxa.model.Profissional;
import com.conecta.conectagraxa.model.dto.ComentariosDTO;
import com.conecta.conectagraxa.repositories.ComentariosRepository;
import com.conecta.conectagraxa.repositories.PostagensRepository;
import com.conecta.conectagraxa.repositories.ProfissionalRepository;


@Service
public class ComentariosService {
	
	
	@Autowired
	ProfissionalRepository pRepository;
	
	@Autowired
	PostagensRepository postRepository;
	

	@Autowired
	ComentariosRepository repository;
	
	//comentar na postagem

//alternativa de substituição do @ManyToMany(fetch = FetchType.EAGER)
//que serve para recuperar as informações das entidades filhas.
@Transactional
public Comentarios createComentario(ComentariosDTO objDTO, Integer postId, Integer userId) throws Exception {
		
	//buscando se o profissional existe
	Optional <Profissional> user= pRepository.findById(userId);	
	//buscando se a postagem existe
	Optional<Postagens> post=postRepository.findById(postId);
	Comentarios newCom = new Comentarios();
		
		//verifica se a postagem e o profissional existe
		if(user.isPresent() && post.isPresent()) {
		//seta id da postagem e do profissional com id encontrado
		//evitando ser criado outro obj.
		user.get().setId(user.get().getId());	
		post.get().setId(post.get().getId());	

		//novo profissional com informações encontradas no id buscado
		Profissional novoProf = new Profissional(user.get());

		//novo post com informações encontradas no id buscado
		Postagens newPost = new Postagens(post.get());
		
		//setando data postagem comentario
		newCom.setComentadoEm(objDTO.getComentado_em());
		//seta profissional que comentou encontrado pelo id 
		newCom.setComentadoPor(novoProf);
		//seta informações da postagem recuperadas na busca 
		newCom.setPostagemId(newPost);
		
		//seta descrição do comentário passada no OBJDTO
		newCom.setDescricao(objDTO.getDescricao());
		
		//salva comentario
		newCom= repository.save(newCom);
		
		//adiciona na lista de comentarios da postagem
		post.get().getComentarios().add(newCom);

		//passando informações da atualização para o post
		newPost = post.get();
		
		//salvando o post
		newPost = postRepository.save(newPost);
		}
		return newCom;
	}

	
	//excluir comentario
public void deleteComentario(Integer id) throws Exception {
	Optional<Comentarios> obj = repository.findById(id);
	if (obj.get().getId().equals(id)) {
		repository.deleteById(id);
	} else {
		throw new Exception("Comentário não encontrada");
	}

}

}
