package com.conecta.conectagraxa.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conecta.conectagraxa.model.Cursos;
import com.conecta.conectagraxa.model.Empresa;
import com.conecta.conectagraxa.model.Postagens;
import com.conecta.conectagraxa.model.Profissional;
import com.conecta.conectagraxa.model.Seguidores;
import com.conecta.conectagraxa.model.dto.ComentariosDTO;
import com.conecta.conectagraxa.model.dto.PostagensDTO;
import com.conecta.conectagraxa.model.dto.ProfissionalDTO;
import com.conecta.conectagraxa.model.enums.Perfil;

@Service
public class DBService {

	//tratamento exceções
	
	//login google
	
	//login profissional autenticado - jwt
	
	//login empresa autenticada - jwt
	
	//autorização de rotas profissional - security

	//autorização de rotas empresa - security

	//encriptografar senha profissional
	
	//encriptografar senha empresa

	//faltam 13 endpoints - vagas service:  6 - candidaturas service: 5 - habilidades service: 2
	
	@Autowired
	ProfissionalService pService;
	Perfil perfil;

	@Autowired
	EmpresaService eService;

	@Autowired
	CursosService cService;

	@Autowired
	PostagensService ptService;

	@Autowired
	SeguidoresService sService;

	
	@Autowired
	ComentariosService comService;
	
	@Autowired
	VagasService vService;
	
	@Autowired
	CandidaturasService cdService;


	@Autowired
	CategoriasService catService;
	
	
	public void instanciaDB() throws Exception {
		Cursos cursos = new Cursos();
	
		catService.insertCat();
		
		Profissional p1 = new Profissional(0, "Marcos Oliveira Jr.", "pardo", "PE", "cabrobó", "rua malafaia",
				29906460, "(81) 2876-4327", "ap 10", "marcosoliveirajr@mail.com", "123", "27/02/1980", "Masculino",
				"www.com.br", perfil.PROFISSIONAL);

		Profissional p2 = new Profissional(0, "Agostinha Camelo Cretella", "branca", "RJ", "cabrobó",
				"Rua Ana José", 26282020, "(24) 99188-9311", "ap 20", "bryancarvalho.souza3@hotmail.com", "123",
				"04/02/1981", "Feminino", "www.com.br", perfil.PROFISSIONAL);

		Profissional p3 = new Profissional(0, "Agostinha Camelo Cretella", "branca", "AL", "Maceió",
				"Vila São Pedro", 57015510, "(82) 96932-3198", "ap 20", "marcelina@gmail.com", "123",
				"25/08/1999", "Feminino", "www.com.br", perfil.PROFISSIONAL);
		
		Profissional p4 = new Profissional(0, "Lilian Ignacia Furtunato", "branca", "RN", "Parnamirim",
				"Rua Heleno Noberto Costa", 59155230, "(84) 99616-1472", "ap 12", "lilian.furtunato@mail.com", "123",
				"21/11/1998", "Feminino", "www.com.br", perfil.PROFISSIONAL);
		
		ProfissionalDTO pd1 = new ProfissionalDTO(p1);
		ProfissionalDTO pd2 = new ProfissionalDTO(p2);
		ProfissionalDTO pd3 = new ProfissionalDTO(p3);
		ProfissionalDTO pd4 = new ProfissionalDTO(p4);
		
		pService.createProfissional(pd1);
		pService.createProfissional(pd2);
		pService.createProfissional(pd3);
		pService.createProfissional(pd4);

		Empresa e1 = new Empresa();
		
		Empresa e2 = new Empresa();
		Empresa e3 = new Empresa();
		Empresa e4 = new Empresa();
		
		
		
		PostagensDTO ptd1 = new PostagensDTO(0, 1,"um dia muito lindo", LocalDate.now(), "www.fotomassa.com",0);		
		
		ptService.createPost(ptd1);
		Postagens pt3 = new Postagens();

		
		Seguidores seguidores = new Seguidores();
		ComentariosDTO com = new ComentariosDTO(0, 2, LocalDate.now(), 1, "foto linda amiga");
		
		comService.createComentario(com, 1, 2);
		//proRepository.saveAll(Arrays.asList(p1, p2,p3,p4));

	}

}
