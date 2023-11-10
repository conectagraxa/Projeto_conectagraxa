package com.suelen.conectagraxa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.suelen.conectagraxa.model.Editais;

@Repository
public interface EditaisRepository extends JpaRepository<Editais, Integer>{

}
