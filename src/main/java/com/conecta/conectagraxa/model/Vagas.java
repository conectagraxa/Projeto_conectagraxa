package com.conecta.conectagraxa.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity (name="vagas")
@Table(name="vagas")
public class Vagas implements Serializable {
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull(message = "o campo título é requerido")
	private String titulo;
	
	@NotNull(message = "o campo descrição é requerido")
	private String descricao;
	
	@NotNull(message = "o campo função é requerido")
	private String categoria;
	
	
	private String fotoPath;
	
	@JsonFormat(pattern = "yyyy/MM/dd")
	private LocalDate dataPostagem = LocalDate.now();
	
	
	@NotNull(message ="o campo cidade é requerido")
	private String cidade;
	
	@NotNull(message ="o campo estado é requerido")
	@Column(columnDefinition = "VARCHAR(2)")
	private String estado;


	@OneToMany(mappedBy = "vagasId")
    private List<Candidaturas> candidaturas;


	@ManyToOne
    @JoinColumn(name = "feed_empresas_id")
	private Feed_Empresa feedEmpresaId;
	
	@ManyToOne
    @JoinColumn(name = "empresa_id")
	private Empresa empresaId;
}

