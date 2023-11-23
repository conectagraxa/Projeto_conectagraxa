package com.conecta.conectagraxa.model;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) protege da serialização, mas não funcionou aqui
@Entity(name="categorias")

public class Categoria implements Serializable {
	private static final long serialVersionUID = 1L;

	
	/*
  *		Digo ao spring que o campo não é uma coluna no banco com essa anotação -> @Transient
  *    
  *    
  */
	

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String categorias;
	
	
	
	
	@OneToMany(targetEntity=Vagas.class,cascade = CascadeType.ALL, /*orphanRemoval = true	*/fetch = FetchType.EAGER,mappedBy = "categoriaId")	 
	private Set<Vagas> vagas = new HashSet<>();
	
	
	
	public Categoria(Integer id) {
		super();
		this.id = id;
	}
	public void deleteVagas() {	
		if (vagas != null) {
			for (Vagas vaga : vagas) {
		        //Set<Vagas> vagasTemporarias = new HashSet<>(vagas);
		       // limpa todas as vagas da lista associada ->  vagas.clear();
				// removendo a associação com a categoria antes de deletar a vaga
				vagas.remove(vaga);
				//sincronizando alterações da lista set 
				/*Set<Vagas> syncList = */Collections.synchronizedSet(vagas);
				//transformando um set em uma lista de new Categoria , coleta e passa para uma lista 
				//List<Categoria> categorias = syncList.stream().distinct().map(x -> new Categoria(x)).collect(Collectors.toList());
				
			}
		}
	}

	public Categoria(Vagas x) {
	}
	
	
}	