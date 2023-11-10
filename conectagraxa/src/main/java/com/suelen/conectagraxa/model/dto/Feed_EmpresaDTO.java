package com.suelen.conectagraxa.model.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Feed_EmpresaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;
	
	@NotNull(message ="o campo feed empresa é requerido")
	private Integer id_emprsa;
	
	private String sobre;
	
}
