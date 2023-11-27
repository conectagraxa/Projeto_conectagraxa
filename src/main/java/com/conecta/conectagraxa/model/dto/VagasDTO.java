package com.conecta.conectagraxa.model.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.conecta.conectagraxa.model.Vagas;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class VagasDTO implements Serializable {
private static final long serialVersionUID = 1L;
private Integer id;
	
	private String titulo;
	
	private String descricao;
	
	//@Enumerated(EnumType.STRING)
	private Integer categoriaId ;
	
	
	private String fotoPath;

	  @JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataPostagem = LocalDate.now();
	
	private String cidade;
	
	private String estado;
	
	private Integer feedEmpresaId;
	private Integer empresaId;

	
	public VagasDTO (Vagas obj) {
		this.id = obj.getId();
		this.titulo = obj.getTitulo();
		this.cidade = obj.getCidade();
		this.fotoPath = obj.getFotoPath();
		this.descricao = obj.getDescricao();
		this.estado = obj.getEstado();
		this.empresaId = obj.getEmpresaId().getId();
		this.feedEmpresaId = obj.getFeedEmpresaId().getId();
		this.categoriaId = obj.getCategoriasUp();
			
	}

	public VagasDTO (Integer id, String titulo, String cidade, String foto, String descricao, String estado, Integer empresaId, Integer feed ,Integer categoria) {
		this.id = id;
		this.titulo = titulo;
		this.cidade = cidade;
		this.fotoPath = foto;
		this.descricao = descricao;
		this.estado = estado;
		this.empresaId = empresaId;
		this.feedEmpresaId = feed;
	this.categoriaId = categoria;
	}

}
