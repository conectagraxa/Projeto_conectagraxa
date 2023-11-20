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
import com.conecta.conectagraxa.model.dto.EmpresaDTO;
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

	//faltam 9 endpoints - vagas service:  4 - candidaturas service: 5
	
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


	
	
	public void instanciaDB() throws Exception {
		Cursos cursos = new Cursos();
	
		
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

		
		
		
		EmpresaDTO e4 = new EmpresaDTO(0, "Bento e Felipe Shows Ltda","11981914484","financeiro@bentoefelipeshowsltda.com.br","13422762000128","São Paulo","SP","Travessa Ibiquera","462","03755095","123","www.fotoperfil.com");
		eService.createEmpresa(e4);

		EmpresaDTO e3 = new EmpresaDTO(0, "Sebastiana e Cecília Padaria ME","83992576628","agencia@backstage2.com.br","86920873000138","Cabedelo","PB","Rua Antônio Benício de Oliveira","Nº 21","58103064","123","www.fotoperfil.com");
		eService.createEmpresa(e3);

		EmpresaDTO e2 = new EmpresaDTO(0, "Priscila e Bianca Eletrônica ME","83986393365","tesouraria@priscilaebiancaeletronicame.com.br","34347667000187","João Pessoa","PB","Rua Carlos Drumond Andrade","AP 235","58062008","123","www.fotoperfil.com");
		eService.createEmpresa(e2);

		PostagensDTO ptd1 = new PostagensDTO(0, 1,"um dia muito lindo", LocalDate.now(), "www.fotomassa.com",0);				
		ptService.createPost(ptd1.getFeedProfissionalId(),ptd1);
		
		
		PostagensDTO ptd2 = new PostagensDTO();

		
		Seguidores seguidores = new Seguidores();
		ComentariosDTO com = new ComentariosDTO(0, 2, LocalDate.now(), 1, "foto linda amiga");		
		comService.createComentario(com, 1, 2);
		//proRepository.saveAll(Arrays.asList(p1, p2,p3,p4));

	}

}
