package com.conecta.conectagraxa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.conecta.conectagraxa.model.Profissional;
import com.conecta.conectagraxa.repositories.ProfissionalRepository;
import com.conecta.conectagraxa.security.SessaoLoginProfissional;
import com.conecta.conectagraxa.security.SessaoLoginProfissionalRepository;

@Service
public class SessaoLoginService {

	@Autowired
	ProfissionalService pService; 
	@Autowired
	ProfissionalRepository pRepository; 
	
	@Autowired
	private SessaoLoginProfissionalRepository repository;
	
	@Autowired
	private PasswordEncoder enconder;
	
	
	public String LoginProfissional(SessaoLoginProfissional loginp) {
		//loginp.setId(0);
		Optional <Profissional> profissional = pRepository.findByEmail(loginp.getEmail());
		if (profissional.isPresent()) {
			if(!profissional.get().getPerfil().equals(profissional.get().getPerfil().PROFISSIONAL)) {
				return null;
			}if (!enconder.matches(loginp.getSenha(),profissional.get().getSenha())) {
				return null;
			}
				SessaoLoginProfissional login = new SessaoLoginProfissional();

			//SessaoLoginProfissional login = new SessaoLoginProfissional();
			login.setId(profissional.get().getId());
			login.setToken(login.getToken());
			login.setEmail(loginp.getEmail());
			login.setSenha(enconder.encode(loginp.getSenha()));
			login.setLogado(true);
			SessaoLoginProfissional loginsalvo = login;
			 login = repository.save(loginsalvo);
			 return "Usuário logado com sucesso! Bem vindo "+profissional.get().getNome();
		}
		return "Email ou senha inválidos!";
		
	}

	public String DeslogarProfissional(SessaoLoginProfissional loginp) {
		//loginp.setId(0);
		Optional <SessaoLoginProfissional> login = repository.findByEmail(loginp.getEmail());			
		if(login.isPresent() && login.get().isLogado() == true) {	

		login.get().setLogado(false);
		login.get().setToken(null);
		
		repository.save(login.get());
			return "Fim de sessão";
	}
		return null;
		
	}
	







}
