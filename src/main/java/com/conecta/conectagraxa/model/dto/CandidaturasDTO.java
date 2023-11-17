package com.conecta.conectagraxa.model.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.conecta.conectagraxa.model.Candidaturas;
import com.conecta.conectagraxa.model.Vagas;

import lombok.Data;

@Data
public class CandidaturasDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	

	
	private Integer id;
	
	
	@NotNull
	private Integer profissionalId;

	@NotNull
	private Integer vagasId;

	@NotNull
	private Integer empresaId;
	
	
	public CandidaturasDTO (Candidaturas obj) {
		this.id = obj.getId();
		this.profissionalId = obj.getProfissionalId().getId();
		this.vagasId = obj.getVagasId().getId();
		this.empresaId = obj.getEmpresaId().getId();
	}


}
