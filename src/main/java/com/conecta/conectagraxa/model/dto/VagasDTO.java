package com.conecta.conectagraxa.model.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

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
	
	private String categoria;
	
	private Integer empresaId;
	
	private String fotoPath;
	
	@JsonFormat(pattern = "yyyy/MM/dd")
	private LocalDate dataPostagem = LocalDate.now();
	
	private Integer feedEmpresaId;
	
	
	private String cidade;
	
	private String estado;
	
	public VagasDTO (Vagas obj) {
		this.id = obj.getId();

		this.categoria = obj.getCategoria();
		this.dataPostagem = obj.getDataPostagem();
		this.cidade = obj.getCidade();
		this.empresaId = obj.getEmpresaId().getId();
		this.fotoPath = obj.getFotoPath();
		this.descricao = obj.getDescricao();
		this.estado = obj.getEstado();
		this.feedEmpresaId = obj.getFeedEmpresaId().getId();
		this.titulo = obj.getTitulo();
		
	}

}
