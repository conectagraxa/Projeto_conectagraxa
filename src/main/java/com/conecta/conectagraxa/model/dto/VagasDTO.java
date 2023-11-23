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
	
	@JsonFormat(pattern = "yyyy/MM/dd")
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
			
	}

}
