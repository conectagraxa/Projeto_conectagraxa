package com.conecta.conectagraxa.model.dto;

import com.conecta.conectagraxa.model.Categorias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoriasDTO {

	
	private Integer id;
	private String categorias;
	public CategoriasDTO(Categorias obj) {
		this.id = obj.getId();
		this.categorias = obj.getCategorias();
	}
	
	
}
