package com.conecta.conectagraxa.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.conecta.conectagraxa.model.dto.HabilidadesDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity (name="habilidades")
@Table(name = "habilidades")

public class Habilidades implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nomeHabilidade;
	
	@ManyToOne
    @JoinColumn(name = "feed_profissional_id")
	private Feed_Profissional feedProfissional;

	public Habilidades(HabilidadesDTO objDTO) {
	this.id = objDTO.getId();
	this.nomeHabilidade = objDTO.getNomeHabilidade();
	}
	
	public Habilidades(Habilidades obj) {
		this.id = obj.getId();
		this.nomeHabilidade = obj.getNomeHabilidade();
		this.feedProfissional = obj.getFeedProfissional();
		}
		

}
