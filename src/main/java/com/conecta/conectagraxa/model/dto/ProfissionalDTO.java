package com.conecta.conectagraxa.model.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.Email;

import com.conecta.conectagraxa.model.Profissional;
import com.conecta.conectagraxa.model.enums.Perfil;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProfissionalDTO implements Serializable {

		
	private static final long serialVersionUID = 1L;
	
	
	private Integer id;
	
	private String nome;
	
	private String etnia;
	
	private String estado;
	
	private String cidade;
	
	private String endereco;
	
	private String complemento;
	
	private Integer cep;
	
	private String telefone;
	
	@Email
	private String email;
	
	private String senha;

	 // @JsonFormat(pattern = "dd/MM/yyyy") 
	private LocalDate dataNascimento;

	private String sexo;
	
	private String fotoPerfil;

	Perfil perfil = Perfil.PROFISSIONAL;
	

	
	private String atual;
	private String novaSenha;
	private String confirma;
	
	public ProfissionalDTO(Profissional obj) {
		super();
		this.id = obj.getId();

		this.cep = obj.getCep();
		this.dataNascimento = obj.getDataNascimento();
		this.etnia = obj.getEtnia();
		this.sexo = obj.getSexo();
		this.nome= obj.getNome();
		this.telefone = obj.getTelefone();
		this.email = obj.getEmail();
		this.senha = obj.getSenha();
		this.cidade = obj.getCidade();
		this.complemento = obj.getComplemento();
		this.endereco = obj.getEndereco();
		this.estado = obj.getEstado();
		this.fotoPerfil = obj.getFotoPerfil();
		this.perfil = obj.getPerfil();
		this.atual = getAtual();
		this.novaSenha = getNovaSenha();
		this.confirma = getConfirma();

	}

	public ProfissionalDTO(List<Profissional> obj) {
	}
	

	


}
