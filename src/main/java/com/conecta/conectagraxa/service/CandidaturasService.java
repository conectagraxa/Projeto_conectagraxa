package com.conecta.conectagraxa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conecta.conectagraxa.repositories.CandidaturasRepository;
import com.conecta.conectagraxa.repositories.VagasRepository;

@Service
public class CandidaturasService {

	@Autowired
	VagasService vService;
	VagasRepository vRepository;
	ProfissionalService pService;
	EmpresaService eService;

	CandidaturasRepository repository;
	// EMPRESA VISUALIZAR CANDIDATURAS DA VAGA

	// PROFISSIONAL CANDIDATAR NA VAGA

	// PROFISSIONAL VISUALIZAR VAGAS CANDIDATADAS

	// EMPRESA VISUALIZAR FEED PROFISSIONAL CANDIDATADO NA VAGA

	// PROFISSIONAL VISUALIZAR FEED EMPRESA CANDIDATADA

}
