package com.conecta.conectagraxa.model.dto;

import java.io.Serializable;
import java.util.Date;

import com.conecta.conectagraxa.model.Cursos;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class CursosDTO implements Serializable {
	private static final long serialVersionUID = 1L;


	private Integer id;

	private Integer feedProfissionalId;
	
	private String titulo;
	
	
	private String instituicao;
	
	@JsonFormat(pattern = "yyyy/MM/dd")
	private Date inicio;

	@JsonFormat(pattern = "yyyy/MM/dd")
	private Date fim;

	public CursosDTO (Cursos obj) {
		this.id = obj.getId();

		this.feedProfissionalId = obj.getFeedProfissionalId().getId();
		this.titulo = obj.getTitulo();
		this.instituicao = obj.getInstituicao();
		this.inicio = obj.getInicio();
		this.fim = obj.getFim();
		
	}
}