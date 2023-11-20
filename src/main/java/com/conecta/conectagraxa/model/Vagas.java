package com.conecta.conectagraxa.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.conecta.conectagraxa.model.dto.VagasDTO;
import com.conecta.conectagraxa.model.enums.Categoria;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity (name="vagas")
public class Vagas implements Serializable {

	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String titulo;
	
	private String descricao;
	
	private Categoria categoria;
	
	
	private String fotoPath;
	
	@JsonFormat(pattern = "yyyy/MM/dd")
	private LocalDate dataPostagem = LocalDate.now();
	
	
	private String cidade;
	
	@Column(columnDefinition = "VARCHAR(2)")
	private String estado;


	@OneToMany(mappedBy = "vagasId")
    private List<Candidaturas> candidaturas;


	@ManyToOne
    @JoinColumn(name = "feed_empresas_id")
	private Feed_Empresa feedEmpresaId;
	
	@ManyToOne
    @JoinColumn(name = "empresa_id")
	private Empresa empresaId;
	public Vagas(VagasDTO obj) {
	this.titulo = obj.getTitulo();
	this.descricao = obj.getDescricao();
	this.categoria = obj.getCategoria();
	this.cidade = obj.getCidade();
	this.estado= obj.getEstado();
	this.fotoPath = obj.getFotoPath();
	
	
	}

}

