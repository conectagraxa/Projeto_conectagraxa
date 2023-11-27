package com.conecta.conectagraxa.model.dto;

import java.io.Serializable;
import java.time.LocalDate;

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
	private LocalDate inicio;

	@JsonFormat(pattern = "yyyy/MM/dd")
	private LocalDate fim;

	public CursosDTO (Cursos obj) {
		this.id = obj.getId();

		this.feedProfissionalId = obj.getFeedProfissionalId().getId();
		this.titulo = obj.getTitulo();
		this.instituicao = obj.getInstituicao();
		this.inicio = obj.getInicio();
		this.fim = obj.getFim();
		
	}

	public CursosDTO (Integer id,Integer feed, String titulo, String instituicao, LocalDate inicio, LocalDate fim) {
		this.id= id;
		this.feedProfissionalId = feed;
		this.titulo = titulo;
		this.instituicao = instituicao;
		this.inicio = inicio;
		this.fim = fim;
	}
	
}