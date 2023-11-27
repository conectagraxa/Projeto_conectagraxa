package com.conecta.conectagraxa.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.beans.BeanUtils;

import com.conecta.conectagraxa.model.dto.VagasDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "vagas")
public class Vagas implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String titulo;

	private String descricao;

	private String fotoPath;

	/*
	 * formatando inserção formato ano/mês/dia
	 */

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataPostagem = LocalDate.now();

	private String cidade;
	/*
	 * restrição de campo com máximo 2 char
	 */
	@Column(columnDefinition = "VARCHAR(2)")
	private String estado;

	/*
	 * Elemento pai de candidaturas, o cascadeType.ALL garante que operações crud
	 * seja refletidas no filho
	 * 
	 * @param orphanRemoval = true : exclui a candidatura da vaga no banco por que
	 * ela é filha de vagas.
	 */
	@OneToMany(mappedBy = "vagasId", cascade = CascadeType.ALL/* , orphanRemoval = true */)
	@JsonIgnore
	private List<Candidaturas> candidaturas;

	/*
	 * JsonIgnore está protegendo da serialização
	 */
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "feed_empresas_id")
	private Feed_Empresa feedEmpresaId;

	@ManyToOne
	@JsonIgnore
	// @JsonBackReference essa anotação foi perigosa aqui, fez uma serialização.
	@JoinColumn(name = "empresa_id")
	private Empresa empresaId;

	/*
	 * parte muitos do relacionamento, a vaga é many, categoria é one. fazendo join
	 * com Categoria, e inserindo foreing uma foreing key na tabela que liga ao id
	 * de categoria
	 */
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "categoria_id")
	private Categoria categoriaId;

	private Integer categoriasUp;

	public Vagas(VagasDTO obj) {
		this.titulo = obj.getTitulo();
		this.descricao = obj.getDescricao();
		this.cidade = obj.getCidade();
		this.estado = obj.getEstado();
		this.fotoPath = obj.getFotoPath();
		this.categoriasUp = obj.getCategoriaId();

	}

	public Vagas(Vagas obj) {
		// copiando os objetos dessa classe para o obj (os nomes tem que ser iguais)
		BeanUtils.copyProperties(obj, this);

	}

	public void deleteCandidaturas() {
		if (candidaturas != null) {
			for (Candidaturas candidatura : candidaturas) {
				// removendo a associação com a vaga antes de deletar a candidatura
				candidatura.setVagasId(null);
			}
		}
	}

	public void deleteFeedEmpresa() {
		if (feedEmpresaId != null) {
			// removendo a associação com a vaga antes de deletar o feed da empresa
			feedEmpresaId.setVagas(null);
		}
	}

	public void deleteEmpresa() {
		if (empresaId != null) {
			// removendo a associação com a vaga antes de deletar a empresa
			empresaId.setVagasEmpresa(null);
		}

	}

	public void deleteCategoria() {
		if (categoriaId != null) {
			// removendo a associação com a vaga antes de deletar a empresa
			categoriaId.setVagas(null);
			// categoriasUp =null;
		}

	}

}
