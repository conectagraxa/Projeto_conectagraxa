package com.suelen.conectagraxa.model.dto;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EditaisDTO implements Serializable {
	private static final long serialVersionUID = 1L;


	

	private Integer id;
	
	@NotNull (message ="url é requerido")
	private String url;
	@NotNull (message ="titulo e data é requerido")
	private String[] dataTitulo;
	
	

	@NotNull(message = "titulo e data é requerido")
	public String[] getDataTitulo() {
		// TODO Auto-generated method stub
		return null;
	}
}
