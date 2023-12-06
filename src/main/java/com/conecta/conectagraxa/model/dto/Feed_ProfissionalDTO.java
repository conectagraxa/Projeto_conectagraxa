package com.conecta.conectagraxa.model.dto;

import java.io.Serializable;

import javax.persistence.Id;

import com.conecta.conectagraxa.model.Feed_Profissional;
import com.conecta.conectagraxa.model.Profissional;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Feed_ProfissionalDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private Integer id;

	private Integer idProfissional;

	private String sobre;

	public Feed_ProfissionalDTO(Feed_Profissional obj) {
		this.id = obj.getId();
		this.sobre = obj.getSobre();
		this.idProfissional = obj.getIdProfissional().getId();
	}

	public Feed_ProfissionalDTO(ProfissionalDTO obj) {

		this.idProfissional = obj.getId();
		this.getId();
	}

	public Feed_ProfissionalDTO(Profissional obj) {

		this.idProfissional = obj.getId();
		this.id = obj.getId();
	}

	public Feed_ProfissionalDTO(Integer id) {
		this.id = id;
	}

	

}
