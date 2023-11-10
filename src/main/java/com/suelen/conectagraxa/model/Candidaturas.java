package com.suelen.conectagraxa.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity (name="candidaturas")

public class Candidaturas implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	
//	@JoinColumn(name = "profissional", referencedColumnName = "id")
	private Integer profissional_id;

	
	
	//@JoinColumn(name = "vagas", referencedColumnName = "id")
	private Integer vagas_id;

}
