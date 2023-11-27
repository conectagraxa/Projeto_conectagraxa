package com.conecta.conectagraxa.model.dto;

import java.io.Serializable;

import com.conecta.conectagraxa.model.Seguidores;

import lombok.Data;

@Data
public class SeguidoresDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	

	private Integer id;

	private Integer seguidoresId;

	private Integer seguindoId;

	public SeguidoresDTO (Seguidores obj) {
		this.id = obj.getId();

		this.seguidoresId = obj.getSeguidoresId().getId();
		this.seguindoId = obj.getSeguindoId().getId();
	}

}
