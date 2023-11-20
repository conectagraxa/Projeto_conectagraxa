package com.conecta.conectagraxa.service;

import java.util.Arrays;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conecta.conectagraxa.model.Categorias;
import com.conecta.conectagraxa.repositories.CategoriasRepository;


@Service
public class CategoriasService {

	
	@Autowired
	CategoriasRepository repository;
	
	@Transactional
	public void insertCat() {
		Categorias cab1 = new Categorias(); cab1.setCategorias("Todos ");
		Categorias cab2 = new Categorias(); cab2.setCategorias("Áudio e Som");
		Categorias cab3 = new Categorias(); cab3.setCategorias("Iluminação");
		Categorias cab4 = new Categorias(); cab4.setCategorias("Palco");
		Categorias cab5 = new Categorias(); cab5.setCategorias("Equipamentos");
		
		
		repository.saveAll(Arrays.asList(cab1,cab2,cab3,cab4,cab5));
	}

}
