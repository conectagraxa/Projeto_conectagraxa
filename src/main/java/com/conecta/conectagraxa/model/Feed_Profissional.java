package com.conecta.conectagraxa.model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.conecta.conectagraxa.model.dto.Feed_ProfissionalDTO;
import com.fasterxml.jackson.annotation.JsonManagedReference;



@Entity(name = "feed_profissional")
public class Feed_Profissional implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
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
	        this.postagens = new ArrayList<>();
	        this.habilidades = new ArrayList<>();
	
	
		}
	
	
		public Feed_Profissional(Integer idFeedProfissional) {
			this.id = idFeedProfissional;
	        this.postagens = new ArrayList<>();
	        this.habilidades	 = new ArrayList<>();
	
		}
		public Feed_Profissional() {
	        this.postagens = new ArrayList<>();
	        this.habilidades	 = new ArrayList<>();
	
		}


		public Integer getId() {
			return id;
		}


		public void setId(Integer id) {
			this.id = id;
		}


		public Profissional getIdProfissional() {
			return idProfissional;
		}


		public void setIdProfissional(Profissional idProfissional) {
			this.idProfissional = idProfissional;
		}


		public String getSobre() {
			return sobre;
		}


		public void setSobre(String sobre) {
			this.sobre = sobre;
		}


		public List<Postagens> getPostagens() {
		    if (this.postagens == null) {
		        this.postagens = new ArrayList<>();
		    }
		    return this.postagens;
		}

		public void setPostagens(List<Postagens> postagens) {
			this.postagens = postagens;
		}


		public List<Habilidades> getHabilidades() {
		    if (this.habilidades == null) {
		        this.habilidades = new ArrayList<>();
		    }
		    return this.habilidades;
		}

		public void setHabilidades(List<Habilidades> habilidades) {
			this.habilidades = habilidades;
		}


}
