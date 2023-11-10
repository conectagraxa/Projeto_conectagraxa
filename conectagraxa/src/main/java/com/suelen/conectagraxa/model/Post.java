package com.suelen.conectagraxa.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;


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

	// Mesmo inserindo o Lombok como arquivo externo no buildPath n funcionou. Ent vou adicionar o Getters e setters
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId_profissional_id() {
		return id_profissional_id;
	}

	public void setId_profissional_id(Integer id_profissional_id) {
		this.id_profissional_id = id_profissional_id;
	}

	public Integer getFeed_profissional_id() {
		return feed_profissional_id;
	}

	public void setFeed_profissional_id(Integer feed_profissional_id) {
		this.feed_profissional_id = feed_profissional_id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDate getData_postagem() {
		return data_postagem;
	}

	public void setData_postagem(LocalDate data_postagem) {
		this.data_postagem = data_postagem;
	}

	public String getFoto_postagem() {
		return foto_postagem;
	}

	public void setFoto_postagem(String foto_postagem) {
		this.foto_postagem = foto_postagem;
	}

	public Integer getCurtidas() {
		return curtidas;
	}

	public void setCurtidas(Integer curtidas) {
		this.curtidas = curtidas;
	}
	
	

}
