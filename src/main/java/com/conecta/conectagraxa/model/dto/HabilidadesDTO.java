package com.conecta.conectagraxa.model.dto;

import java.io.Serializable;

import com.conecta.conectagraxa.model.Habilidades;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class HabilidadesDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private String nomeHabilidade;
	
	private Integer idFeedProfissional;
	
	
	public HabilidadesDTO(Habilidades obj) {
		this.id = obj.getId();
		this.nomeHabilidade = obj.getNomeHabilidade();
		this.idFeedProfissional = obj.getFeedProfissional().getId();
	}
}
