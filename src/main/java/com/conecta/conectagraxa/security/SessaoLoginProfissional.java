package com.conecta.conectagraxa.security;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;

import org.springframework.beans.BeanUtils;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Data
/*
 * @param classe model (entity) login do profissional.
 */
public class SessaoLoginProfissional {
	@Id
	private Integer id;
	@Email
	private String email;
	private String senha;
	private boolean logado;
	private String token;
	
	public SessaoLoginProfissional(SessaoLoginProfissional obj) {
		BeanUtils.copyProperties(obj, this);

	}


}
