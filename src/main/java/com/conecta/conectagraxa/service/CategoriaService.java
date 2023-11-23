package com.conecta.conectagraxa.service;

import java.util.Arrays;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conecta.conectagraxa.model.Categoria;
import com.conecta.conectagraxa.repositories.CategoriaRepository;
@Service
public class CategoriaService {
/*
 * @Param essa classe moca as 5 categorias das vagas existentes, e servem para fazer a filtragem das vagas.
 * no banco , esses são os ids das categorias:
 *  1	Todos
 *  2	Áudio e Som
 *  3	Iluminação
 *  4	Palco
 *  5	Equipamentos
 *  
 *  No front, colocar o nome dos selects no cadastro das vagas iguais a esses.
 * 
 */
	
	@Autowired
	CategoriaRepository repository;
	
	  //trazer empresa por id
    public Categoria CategoriaById(Integer id) throws Exception {
        Optional<Categoria> obj = repository.findById(id);
		return obj.orElseThrow(() -> new Exception ("objeto não encontrado Id: " + id));

    }

    /*
     * @Param moca as informações
     */
		@Transactional
		public void insertCat() {
			Categoria cab1 = new Categoria(); cab1.setCategorias("Todos ");
			Categoria cab2 = new Categoria(); cab2.setCategorias("Áudio e Som");
			Categoria cab3 = new Categoria(); cab3.setCategorias("Iluminação");
			Categoria cab4 = new Categoria(); cab4.setCategorias("Palco");
			Categoria cab5 = new Categoria(); cab5.setCategorias("Equipamentos");


			repository.saveAll(Arrays.asList(cab1,cab2,cab3,cab4,cab5));
		
    }
}
