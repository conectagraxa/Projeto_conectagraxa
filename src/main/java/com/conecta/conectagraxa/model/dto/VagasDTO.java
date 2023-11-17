package com.conecta.conectagraxa.model.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.conecta.conectagraxa.model.Vagas;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
@Data
public class VagasDTO implements Serializable {
	private static final long serialVersionUID = 1L;
private Integer id;
	
	@NotNull(message = "o campo título é requerido")
	private String titulo;
	
	@NotNull(message = "o campo descrição é requerido")
	private String descricao;
	
	@NotNull(message = "o campo função é requerido")
	private String categoria;
	

	@NotNull
	private Integer empresaId;
	
	private String fotoPath;
	
	@JsonFormat(pattern = "yyyy/MM/dd")
	private LocalDate dataPostagem = LocalDate.now();
	
	
	


	private Integer feedEmpresaId;
	
	
	@NotNull(message ="o campo cidade é requerido")
	private String cidade;
	
	@NotNull(message ="o campo estado é requerido")
	private String estado;
	
	public VagasDTO (Vagas obj) {
		this.categoria = obj.getCategoria();
		this.dataPostagem = obj.getDataPostagem();
		this.cidade = obj.getCidade();
		this.empresaId = obj.getEmpresaId().getId();
		this.fotoPath = obj.getFotoPath();
		this.descricao = obj.getDescricao();
		this.estado = obj.getEstado();
		this.feedEmpresaId = obj.getFeedEmpresaId().getId();
		this.titulo = obj.getTitulo();
		this.id = obj.getId();
		
	}

}
