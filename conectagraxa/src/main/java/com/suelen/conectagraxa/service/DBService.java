
	package com.suelen.conectagraxa.service;

	import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suelen.conectagraxa.repositories.EditaisRepository;
import com.suelen.conectagraxa.repositories.EmpresaRepository;
import com.suelen.conectagraxa.repositories.PostRepository;
import com.suelen.conectagraxa.repositories.ProfissionalRepository;

	@Service
	public class DBService {
		
		
		@Autowired EditaisRepository editaisRepository;
		
		public void instanciaDB() {
			
			
			
		}
	}
