package com.suelen.conectagraxa.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import lombok.Data;

@Data
@Entity (name="empresa")

public class Empresa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	
	@NotNull(message = "o campo nome fantasia é requerido")
	private String nome_fantasia;

	@NotNull(message = "o campo telefone é requerido")
	private String telefone;

	@NotNull(message = "o campo email é requerido")
	@Column(unique = true)
	@Email
	private String email;
	
	@CPF
	@Column(unique = true)
	@NotNull(message = "o campo cpf_cnpj é requerido")
	private String cpf_cnpj;


	@NotNull(message = "o campo cidade é requerido")
	private String cidade;

	
	@NotNull(message = "o campo estado é requerido")
	@Column(columnDefinition = "VARCHAR(2)")
	private String estado;

	@NotNull(message = "o campo endereço é requerido")
	private String endereço;

	@NotNull(message = "o campo complemento é requerido")
	private String complemento;

	@NotNull(message = "o campo cep é requerido")
	@Column(columnDefinition = "INT(8)")
	private Integer cep;



	@NotNull(message = "o campo senha é requerido")
	private String senha;
	
	
	//@OneToMany
	//private List <Vagas> vagas;
	private String fotoperfil_path;
	
	private Integer perfil;

}
	