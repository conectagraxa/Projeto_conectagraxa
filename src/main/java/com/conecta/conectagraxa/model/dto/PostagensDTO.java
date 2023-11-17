package com.conecta.conectagraxa.model.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import com.conecta.conectagraxa.model.Feed_Profissional;
import com.conecta.conectagraxa.model.Postagens;
import com.conecta.conectagraxa.model.Profissional;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
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
		this.curtidas = obj.getCurtidas();
		this.id = obj.getId();
		this.descricao = obj.getDescricao();
		this.dataPostagem = obj.getDataPostagem();
		this.fotoPostagem = obj.getFotoPostagem();
	}
	
}
