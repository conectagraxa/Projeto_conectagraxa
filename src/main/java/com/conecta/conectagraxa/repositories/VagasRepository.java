package com.conecta.conectagraxa.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.conecta.conectagraxa.model.Vagas;

@Repository
public interface VagasRepository extends JpaRepository<Vagas, Integer> {
	Optional<Vagas> findByTituloIgnoreCaseContaining(String titulo);

//	@Query("select v from vagas v where v.categoria = 1")
	//Optional<Vagas> findByCategoria(Integer codigo);
	//List<Vagas> findAllByCategoria(Integer id);
	//@Query("select v:titulo from vagas v where categoriaId.id = 1")
	//@Query("select v from vagas v where v.categoriaId = :categoriaId")
	//@Query("select v from vagas v where v.categoriaId = :categoriaId")
    //List<Vagas> findByCategoriaContaining(String categoria);

	
	
//	List<Vagas> findByCategoriaIdContaining(Categoria categoriaId);
	List<Vagas> findByCategoriasUp(Integer categoriaId);

	//List<Vagas> findAll(Optional<Vagas> obj);

   // List<Vagas> findByCategoriaContaining(Categoria categoria);

	@Modifying(clearAutomatically = true)
	@Query(value = "delete from vagas c where c.id=:id")
	  public void deleteById(@Param("id") int id);

	List<Vagas> findByTitulo(String titulo);

}
