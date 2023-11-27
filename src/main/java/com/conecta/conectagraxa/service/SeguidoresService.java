package com.conecta.conectagraxa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conecta.conectagraxa.model.Profissional;
import com.conecta.conectagraxa.model.Seguidores;
import com.conecta.conectagraxa.repositories.ProfissionalRepository;
import com.conecta.conectagraxa.repositories.SeguidoresRepository;

@Service
public class SeguidoresService {

	

	
	@Autowired
	SeguidoresRepository repository;
	
	@Autowired
	ProfissionalRepository profissionalRepository;
	

	public String seguir(Integer idSeguir, Integer idSeguidor) throws Exception {
		Optional<Profissional> seguir= profissionalRepository.findById(idSeguir);
		Optional<Profissional> seguidor= profissionalRepository.findById(idSeguidor);

		Seguidores seguidores = new Seguidores();
		Seguidores seguido = new Seguidores();
		Seguidores seguindo = new Seguidores();

		
		if (seguir.isPresent() && seguidor.isPresent()) {
		if (repository.existsBySeguidoresIdAndSeguindoId(seguidor.get(), seguir.get())) {
			return "";
		}
		Profissional userSeguir =new Profissional();
		userSeguir.setId(seguir.get().getId());
		userSeguir.setFeedProfissional(seguir.get().getFeedProfissional());
		userSeguir.setCandidaturas(seguir.get().getCandidaturas());
		userSeguir.setComentarios(seguir.get().getComentarios());

		userSeguir.setNome(seguir.get().getNome());
		userSeguir.setEmail(seguir.get().getEmail());
		userSeguir.setEtnia(seguir.get().getEtnia());
		userSeguir.setTelefone(seguir.get().getTelefone());
		userSeguir.setEndereco(seguir.get().getEndereco());
		userSeguir.setCep(seguir.get().getCep());
		userSeguir.setComplemento(seguir.get().getComplemento());
		userSeguir.setCidade(seguir.get().getCidade());
		userSeguir.setEstado(seguir.get().getEstado());
		userSeguir.setFotoPerfil(seguir.get().getFotoPerfil());
		userSeguir.setSenha(seguir.get().getSenha());
		userSeguir.setDataNascimento(seguir.get().getDataNascimento());
		userSeguir.setSexo(seguir.get().getSexo());
		userSeguir.setToken(seguir.get().getToken());
		seguindo.setSeguindoId(userSeguir);
		
	
		Profissional userSeguidor =new Profissional();
		userSeguidor.setId(seguidor.get().getId());
		userSeguidor.setFeedProfissional(seguidor.get().getFeedProfissional());
		userSeguidor.setCandidaturas(seguidor.get().getCandidaturas());
		userSeguidor.setComentarios(seguidor.get().getComentarios());

		userSeguidor.setNome(seguidor.get().getNome());
		userSeguidor.setEmail(seguidor.get().getEmail());
		userSeguidor.setEtnia(seguidor.get().getEtnia());
		userSeguidor.setTelefone(seguidor.get().getTelefone());
		userSeguidor.setEndereco(seguidor.get().getEndereco());
		userSeguidor.setCep(seguidor.get().getCep());
		userSeguidor.setComplemento(seguidor.get().getComplemento());
		userSeguidor.setCidade(seguidor.get().getCidade());
		userSeguidor.setEstado(seguidor.get().getEstado());
		userSeguidor.setFotoPerfil(seguidor.get().getFotoPerfil());
		userSeguidor.setSenha(seguidor.get().getSenha());
		userSeguidor.setDataNascimento(seguidor.get().getDataNascimento());
		userSeguidor.setSexo(seguidor.get().getSexo());
		userSeguidor.setToken(seguidor.get().getToken());

		seguido.setSeguidoresId(userSeguidor);


		userSeguir.getSeguindo().add(seguindo);
		userSeguidor.getSeguidores().add(seguido);


		seguidores.setSeguidoresId(userSeguidor);	
		seguidores.setSeguindoId(userSeguir);
		
		repository.save(seguidores);
				
	}
		return "você está seguindo: "+seguir.get().getNome();
		
	}
	

	
	public String unfollow(Integer idSeguir, Integer idSeguidor) throws Exception {
		Optional<Profissional> seguir= profissionalRepository.findById(idSeguir);
		Optional<Profissional> seguidor= profissionalRepository.findById(idSeguidor);

			
		Seguidores seguidores = new Seguidores();
		Seguidores seguido = new Seguidores();
		Seguidores seguindo = new Seguidores();

		
		if (seguir.isPresent() && seguidor.isPresent()) {
		Profissional userSeguir =new Profissional();
		userSeguir.setId(seguir.get().getId());
		userSeguir.setFeedProfissional(seguir.get().getFeedProfissional());
		userSeguir.setCandidaturas(seguir.get().getCandidaturas());
		userSeguir.setComentarios(seguir.get().getComentarios());

		userSeguir.setNome(seguir.get().getNome());
		userSeguir.setEmail(seguir.get().getEmail());
		userSeguir.setEtnia(seguir.get().getEtnia());
		userSeguir.setTelefone(seguir.get().getTelefone());
		userSeguir.setEndereco(seguir.get().getEndereco());
		userSeguir.setCep(seguir.get().getCep());
		userSeguir.setComplemento(seguir.get().getComplemento());
		userSeguir.setCidade(seguir.get().getCidade());
		userSeguir.setEstado(seguir.get().getEstado());
		userSeguir.setFotoPerfil(seguir.get().getFotoPerfil());
		userSeguir.setSenha(seguir.get().getSenha());
		userSeguir.setDataNascimento(seguir.get().getDataNascimento());
		userSeguir.setSexo(seguir.get().getSexo());
		userSeguir.setToken(seguir.get().getToken());
		seguindo.setSeguindoId(userSeguir);

	
		Profissional userSeguidor =new Profissional();
		userSeguidor.setId(seguidor.get().getId());
		userSeguidor.setFeedProfissional(seguidor.get().getFeedProfissional());
		userSeguidor.setCandidaturas(seguidor.get().getCandidaturas());
		userSeguidor.setComentarios(seguidor.get().getComentarios());

		userSeguidor.setNome(seguidor.get().getNome());
		userSeguidor.setEmail(seguidor.get().getEmail());
		userSeguidor.setEtnia(seguidor.get().getEtnia());
		userSeguidor.setTelefone(seguidor.get().getTelefone());
		userSeguidor.setEndereco(seguidor.get().getEndereco());
		userSeguidor.setCep(seguidor.get().getCep());
		userSeguidor.setComplemento(seguidor.get().getComplemento());
		userSeguidor.setCidade(seguidor.get().getCidade());
		userSeguidor.setEstado(seguidor.get().getEstado());
		userSeguidor.setFotoPerfil(seguidor.get().getFotoPerfil());
		userSeguidor.setSenha(seguidor.get().getSenha());
		userSeguidor.setDataNascimento(seguidor.get().getDataNascimento());
		userSeguidor.setSexo(seguidor.get().getSexo());
		userSeguidor.setToken(seguidor.get().getToken());

		seguido.setSeguidoresId(userSeguidor);
		
		userSeguir.getSeguindo().remove(seguido);
		userSeguidor.getSeguidores().remove(seguindo);
		
		userSeguir.setId(idSeguir);
		seguidores.setId(idSeguir);
		repository.save(seguidores);
	
	}
		return "você deixou de seguir: "+seguir.get().getNome();
		
	}
	}
