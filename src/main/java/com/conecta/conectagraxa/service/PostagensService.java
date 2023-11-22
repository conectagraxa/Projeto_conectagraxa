package com.conecta.conectagraxa.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conecta.conectagraxa.model.Feed_Profissional;
import com.conecta.conectagraxa.model.Postagens;
import com.conecta.conectagraxa.model.Profissional;
import com.conecta.conectagraxa.model.dto.PostagensDTO;
import com.conecta.conectagraxa.repositories.PostagensRepository;
import com.conecta.conectagraxa.repositories.ProfissionalRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Transactional
@Service
public class PostagensService {

	@Autowired
	ProfissionalService profissionalService;

	@Autowired
	Feed_ProfissionalService feedService;

	@Autowired
	ProfissionalRepository repositoryProfissional;

	@Autowired
	PostagensRepository repository;

	public Postagens createPost(Integer id, PostagensDTO postDTO) throws Exception {
		Postagens post = new Postagens();

		Feed_Profissional feed = feedService.findById(id);

		Profissional profissional = profissionalService.findById(id);

		profissional.setId(id);

		post.setDataPostagem(postDTO.getDataPostagem());
		post.setDescricao(postDTO.getDescricao());
		post.setFotoPostagem(postDTO.getFotoPostagem());
		post.setDataPostagem(postDTO.getDataPostagem());
		
		profissional.getPostagens().add(post);
		feed.getPostagens().add(post);

		post.setProfissionalId(profissional);
		post.setFeedProfissionalId(feed);

		Postagens novoPost = repository.save(post);

		return novoPost;
	}

	// postagens update
	public Postagens update(Integer id, @Valid PostagensDTO objDTO) throws Exception {
		objDTO.setId(id);
		Optional<Postagens> obj = repository.findById(id);
		Postagens newObj = new Postagens();

		// se o retorno da busca foi true
		if (obj.isPresent()) {

			// id, curtidas,comentários,profissional autor do post, feed do profissional
			// não se altera por esse trecho de código.

			// seta o id com a informação resgatada do banco, garantindo que não gere um
			// outro post
			newObj.setId(obj.get().getId());

			newObj.setDataPostagem(obj.get().getDataPostagem());
			newObj.setComentarios(obj.get().getComentarios());
			newObj.setCurtidas(obj.get().getCurtidas());
			newObj.setFeedProfissionalId(obj.get().getFeedProfissionalId());
			// newObj.setIdProfissionalId(obj.get().getIdProfissionalId());

			if (obj.get().getDescricao() != null) {
				newObj.setDescricao(obj.get().getDescricao());
			}

			if (obj.get().getFotoPostagem() != null) {
				newObj.setFotoPostagem(obj.get().getFotoPostagem());
			}
			// atualiza os campos do objeto com os valores preenchidos no corpo do objeto
			// DTO

			if (objDTO.getDescricao() != null) {
				newObj.setDescricao(objDTO.getDescricao());
			}
			if (objDTO.getFotoPostagem() != null) {
				newObj.setFotoPostagem(objDTO.getFotoPostagem());
			}
		}

		// pegando as informações novas
		Postagens old = (newObj);
		// salvando no banco
		Postagens atualizado = repository.save(old);

		// retorna um post atualizado
		return atualizado;
	}

	public void delete(Integer id) throws Exception {
		Optional<Postagens> obj = repository.findById(id);

		if (obj.get().getId().equals(id)) {
			repository.deleteById(id);
		} else {
			throw new Exception("Postagem não encontrada");
		}

	}

	// lista todos as postagens dos profissionais
	public List<Postagens> getAllProfissional() {
		return repository.findAll();
	}

	public Postagens curtir(Integer id) throws ObjectNotFoundException {
		Optional<Postagens> obj = repository.findById(id);
		Postagens newObj = new Postagens();

		if (obj.isPresent()) {
			obj.get().setId(obj.get().getId());

			obj.get().setFotoPostagem(obj.get().getFotoPostagem());
			obj.get().setDescricao(obj.get().getDescricao());
			obj.get().setDataPostagem(obj.get().getDataPostagem());
			obj.get().setComentarios(obj.get().getComentarios());
			obj.get().setProfissionalId(obj.get().getProfissionalId());
			obj.get().setFeedProfissionalId(obj.get().getFeedProfissionalId());

			if (obj.get().getCurtidas() == null) {
				obj.get().setCurtidas(+0);
			}
			;

			obj.get().setCurtidas(obj.get().getCurtidas() + 1);

			newObj = obj.get();

			Postagens atualizado = repository.save(newObj);

			// retorna um post atualizado
			return atualizado;

		} else {
			return obj.orElseThrow(() -> new ObjectNotFoundException("postagem não encontrado Id: " + id));

		}
	}

	public Postagens deslike(Integer id) throws ObjectNotFoundException {
		Optional<Postagens> obj = repository.findById(id);
		Postagens newObj = new Postagens();

		if (obj.isPresent()) {
			obj.get().setId(obj.get().getId());

			obj.get().setFotoPostagem(obj.get().getFotoPostagem());
			obj.get().setDescricao(obj.get().getDescricao());
			obj.get().setDataPostagem(obj.get().getDataPostagem());
			obj.get().setComentarios(obj.get().getComentarios());
			obj.get().setFeedProfissionalId(obj.get().getFeedProfissionalId());
			obj.get().setProfissionalId(obj.get().getProfissionalId());

			if (obj.get().getCurtidas() == null) {
				obj.get().setCurtidas(+0);
			}
			if (obj.get().getCurtidas() <= 0) {
				obj.get().setCurtidas(0);

			}
			if (obj.get().getCurtidas() > 0) {

				obj.get().setCurtidas(obj.get().getCurtidas() - 1);
			}
			newObj = obj.get();

			Postagens atualizado = repository.save(newObj);

			// retorna um post atualizado
			return atualizado;

		} else {
			return obj.orElseThrow(() -> new ObjectNotFoundException("postagem não encontrado Id: " + id));

		}

	}

}
