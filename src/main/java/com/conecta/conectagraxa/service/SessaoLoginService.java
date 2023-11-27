package com.conecta.conectagraxa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.conecta.conectagraxa.model.Empresa;
import com.conecta.conectagraxa.model.Profissional;
import com.conecta.conectagraxa.repositories.EmpresaRepository;
import com.conecta.conectagraxa.repositories.ProfissionalRepository;
import com.conecta.conectagraxa.security.SessaoLoginEmpresa;
import com.conecta.conectagraxa.security.SessaoLoginEmpresaRepository;
import com.conecta.conectagraxa.security.SessaoLoginProfissional;
import com.conecta.conectagraxa.security.SessaoLoginProfissionalRepository;

@Service
public class SessaoLoginService {

	@Autowired
	ProfissionalService pService; 
	@Autowired
	ProfissionalRepository pRepository; 


	@Autowired
	EmpresaService eService; 
	
	@Autowired
	EmpresaRepository eRepository; 

	@Autowired
	private SessaoLoginProfissionalRepository SPRepository;
	
	
	@Autowired
	private SessaoLoginEmpresaRepository SERepository;
	
	@Autowired
	private PasswordEncoder enconder;
	
	
	public String LoginProfissional(SessaoLoginProfissional loginP) {
		//loginp.setId(0);
		Optional <Profissional> profissional = pRepository.findByEmail(loginP.getEmail());
		if (profissional.isPresent()) {
			if(!profissional.get().getPerfil().equals(profissional.get().getPerfil().PROFISSIONAL)) {
				return null;
			}if (!enconder.matches(loginP.getSenha(),profissional.get().getSenha())) {
				return null;
			}
				SessaoLoginProfissional login = new SessaoLoginProfissional();

			//SessaoLoginProfissional login = new SessaoLoginProfissional();
			login.setId(profissional.get().getId());
			login.setToken(profissional.get().getToken());
			login.setEmail(loginP.getEmail());
			login.setSenha(enconder.encode(loginP.getSenha()));
			login.setLogado(true);
			SessaoLoginProfissional loginsalvo = login;
			 login = SPRepository.save(loginsalvo);
			 return "Usuário logado com sucesso! Bem vindo "+profissional.get().getNome();
		}
		return "Email ou senha inválidos!";
		
	}

	public String DeslogarProfissional(SessaoLoginProfissional loginP) {
		//loginp.setId(0);
		Optional <SessaoLoginProfissional> login = SPRepository.findByEmail(loginP.getEmail());			
		if(login.isPresent() && login.get().isLogado() == true) {	

		login.get().setLogado(false);
		login.get().setToken(null);
		
		SPRepository.save(login.get());
			return "Fim de sessão";
	}
		return null;
		
	}
	


	public String LoginEmpresa(SessaoLoginEmpresa loginE) {
		//loginp.setId(0);
		Optional <Empresa> empresa = eRepository.findByEmail(loginE.getEmail());
		if (empresa.isPresent()) {
			if(!empresa.get().getPerfil().equals(empresa.get().getPerfil().EMPRESA)) {
				return null;
			}if (!enconder.matches(loginE.getSenha(),empresa.get().getSenha())) {
				return null;
			}
				SessaoLoginEmpresa login = new SessaoLoginEmpresa();

			//SessaoLoginProfissional login = new SessaoLoginProfissional();
			login.setId(empresa.get().getId());
			login.setToken(empresa.get().getToken());
			login.setEmail(loginE.getEmail());
			login.setSenha(enconder.encode(loginE.getSenha()));
			login.setLogado(true);
			SessaoLoginEmpresa loginsalvo = login;
			 login = SERepository.save(loginsalvo);
			 return "Usuário logado com sucesso! Bem vindo "+empresa.get().getNomeFantasia();
		}
		return "Email ou senha inválidos!";
		
	}




	public String DeslogarEmpresa(SessaoLoginEmpresa loginp) {
		//loginp.setId(0);
		Optional <SessaoLoginEmpresa> login = SERepository.findByEmail(loginp.getEmail());			
		if(login.isPresent() && login.get().isLogado() == true) {	

		login.get().setLogado(false);
		login.get().setToken(null);
		
		SERepository.save(login.get());
			return "Fim de sessão";
	}
		return null;
}
	
}