package com.conecta.conectagraxa.model;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.conecta.conectagraxa.model.dto.CandidaturasDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity (name="candidaturas")
@NoArgsConstructor
@AllArgsConstructor
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) protege da serialização, mas não funcionou aqui
public class Candidaturas implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn( name = "profissional_id")
	private Profissional profissionalId;
	
	@ManyToOne
    @JoinColumn(name = "vagas_id")
	private Vagas vagasId;
	
	
	@ManyToOne
    @JoinColumn(name = "empresa_id")
	private Empresa empresaId;
	
	public Candidaturas (CandidaturasDTO obj) {
	}
}
