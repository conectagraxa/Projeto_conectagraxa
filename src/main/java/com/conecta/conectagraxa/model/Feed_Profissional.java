package com.conecta.conectagraxa.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

import com.conecta.conectagraxa.model.dto.Feed_ProfissionalDTO;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "feed_profissional")
public class Feed_Profissional implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;


	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name = "profissional_id")
	private Profissional idProfissional;

	private String sobre;

	@JsonManagedReference
	@OneToMany(mappedBy = "feedProfissionalId")
	private List<Postagens> postagens;
	
	@OneToMany(mappedBy = "feedProfissional")
	private List<Habilidades> habilidades;

	
	public Feed_Profissional(Feed_ProfissionalDTO feedDTO) {
		this.id = feedDTO.getId();
	}


	public Feed_Profissional(Integer idFeedProfissional) {
	}
}
