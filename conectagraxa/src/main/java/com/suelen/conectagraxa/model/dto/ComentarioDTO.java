package com.suelen.conectagraxa.model.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComentarioDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	
	
	private Integer id;

	@NotNull(message ="comentado_por é requerido ")
	private Integer comentado_por;

	
	@NotNull(message ="comentado_em é requerido ")
	private LocalDate comentado_em = LocalDate.now();

	@NotNull(message ="postagem_id é requerido ")
	private Integer postagem_id;

	
	@NotNull(message ="descricao é requerido")
	private String descricao;

	
}