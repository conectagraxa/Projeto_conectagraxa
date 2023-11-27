package com.conecta.conectagraxa.model;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;

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
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) protege da serialização, mas não funcionou aqui
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
	
	private String token = UUID.randomUUID().toString(); 

	@Column(name ="perfil")	
	/*
	 * perfil de empresa é adicionado logo quando se cadastra.
	 */
	Perfil perfil = Perfil.EMPRESA;
	
	/*
	 * mappedBy é o nome do campo que está associado a Empresa na classe Candidaturas
	 * 
	 */
	@OneToMany(mappedBy = "empresaId")
    private List<Candidaturas> candidaturas;
	
	@OneToMany(mappedBy = "empresaId")
	private List<Vagas> vagasEmpresa;
	
	/*
	 * todas as ações da empresa
	 */
	@OneToOne(cascade = CascadeType.ALL,	fetch = FetchType.EAGER,mappedBy = "idEmpresa")
	private Feed_Empresa feedEmpresa;
	
	/*
	 * conversão de tipos de empresa -> dto
	 */
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


