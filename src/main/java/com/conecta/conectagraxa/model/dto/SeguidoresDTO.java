package com.conecta.conectagraxa.model.dto;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.conecta.conectagraxa.model.Profissional;
import com.conecta.conectagraxa.model.Seguidores;

import lombok.Data;

@Data
public class SeguidoresDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	
	private Integer seguidoresId;

	private Integer seguindoId;

	public SeguidoresDTO (Seguidores obj) {
		
		this.id = obj.getId();
		this.seguidoresId = obj.getSeguidoresId().getId();
		this.seguindoId = obj.getSeguindoId().getId();
	}

}
