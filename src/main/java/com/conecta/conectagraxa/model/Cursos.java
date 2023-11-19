package com.conecta.conectagraxa.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.conecta.conectagraxa.model.dto.CursosDTO;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "cursos")

@NoArgsConstructor
@AllArgsConstructor
public class Cursos implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "feed_profissional_id")

	private Feed_Profissional feedProfissionalId;

	private String titulo;

	private String instituicao;

	@JsonFormat(pattern = "yyyy/MM/dd")
	private Date inicio;

	@JsonFormat(pattern = "yyyy/MM/dd")
	private Date fim;

	public Cursos(CursosDTO obj) {
		this.id = obj.getId();
		this.titulo = obj.getTitulo();
		this.instituicao = obj.getInstituicao();
		this.inicio = obj.getInicio();
		this.fim = obj.getFim();
	}

	public Cursos(Cursos obj) {

	}

}