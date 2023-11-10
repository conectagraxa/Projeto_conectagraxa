package com.suelen.conectagraxa.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
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
@Entity (name="cursos")

public class Cursos implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull
//	@ManyToOne(fetch = FetchType.LAZY)
	//@JoinColumn(name = "feed_profissional", referencedColumnName = "id")
	private Integer feed_profissional_id;
	
	
	@NotNull
	private String instituicao;
	
	@NotNull
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date inicio;

	@NotNull
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date fim;
}
