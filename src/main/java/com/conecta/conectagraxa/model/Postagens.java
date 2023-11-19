package com.conecta.conectagraxa.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.conecta.conectagraxa.model.dto.PostagensDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity (name="postagens")
public class Postagens implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	
	private String descricao;
	
	@JsonFormat(pattern = "yyyy/MM/dd")
	private LocalDate dataPostagem = LocalDate.now();
	
	private String fotoPostagem;
	
	private Integer curtidas;
	
	@OneToMany(mappedBy = "postagemId")
    private List<Comentarios> comentarios;

	@JsonBackReference
	@ManyToOne
    @JoinColumn(name = "feed_profissional_id")
	private Feed_Profissional feedProfissionalId;
	

	public Postagens (PostagensDTO objDTO) {
		this.id = objDTO.getId();
		this.descricao = objDTO.getDescricao();
		this.dataPostagem = objDTO.getDataPostagem();
		this.fotoPostagem = objDTO.getFotoPostagem();
	}


	public Postagens (Integer objDTO) {
	
	
	}


	public Postagens(Postagens obj) {
		this.id = obj.getId();
		this.descricao = obj.getDescricao();
		this.dataPostagem = obj.getDataPostagem();
		this.fotoPostagem = obj.getFotoPostagem();
		this.comentarios = obj.comentarios;
		this.feedProfissionalId = obj.feedProfissionalId;

	}

	
}
