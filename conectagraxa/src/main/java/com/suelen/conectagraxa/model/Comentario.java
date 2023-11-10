package com.suelen.conectagraxa.model;

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

import lombok.Data;

@Data
@Entity (name="comentario")

public class Comentario implements Serializable {
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull(message ="comentado_por é requerido ")
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "profissional", referencedColumnName = "id")
	private Integer comentado_por;

	
	@NotNull(message ="postagem_id é requerido ")
	@JsonFormat(pattern = "dd/MM/yyyy")
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "profissional", referencedColumnName = "id")
	private LocalDate comentado_em = LocalDate.now();

	@NotNull
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "postagem", referencedColumnName = "id")
	private Integer postagem_id;

	
	@NotNull
	private String descricao;

	
}