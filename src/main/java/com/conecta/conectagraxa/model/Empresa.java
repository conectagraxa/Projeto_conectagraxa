package com.conecta.conectagraxa.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
@Table(name="empresa")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Empresa implements Serializable {
	private static final long serialVersionUID = 1L;


	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY  )
	private Integer id;

	
	private String nomeFantasia;

	private String telefone;

	@Column(unique = true)
	@Email
	private String email;
	
	@CpfCnpj
	@Column(unique = true)
	private String cpfCnpj;


	private String cidade;


	@Column (columnDefinition = "VARCHAR(2)")
	private String estado;

	private String endereco;

	private String complemento;

	@Column (columnDefinition = "VARCHAR(8)")
	private Integer cep;
	
	
	private String senha;
		
	private String fotoPerfilPath;
	
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


