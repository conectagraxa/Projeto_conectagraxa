package com.conecta.conectagraxa.model;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.conecta.conectagraxa.model.dto.Feed_EmpresaDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity (name="feed_empresas")
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) protege da serialização, mas não funcionou aqui
public class Feed_Empresa implements Serializable {
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToMany(mappedBy = "feedEmpresaId",cascade = CascadeType.ALL/*, orphanRemoval = true*/)
    private List<Vagas> vagas;

	/*
	 * Empresa um pra um do feed, tem reflexo das ações no feed em todas as operações CRUD.
	 * Quando uma empresa é criada, um feed também é criado se relacionando com a empresa e com o mesmo id.
	 * Também se aplica a relacionamentos OneToMany , a parte One é quem deve ter o efeito cascada e refletida na filha.
	 */
	@OneToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name = "empresa_id")
	private Empresa idEmpresa;
	
	private String sobre;

	
	public Feed_Empresa(Feed_EmpresaDTO feedDTO) {
		this.id = feedDTO.getId();
	}
	
	public Feed_Empresa(Integer idFeedEmpresa) {
	}
	/*
	 * remove associação com vaga quando chamado.
	 */
	public void deleteVagas() {
		if (vagas != null) {
			for (Vagas vaga : vagas) {
				// removendo a associação com o feedEmpresa antes de deletar a vaga
				vagas.remove(vaga);
				//vagas.clear();
				/*
				 * Atualizando e sincronizando a lista com as alterações de vagas
				 */
				List<Vagas> syncList = Collections.synchronizedList(vagas);


			}
		}
	}
}
