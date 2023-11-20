package com.conecta.conectagraxa.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import com.conecta.conectagraxa.model.annotations.CpfCnpj;
import com.conecta.conectagraxa.model.dto.EmpresaDTO;
import com.conecta.conectagraxa.model.enums.Perfil;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity (name="empresa")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Empresa implements Serializable {
	private static final long serialVersionUID = 1L;


	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY  )
	private Integer id;

	@Column(name ="nome")	
	private String nomeFantasia;

	@Column(name ="telefone")	

	private String telefone;

	@Column(name ="email",unique = true)
	@Email
	private String email;
	
	@CpfCnpj
	@Column(name ="cpfCnpj",unique = true)
	private String cpfCnpj;


	@Column(name ="cidade")	
	private String cidade;

	@Column (name="estado",columnDefinition = "VARCHAR(2)")
	private String estado;
	
	@Column(name ="endereco")
	private String endereco;
	@Column(name ="complemento")
	private String complemento;


	@Column (name ="cep",columnDefinition = "VARCHAR(8)")
	private String cep;
	
	@Column(name ="senha")	
	private String senha;
	
	
	@Column(name ="fotoperfil")	
	private String fotoPerfilPath;
	@Column(name ="perfil")	
	Perfil perfil = Perfil.EMPRESA;
	
	@OneToMany(mappedBy = "empresaId")
    private List<Candidaturas> candidaturas;
	
	@OneToOne(cascade = CascadeType.ALL, 	fetch = FetchType.EAGER,mappedBy = "idEmpresa")
	private Feed_Empresa feedEmpresa;
	
	
	public Empresa(EmpresaDTO objDTO ) {
		super();
		this.id = objDTO.getId();
		this.cep = objDTO.getCep();
		this.nomeFantasia = objDTO.getNomeFantasia();
		this.telefone = objDTO.getTelefone();
		this.email = objDTO.getEmail();
		this.senha = objDTO.getSenha();
		this.cpfCnpj = objDTO.getCpfCnpj();
		this.cidade = objDTO.getCidade();
		this.complemento = objDTO.getComplemento();
		this.endereco = objDTO.getEndereco();
		this.endereco = objDTO.getEndereco();
		this.estado = objDTO.getEstado();
		this.fotoPerfilPath = objDTO.getFotoPerfilPath();
		this.perfil = objDTO.getPerfil();

		
	}

	
	

	

	}


