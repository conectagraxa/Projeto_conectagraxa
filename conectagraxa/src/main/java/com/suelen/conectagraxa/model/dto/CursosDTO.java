package com.suelen.conectagraxa.model.dto;

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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CursosDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private Integer id;

	@NotNull(message ="feed_profissional é requerido ")
	private Integer feed_profissional_id;
	
	
	@NotNull (message ="instituição é requerido")
	private String instituicao;
	
	@NotNull
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date inicio;

	@NotNull
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date fim;
}
