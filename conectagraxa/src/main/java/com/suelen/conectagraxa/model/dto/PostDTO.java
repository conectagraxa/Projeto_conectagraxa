package com.suelen.conectagraxa.model.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private Integer id;
	
	private Integer id_profissional_id;
	
	private Integer feed_profissional_id;
	
	@NotNull(message = "o campo descrição é requerido")
	private String descricao;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate data_postagem = LocalDate.now();
	
	private String foto_postagem;
	
	private Integer curtidas;

}
