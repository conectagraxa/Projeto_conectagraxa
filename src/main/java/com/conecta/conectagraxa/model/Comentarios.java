package com.conecta.conectagraxa.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity (name="comentarios")
@NoArgsConstructor
@AllArgsConstructor
public class Comentarios implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@JsonFormat(pattern = "yyyy/MM/dd")
	private LocalDate comentadoEm = LocalDate.now();

	
	@ManyToOne
    @JoinColumn(name = "postagens_id")
	private Postagens postagemId;

	
	@ManyToOne
    @JoinColumn(name = "comentado_por_id")
	private Profissional comentadoPor;
	
	private String descricao;

	

}
