package com.conecta.conectagraxa.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conecta.conectagraxa.model.Profissional;
import com.conecta.conectagraxa.model.dto.ComentariosDTO;
import com.conecta.conectagraxa.model.dto.CursosDTO;
import com.conecta.conectagraxa.model.dto.EmpresaDTO;
import com.conecta.conectagraxa.model.dto.PostagensDTO;
import com.conecta.conectagraxa.model.dto.ProfissionalDTO;
import com.conecta.conectagraxa.model.dto.VagasDTO;
import com.conecta.conectagraxa.model.enums.Perfil;

@Service
public class DBService {

	//assinatura com gateway de pagamento - upgrade futuro
	
	//notificações de candidaturas e quem curtiu posts - upgrade futuro
	
	//chat para comunicação entre empresa e profissional - upgrade futuro
	
	//lançamento de editais com webscrapping - upgrade futuro
	
	//implementação da classe userDetails - upgrade futuro
	
	//compartilhar posts e vagas - upgrade futuro
	
	//favoritar posts e vagas - upgrade futuro
	
	//tratamento exceções - upgrade futuro
	
	//login google - upgrade futuro
	
	//usuários mandar mensagens entre si - upgrade futuro
	
	//login profissional autenticado - jwt (com jwt é upgrade futuro) - ok
	
	//login empresa autenticada - jwt - (com jwt é upgrade futuro) 
	
	//autorização de rotas profissional - security (usado uma variavél token com um valor fixado)

	//autorização de rotas empresa - security

	//encriptografar senha profissional - ok - usado o Serviço Bcrypt 
	
	//encriptografar senha empresa 

	//faltam 5 endpoints - candidaturas service: 5
	
	
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
	CategoriaService catService;
	
