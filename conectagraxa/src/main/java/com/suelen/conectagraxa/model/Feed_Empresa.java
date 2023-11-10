package com.suelen.conectagraxa.model;

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

import lombok.Data;

@Data
@Entity (name="feed_empresa")

public class Feed_Empresa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull(message ="o campo feed empresa é requerido")
//	@OneToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "feed_empresa", referencedColumnName = "id")
	private Integer id_emprsa;
	
	private String sobre;
	
}
