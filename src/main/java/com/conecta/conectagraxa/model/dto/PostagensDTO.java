package com.conecta.conectagraxa.model.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import com.conecta.conectagraxa.model.Postagens;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class PostagensDTO implements Serializable {
	private static final long serialVersionUID = 1L;

private Integer id;
	
	//private Integer idProfissionalId;

    private Integer feedProfissionalId;
	
	@NotNull(message = "o campo descrição é requerido")
	private String descricao;
	
	@JsonFormat(pattern = "yyyy/MM/dd")
	private LocalDate dataPostagem = LocalDate.now();
	
	private String fotoPostagem;
	
	private Integer curtidas;
	
	public PostagensDTO (Postagens obj) {
		this.id = obj.getId();

		this.curtidas = obj.getCurtidas();
		this.descricao = obj.getDescricao();
		this.dataPostagem = obj.getDataPostagem();
		this.fotoPostagem = obj.getFotoPostagem();
	}
	public PostagensDTO (Integer id, Integer feed, String descricao, LocalDate data, String foto, Integer like) {
		this.dataPostagem = data;
		this.curtidas = like;
		this.descricao = descricao;
		this.fotoPostagem = foto;
		this.feedProfissionalId = feed;
	}
	
}
 