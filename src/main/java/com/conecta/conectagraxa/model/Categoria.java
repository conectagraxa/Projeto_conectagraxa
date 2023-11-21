package com.conecta.conectagraxa.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="categorias")
public class Categoria implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String categorias;
	@OneToMany(cascade = CascadeType.ALL, 	fetch = FetchType.EAGER,mappedBy = "categoriaId")	 
	 private Set<Vagas> vagas = new HashSet<>();
	public Categoria(Integer id) {
		super();
		this.id = id;
	}
	
	
	
	
}