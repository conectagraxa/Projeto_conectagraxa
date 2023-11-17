package com.conecta.conectagraxa.model.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.conecta.conectagraxa.model.Feed_Profissional;
import com.conecta.conectagraxa.model.Profissional;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Feed_ProfissionalDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	

private Integer id;
	
	@NotNull(message ="o campo feed profissional é requerido")
	private Integer idProfissional;
	
	private String sobre;

	public Feed_ProfissionalDTO (Feed_Profissional obj) {
		this.id = obj.getId();
		this.sobre = obj.getSobre();
		this.idProfissional = obj.getIdProfissional().getId();
	}
	
	 	public Feed_ProfissionalDTO (ProfissionalDTO obj) {
 
	 		 this.idProfissional = obj.getId();
}
	 	}
