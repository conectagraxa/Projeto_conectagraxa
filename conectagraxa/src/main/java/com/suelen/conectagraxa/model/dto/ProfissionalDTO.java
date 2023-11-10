package com.suelen.conectagraxa.model.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfissionalDTO implements Serializable {
	private static final long serialVersionUID = 1L;


	private Integer id;
	
	@NotNull(message = "o campo nome é requerido")
	private String nome;
	
	@NotNull(message = "o campo etnia é requerido")
	private String etnia;
	
	@NotNull(message = "o campo estado é requerido")
	private String estado;
	
	@NotNull(message = "o campo cidade é requerido")
	private String cidade;
	
	@NotNull(message = "o campo endereço é requerido")
	private String endereço;
	
	@NotNull(message = "o campo complemento é requerido")
	private String complemento;
	
	@NotNull(message = "o campo cep é requerido")
	private Integer cep;

	@NotNull(message = "o campo telefone é requerido")
	private String telefone;
	
	@Email
	@NotNull(message = "o campo email é requerido")
	private String email;
	
	@NotNull(message = "o campo senha é requerido")
	private String senha;

	@NotNull(message = "o campo data de nascimento é requerido")
	private Date data_nascimento;

	@NotNull(message = "o campo sexo é requerido")
	private String sexo;
	private String foto_perfil;
	private String role;

}
