package com.suelen.conectagraxa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.suelen.conectagraxa.model.dto.EditaisDTO;

import lombok.Data;

@Data
@Entity (name="editais")

public class Editais implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull (message ="url é requerido")
	private String url;
	
	@Column(columnDefinition = "TEXT")
	private String[] dataTitulo;

	
	
	public Editais( EditaisDTO objDTO) {
		super();
		this.id = objDTO.getId();
		this.url = objDTO.getUrl();
		this.dataTitulo = objDTO.getDataTitulo();
		

	}


	

	public Editais() {
		// TODO Auto-generated constructor stub
	}




	public Editais(Integer id, String url, String[] dataTitulo) {
		super();
		this.id = id;
		this.url = url;
		this.dataTitulo = dataTitulo;
	}


}
