package com.conecta.conectagraxa.model.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.conecta.conectagraxa.model.Comentarios;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class ComentariosDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;

	private Integer comentado_por;

	
	@JsonFormat(pattern = "yyyy/MM/dd")
	private LocalDate comentado_em = LocalDate.now();

	private Integer postagem_id;

	
	private String descricao;
	
	public ComentariosDTO (Comentarios obj) {
		this.id = obj.getId();

		this.comentado_por = obj.getComentadoPor().getId();
		this.comentado_em = obj.getComentadoEm();
		this.postagem_id = obj.getPostagemId().getId();
		this.descricao = obj.getDescricao();
		
	}

	public ComentariosDTO(int id, int por, LocalDate data, int post, String descricao) {
	this.comentado_em = data;
	this.postagem_id = post;
	this.id = id;
	this.comentado_por = por;
	this.descricao = descricao;
	}

}
