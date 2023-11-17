package com.conecta.conectagraxa.model.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import com.conecta.conectagraxa.model.Comentarios;
import com.conecta.conectagraxa.model.Postagens;
import com.conecta.conectagraxa.model.Profissional;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class ComentariosDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;

	@NotNull(message ="comentado_por é requerido ")
	private Integer comentado_por;

	
	@NotNull(message ="postagem_id é requerido ")
	@JsonFormat(pattern = "yyyy/MM/dd")
	private LocalDate comentado_em = LocalDate.now();

	@NotNull
	private Integer postagem_id;

	
	@NotNull
	private String descricao;
	
	public ComentariosDTO (Comentarios obj) {
		this.id = obj.getId();
		this.comentado_por = obj.getComentadoPor().getId();
		this.comentado_em = obj.getComentadoEm();
		this.postagem_id = obj.getPostagemId().getId();
		this.descricao = obj.getDescricao();
		
	}

}
