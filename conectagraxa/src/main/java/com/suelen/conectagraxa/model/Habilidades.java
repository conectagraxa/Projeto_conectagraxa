package com.suelen.conectagraxa.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity (name="habilidades")

public class Habilidades implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nome_habilidade;
	
	//@ManyToOne(fetch = FetchType.LAZY)
	//@JoinColumn(name = "feed_profissional", referencedColumnName = "id")
	private Integer feed_profissional;
}
