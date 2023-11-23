package com.conecta.conectagraxa.model.dto;

import java.io.Serializable;

import com.conecta.conectagraxa.model.Feed_Empresa;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class Feed_EmpresaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

private Integer id;
	
	private Integer idEmpresa;
	
	private String sobre;
	
	
	public Feed_EmpresaDTO (Feed_Empresa obj) {
		this.id = obj.getId();
		this.sobre = obj.getSobre();
		this.idEmpresa = obj.getIdEmpresa().getId();
	}
	
	public Feed_EmpresaDTO (EmpresaDTO obj) {
		 
		 this.idEmpresa = obj.getId();
}
}
