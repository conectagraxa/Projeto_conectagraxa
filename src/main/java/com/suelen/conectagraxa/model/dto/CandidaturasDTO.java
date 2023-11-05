package com.suelen.conectagraxa.model.dto;

import java.io.Serializable;

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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidaturasDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private Integer id;
	
	@NotNull(message ="profissional_id é requerido ")
	private Integer profissional_id;
	
	@NotNull(message ="vagas_id é requerido ")
	private Integer vagas_id;

}
