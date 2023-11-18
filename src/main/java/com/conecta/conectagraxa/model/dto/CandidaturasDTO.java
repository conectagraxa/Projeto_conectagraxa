package com.conecta.conectagraxa.model.dto;

import java.io.Serializable;

import com.conecta.conectagraxa.model.Candidaturas;

import lombok.Data;

@Data
public class CandidaturasDTO implements Serializable {
	private static final long serialVersionUID = 1L;


	


	private Integer id;
	
	
	private Integer profissionalId;

	private Integer vagasId;

	private Integer empresaId;
	
	
	public CandidaturasDTO (Candidaturas obj) {
		this.id = obj.getId();
		this.profissionalId = obj.getProfissionalId().getId();
		this.vagasId = obj.getVagasId().getId();
		this.empresaId = obj.getEmpresaId().getId();
	}

}
