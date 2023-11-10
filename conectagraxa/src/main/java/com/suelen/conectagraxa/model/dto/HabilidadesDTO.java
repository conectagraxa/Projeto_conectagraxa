package com.suelen.conectagraxa.model.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HabilidadesDTO implements Serializable {
	private static final long serialVersionUID = 1L;


	private Integer id;
	
	private String nome_habilidade;
	
	@NotNull(message="feed_profissional é requerido")
	private Integer feed_profissional;
}
