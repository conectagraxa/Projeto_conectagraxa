package com.conecta.conectagraxa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.conecta.conectagraxa.model.Empresa;
import com.conecta.conectagraxa.model.Profissional;
import com.conecta.conectagraxa.repositories.EmpresaRepository;
import com.conecta.conectagraxa.repositories.GoogleProfissionalRepository;
import com.conecta.conectagraxa.repositories.ProfissionalRepository;
import com.conecta.conectagraxa.repositories.SessaoLoginEmpresaRepository;
import com.conecta.conectagraxa.repositories.SessaoLoginProfissionalRepository;
import com.conecta.conectagraxa.security.GoogleProfissional;
import com.conecta.conectagraxa.security.SessaoLoginEmpresa;
import com.conecta.conectagraxa.security.SessaoLoginProfissional;

@Service
public class SessaoLoginService {

	@Autowired
	ProfissionalService pService; 
	@Autowired
	ProfissionalRepository pRepository; 
	@Autowired
	GoogleProfissionalRepository gRepository; 


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
		if (profissional.isPresent() || profissional.get() != null) {
			if(!profissional.get().getPerfil().equals(profissional.get().getPerfil().PROFISSIONAL)) {
				return null;
			}if (!enconder.matches(loginP.getSenha(),profissional.get().getSenha())) {
				return null;
			}
				SessaoLoginProfissional login = new SessaoLoginProfissional();
			//SessaoLoginProfissional login = new SessaoLoginProfissional();
			login.setId(profissional.get().getId());
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
		
		SPRepository.save(login.get());
			return "Fim de sessão";
	}
		return null;
		
	}
	

	public String loginGoogleProfisional(GoogleProfissional google) {
		//loginp.setId(0);
		Optional <Profissional> profissional = pRepository.findByEmail(google.getEmail());
		if (profissional.isPresent()) {
			Optional <GoogleProfissional> googleLogado = gRepository.findByEmail(google.getEmail());
			
			if(googleLogado.isPresent()) {
				googleLogado.get().setId(googleLogado.get().getId());
				googleLogado.get().setLogado(true);
				if (googleLogado.get().getName() != null) {
					googleLogado.get().setName(googleLogado.get().getName());
				}
				if (googleLogado.get().getEmail() != null) {
					googleLogado.get().setEmail(googleLogado.get().getEmail());
				}
				
				GoogleProfissional atualizado = googleLogado.get();
				//atualizado.setId(googleLogado.get().getId());
				gRepository.save(atualizado);
			}
			GoogleProfissional login = new GoogleProfissional();
			//SessaoLoginProfissional login = new SessaoLoginProfissional();
			login.setId(profissional.get().getId());
			login.setEmail(google.getEmail());
			login.setLogado(true);
			login.setName(google.getName());
			 login = gRepository.save(login);
			 return "Usuário logado com sucesso! Bem vindo "+profissional.get().getNome();
		}else {
		
		GoogleProfissional login = new GoogleProfissional();
		login.setEmail(google.getEmail());
		login.setLogado(true);
		login.setName(google.getName());
		
		GoogleProfissional loginsalvo = login;
		Profissional criandoConta = new Profissional(loginsalvo);
		pRepository.save(criandoConta);		
		login.setId(criandoConta.getId());
		gRepository.save(loginsalvo);

		return "Usuário logado com sucesso! Bem vindo "+login.getName();
		}
		
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
		
		SERepository.save(login.get());
			return "Fim de sessão";
	}
		return null;
}
	
}