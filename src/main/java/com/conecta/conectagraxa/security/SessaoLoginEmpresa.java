package com.conecta.conectagraxa.security;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.beans.BeanUtils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
/*
 * @param classe model (entity) login da empresa.
 */
public class SessaoLoginEmpresa {

	@Id
	private Integer id;
	private String email;
	private String senha;
	private boolean logado;
	
	public SessaoLoginEmpresa(SessaoLoginEmpresa obj) {
		BeanUtils.copyProperties(obj, this);
	}
	
	
}
