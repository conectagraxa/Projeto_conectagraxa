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
@Entity (name="post")

public class Post implements Serializable {
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	//@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "feed_profissional", referencedColumnName = "id")
	private Integer id_profissional_id;
	
//	@ManyToOne(fetch = FetchType.LAZY)
	//@JoinColumn(name = "feed_profissional", referencedColumnName = "id")
	private Integer feed_profissional_id;
	
	@NotNull(message = "o campo descrição é requerido")
	private String descricao;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate data_postagem = LocalDate.now();
	
	private String foto_postagem;
	
	private Integer curtidas;
	
}
