package com.conecta.conectagraxa.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.beans.BeanUtils;

import com.conecta.conectagraxa.model.dto.VagasDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
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
	
	private String fotoPath;
	
	@JsonFormat(pattern = "yyyy/MM/dd")
	private LocalDate dataPostagem = LocalDate.now();
	
	
	private String cidade;
	
	@Column(columnDefinition = "VARCHAR(2)")
	private String estado;


	@OneToMany(mappedBy = "vagasId")
    private List<Candidaturas> candidaturas;


	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "feed_empresas_id")
	private Feed_Empresa feedEmpresaId;
	
	@ManyToOne
	@JsonIgnore
    @JoinColumn(name = "empresa_id")
	private Empresa empresaId;
	
	@ManyToOne
	@JsonIgnore
    @JoinColumn(name = "categoria_id")
	private Categoria categoriaId;
    
	private Integer categoriasUp;
	
	public Vagas(VagasDTO obj) {
	this.titulo = obj.getTitulo();
	this.descricao = obj.getDescricao();
	this.cidade = obj.getCidade();
	this.estado= obj.getEstado();
	this.fotoPath = obj.getFotoPath();
	this.categoriasUp = obj.getCategoriaId();
	}	public Vagas(Vagas obj) {
	//copiando os objetos dessa classe para o obj (os nomes tem que ser iguais)
	BeanUtils.copyProperties(obj, this);
	
	}
	}

