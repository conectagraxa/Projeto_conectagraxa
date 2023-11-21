package com.conecta.conectagraxa.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.conecta.conectagraxa.model.dto.Feed_EmpresaDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity (name="feed_empresas")
public class Feed_Empresa implements Serializable {
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToMany(mappedBy = "feedEmpresaId")
    private List<Vagas> vagas;
	
	
	@OneToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name = "empresa_id")
	@NotNull(message ="o campo feed empresa é requerido")
	private Empresa idEmpresa;
	
	private String sobre;
	
	
	public Feed_Empresa(Feed_EmpresaDTO feedDTO) {
		this.id = feedDTO.getId();
	}
	
	public Feed_Empresa(Integer idFeedEmpresa) {
	}
}
