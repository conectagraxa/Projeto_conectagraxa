package com.conecta.conectagraxa.model.dto;

import javax.persistence.Column;
import javax.validation.constraints.Email;

import com.conecta.conectagraxa.model.Empresa;
import com.conecta.conectagraxa.model.annotations.CpfCnpj;
import com.conecta.conectagraxa.model.enums.Perfil;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmpresaDTO {

	private Integer id;

	private String nomeFantasia;

	private String telefone;

	@Column(unique = true)
	@Email
	private String email;

	@CpfCnpj
	private String cpfCnpj;

	private String cidade;

	
	private String estado;

	private String endereco;

	private String complemento;

	private String cep;

	private String senha;

	private String fotoPerfilPath;

	
	Perfil perfil = Perfil.EMPRESA;
	
	private String atual;
	private String novaSenha;
	private String confirma;
	
	
	public EmpresaDTO(Empresa obj) {
		super();
		this.id = obj.getId();

		this.cep = obj.getCep();
		this.nomeFantasia = obj.getNomeFantasia();
		this.telefone = obj.getTelefone();
		this.email = obj.getEmail();
		this.senha = obj.getSenha();
		this.cpfCnpj = obj.getCpfCnpj();
		this.cidade = obj.getCidade();
		this.complemento = obj.getComplemento();
		this.endereco = obj.getEndereco();
		this.estado = obj.getEstado();
		this.fotoPerfilPath = obj.getFotoPerfilPath();
		this.perfil = obj.getPerfil();

	}

	public EmpresaDTO(int id, String nome, String tel, String email, String cnpj, String cidade, String estado,
			String endereco, String complemento, String cep, String senha, String foto) {


		this.id = id;
		this.nomeFantasia =nome;
		this.telefone = tel;
		this.email = email;
		this.cpfCnpj = cnpj;
		this.cidade = cidade;
		this.estado =estado;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cep = cep;
		this.senha = senha;
		this.fotoPerfilPath = foto;

		

	}

				
}