	public void instanciaDB() throws Exception {
		catService.insertCat();

		
		Profissional p1 = new Profissional(0, "Marcos Oliveira Jr.", "pardo", "PE", "cabrobó", "rua malafaia",
				29906460, "(81) 2876-4327", "ap 10", "marcosoliveirajr@mail.com", "123", LocalDate.of(2001,8,21), "Masculino",
				"www.com.br", perfil.PROFISSIONAL);

		Profissional p2 = new Profissional(0, "Agostinha Camelo Cretella", "branca", "RJ", "cabrobó",
				"Rua Ana José", 26282020, "(24) 99188-9311", "ap 20", "bryancarvalho.souza3@hotmail.com", "123",
				LocalDate.of(1998,9,25), "Feminino", "www.com.br", perfil.PROFISSIONAL);

		Profissional p3 = new Profissional(0, "Severina", "branca", "AL", "Maceió",
				"Vila São Pedro", 57015510, "(82) 96932-3198", "ap 20", "marcelina@gmail.com", "123",
				LocalDate.of(2003,11,21), "Feminino", "www.com.br", perfil.PROFISSIONAL);
		
		Profissional p4 = new Profissional(0, "Lilian Ignacia Furtunato", "branca", "RN", "Parnamirim",
				"Rua Heleno Noberto Costa", 59155230, "(84) 99616-1472", "ap 12", "lilian.furtunato@mail.com", "123",
				LocalDate.of(1981,12,24), "Feminino", "www.com.br", perfil.PROFISSIONAL);
	
		Profissional p5 = new Profissional(0, "Suelen", "branca", "RN", "Parnamirim",
				"Rua Heleno Noberto Costa", 59155230, "(84) 99616-1472", "ap 12", "suelen@mail.com", "123",
				LocalDate.of(2000,01,01), "Feminino", "www.com.br", perfil.PROFISSIONAL);
	
		
		ProfissionalDTO pd1 = new ProfissionalDTO(p1);
		ProfissionalDTO pd2 = new ProfissionalDTO(p2);
		ProfissionalDTO pd3 = new ProfissionalDTO(p3);
		ProfissionalDTO pd4 = new ProfissionalDTO(p4);
		
		ProfissionalDTO pd5 = new ProfissionalDTO(p5);
		
		pService.createProfissional(pd1);
		pService.createProfissional(pd2);
		pService.createProfissional(pd3);
		pService.createProfissional(pd4);
		pService.createProfissional(pd5);
		
		CursosDTO c1 = new CursosDTO(0,1,"Curso de tecnico de palco","AMP",  LocalDate.of(2003,12,03) , LocalDate.of (2004,01,01));
		cService.createCurso(c1);
	
		CursosDTO c2 = new CursosDTO(0,2,"Curso de tecnico de áudio","AMP",  LocalDate.of(2004,12,03) , LocalDate.of (2005,01,01));
		cService.createCurso(c2);
	
		CursosDTO c3 = new CursosDTO(0,3,"Curso de tecnico imagem e luz","AMP",  LocalDate.of(2005,12,03) , LocalDate.of (2007,01,01));
		cService.createCurso(c3);
	
		CursosDTO c4 = new CursosDTO(0,4,"Curso Técnico de tecnico imagem e luz","AMP",  LocalDate.of(2005,12,03) , LocalDate.of (2008,01,01));
		cService.createCurso(c4);
	
		CursosDTO c5 = new CursosDTO(0,5,"Curso de publicidade","AMP",  LocalDate.of(2004,12,03) , LocalDate.of (2005,01,01));
		cService.createCurso(c5);
	
	/*	  1	Todos
		  *  2	Áudio e Som
		  *  3	Iluminação
		  *  4	Palco
		  *  5	Equipamentos
		  */
		
	
		EmpresaDTO e4 = new EmpresaDTO(0, "Bento e Felipe Shows Ltda","11981914484","financeiro@bentoefelipeshowsltda.com.br","13422762000128","São Paulo","SP","Travessa Ibiquera","462","03755095","123","www.fotoperfil.com");
		eService.createEmpresa(e4);
		
		EmpresaDTO e3 = new EmpresaDTO(0, "Sebastiana e Cecília Padaria ME","83992576628","agencia@backstage2.com.br","86920873000138","Cabedelo","PB","Rua Antônio Benício de Oliveira","Nº 21","58103064","123","www.fotoperfil.com");
		eService.createEmpresa(e3);
		
		EmpresaDTO e2 = new EmpresaDTO(0, "Priscila e Bianca Eletrônica ME","83986393365","tesouraria@priscilaebiancaeletronicame.com.br","34347667000187","João Pessoa","PB","Rua Carlos Drumond Andrade","AP 235","58062008","123","www.fotoperfil.com");
		eService.createEmpresa(e2);

		
		VagasDTO vagasDTO1 = new VagasDTO(0,"Tecnico de áudio", "Panáma","www.descricaofoto.com","Precisamos de alguém que tenha vontade de aprender a ser técnico de áudio","RN",1,1,2);
		vService.createVaga(vagasDTO1, 1);
	
		VagasDTO vagasDTO5 = new VagasDTO(0,"Banco de talentos", "Brasil","www.descricaofoto.com","Cadastre seu currículo em nosso banco de talentos","BR",1,1,1);
		vService.createVaga(vagasDTO5, 1);
	
		VagasDTO vagasDTO2 = new VagasDTO(0,"Tecnico de Palco", "Recife","www.descricaofoto.com","Precisamos de alguém que tenha vontade de ser técnico de palco","PE",1,1,4);
		vService.createVaga(vagasDTO2, 2);
	
		VagasDTO vagasDTO3 = new VagasDTO(0,"Tecnico de Iluminação", "Mangabá","www.descricaofoto.com","Precisamos de alguém que tenha experiência trabalhando como técnico de iluminação","RJ",1,1,3);
		vService.createVaga(vagasDTO3, 3);
	
		VagasDTO vagasDTO4 = new VagasDTO(0,"Tecnico de Equipamentos", "São Paulo","www.descricaofoto.com","Precisamos de alguém que tenha vontade de ser técnico de Equipamentos","SP",1,1,5);
		vService.createVaga(vagasDTO4, 3);
		
		
		PostagensDTO ptd1 = new PostagensDTO(0, 1,"um dia muito lindo", LocalDate.now(), "www.fotomassa.com",0);				
		ptService.createPost(ptd1.getFeedProfissionalId(),ptd1);
		
		PostagensDTO ptd2 = new PostagensDTO(0, 3,"um show incrível e de muita emoção", LocalDate.now(), "www.localstorage1234.com.br",0);				
		ptService.createPost(ptd2.getFeedProfissionalId(),ptd2);
		

		PostagensDTO ptd3 = new PostagensDTO(0, 2,"que honra poder fazer parte do backstage desse grande show", LocalDate.now(), "www.localhome1234.com.br",0);				
		ptService.createPost(ptd3.getFeedProfissionalId(),ptd3);
		
		PostagensDTO ptd4 = new PostagensDTO(0, 4,"acredito que a vida é um show, e por trás dos palcos damos o brilho a esse show", LocalDate.now(), "www.localhost1234.com.br",0);				
		ptService.createPost(ptd4.getFeedProfissionalId(),ptd4);
		

		sService.seguir(1, 2);
		sService.seguir(2, 1);
		sService.seguir(2, 3);
		sService.seguir(3, 2);
		sService.seguir(4, 3);
		sService.seguir(3, 4);
		sService.seguir(5, 4);
		sService.seguir(4, 5);

		ComentariosDTO com1 = new ComentariosDTO(0, 2, LocalDate.now(), 1, "foto linda amiga");		
		comService.createComentario(com1, 1, 2);
		
		
		//proRepository.saveAll(Arrays.asList(p1, p2,p3,p4));

	}

}
