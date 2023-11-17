package com.conecta.conectagraxa.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.conecta.conectagraxa.model.dto.ProfissionalDTO;
import com.conecta.conectagraxa.model.enums.Perfil;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity (name="profissional")
@Table(name="profissional")
public class Profissional implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY  )
	private Integer id;
	
	private String nome;
	
	private String etnia;
	
	@Column(columnDefinition = "VARCHAR(2)")
	private String estado;
	
	private String cidade;
	
	private String endereco;
	
	private String complemento;
	
	@Column (columnDefinition = "VARCHAR(8)")
	private Integer cep;

	private String telefone;
	
	@Email
	private String email;
	
	private String senha;

	@JsonFormat(pattern = "yyyy/MM/dd")
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;

	private String sexo;
	private String fotoPerfil;
	
	Perfil perfil = Perfil.PROFISSIONAL;

	

	

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "profissionalId")
    private List<Candidaturas> candidaturas;
    
    @OneToOne(cascade = CascadeType.ALL, 	fetch = FetchType.EAGER,mappedBy = "idProfissional")
    private Feed_Profissional feedProfissional;


    
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "seguidoresId")
    private Set<Seguidores> seguidores = new HashSet<Seguidores>();
    
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "seguindoId")
    private Set<Seguidores> seguindo = new HashSet<Seguidores>();;
    
    
  /*  //se relacionando com postagens na parte 1 do relacionamento um para muitos
    @OneToMany(cascade = CascadeType.ALL, 	fetch = FetchType.EAGER,mappedBy = "idProfissionalId")
    private List<Postagens> postagens;*/
    
    
    //se relacionando com comentários na parte 1 do relacionamento um para muitos
    @OneToMany(mappedBy = "comentadoPor")
    private List<Comentarios> comentarios;
    
    public Profissional(ProfissionalDTO objDTO) {
		super();
		this.id = objDTO.getId();
		this.cep = objDTO.getCep();
		this.dataNascimento = objDTO.getDataNascimento();
		this.etnia = objDTO.getEtnia();
		this.sexo = objDTO.getSexo();
		this.nome= objDTO.getNome();
		this.telefone = objDTO.getTelefone();
		this.email = objDTO.getEmail();
		this.senha = objDTO.getSenha();
		this.cidade = objDTO.getCidade();
		this.complemento = objDTO.getComplemento();
		this.endereco = objDTO.getEndereco();
		this.estado = objDTO.getEstado();
		this.fotoPerfil = objDTO.getFotoPerfil();
		this.perfil = objDTO.getPerfil();
		
		
	}
    
    public Profissional (Profissional obj) {
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
		this.feedProfissional = obj.getFeedProfissional();
		
    }

	
    
    

		
}
