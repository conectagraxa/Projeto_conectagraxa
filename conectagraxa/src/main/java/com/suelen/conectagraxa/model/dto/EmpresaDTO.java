package com.suelen.conectagraxa.model.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpresaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private Integer id;

	
	@NotNull(message = "o campo nome fantasia é requerido")
	private String nome_fantasia;

	@NotNull(message = "o campo telefone é requerido")
	private String telefone;

	@NotNull(message = "o campo email é requerido")
	@Email
	private String email;
	
	@CPF
	
	@NotNull(message = "o campo cpf_cnpj é requerido")
	private String cpf_cnpj;


	@NotNull(message = "o campo cidade é requerido")
	private String cidade;

	
	@NotNull(message = "o campo estado é requerido")
	private String estado;

	@NotNull(message = "o campo endereço é requerido")
	private String endereço;

	@NotNull(message = "o campo complemento é requerido")
	private String complemento;

	@NotNull(message = "o campo cep é requerido")
	
	private Integer cep;



	@NotNull(message = "o campo senha é requerido")
	private String senha;
	
	
	
	private String fotoperfil_path;
	
	private Integer perfil;

}
	