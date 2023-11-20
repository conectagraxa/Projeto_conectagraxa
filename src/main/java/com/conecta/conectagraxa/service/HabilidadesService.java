package com.conecta.conectagraxa.service;

import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.conecta.conectagraxa.model.Feed_Profissional;
import com.conecta.conectagraxa.model.Habilidades;
import com.conecta.conectagraxa.model.dto.HabilidadesDTO;
import com.conecta.conectagraxa.repositories.HabilidadesRepository;

@Service
public class HabilidadesService {

	@Autowired
	Feed_ProfissionalService feedService;
	@Autowired
	HabilidadesRepository repository;
	
	//SELECIONAR HABILIDADE E SALVAR NO BANCO
	@Transactional
	public String criarCategoria(Integer idFeed,String habilidade) {
		Habilidades nomeHabilidade = new Habilidades();
		nomeHabilidade.setNomeHabilidade(habilidade);
		Feed_Profissional feed = feedService.manterFeed(idFeed);
		nomeHabilidade.setFeedProfissional(feed);
		
		Habilidades habilidades = new Habilidades (nomeHabilidade);
		repository.saveAndFlush(habilidades);
		return "CadastroPF.html";
	}
	
}
