package com.conecta.conectagraxa.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conecta.conectagraxa.model.Feed_Profissional;
import com.conecta.conectagraxa.model.Habilidades;
import com.conecta.conectagraxa.repositories.HabilidadesRepository;

@Service
public class HabilidadesService {

	@Autowired
	Feed_ProfissionalService feedService;
	@Autowired
	HabilidadesRepository repository;
	
	//SELECIONAR HABILIDADE NO FORMULÁRIO DE UPDATE DO FEED DO PROFISSIONAL ATRAVÉS DO QUE TIVER DEFINIDO NO HTML E SALVAR NO BANCO
	@Transactional
	public String escolherHabilidade(Integer idFeed,String habilidade) {
		
		Habilidades nomeHabilidade = new Habilidades();
		nomeHabilidade.setNomeHabilidade(habilidade);
		Feed_Profissional feed = feedService.manterFeed(idFeed);
		nomeHabilidade.setFeedProfissional(feed);
		
		Habilidades habilidades = new Habilidades (nomeHabilidade);
		repository.saveAndFlush(habilidades);
		return "CadastroPF.html";
	}
	
	//UPGRADE FUTURO - EDITAR CATEGORIA, EXCLUIR CATEGORIA
	
	
}
