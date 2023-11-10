package com.suelen.conectagraxa.model;

import java.io.Serializable;
import java.time.LocalDate;

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
@Entity (name="vagas")

public class Vagas implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull(message = "o campo título é requerido")
	private String titulo;
	
	@NotNull(message = "o campo descrição é requerido")
	private String descricao;
	
	@NotNull(message = "o campo função é requerido")
	private String funcao;;
	
//	@ManyToOne
	//@JoinColumn(name = "empresa", referencedColumnName = "id")
	private Integer empresa_id;
	
	private String foto_path;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate data_postagem = LocalDate.now();
	
	
	private Double valor_pagar;
	
	@NotNull(message ="o campo tipo de contratação é requerido")
	private String tipo_contratacao;

//	@ManyToOne(fetch = FetchType.LAZY)
	//@JoinColumn(name = "feed_empresa", referencedColumnName = "id")
	private Integer feed_empresa_id;
	
	
	@NotNull(message ="o campo cidade é requerido")
	private String cidade;
	
	@NotNull(message ="o campo estado é requerido")
	@Column(columnDefinition = "VARCHAR(2)")
	private String estado;


}
