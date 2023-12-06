package com.conecta.conectagraxa.security;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.beans.BeanUtils;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "google_profissional")
@Data
@NoArgsConstructor

public class GoogleProfissional {

	public GoogleProfissional(GoogleProfissional google) {
	BeanUtils.copyProperties(google, this);

	}
	@Id
	private Integer id;
	private String email;
	private String name;
	private Boolean logado;



}
