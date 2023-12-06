package com.conecta.conectagraxa.security;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.beans.BeanUtils;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "google_empresa")
@Data
@NoArgsConstructor

public class GoogleEmpresa {

	public GoogleEmpresa(GoogleEmpresa obj) {
	BeanUtils.copyProperties(obj, this);

	}
	@Id
	private Integer id;
	private String email;
	private String name;
	private Boolean logado;



}
