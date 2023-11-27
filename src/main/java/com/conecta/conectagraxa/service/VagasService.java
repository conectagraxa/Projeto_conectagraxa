package com.conecta.conectagraxa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conecta.conectagraxa.model.Categoria;
import com.conecta.conectagraxa.model.Empresa;
import com.conecta.conectagraxa.model.Feed_Empresa;
import com.conecta.conectagraxa.model.Vagas;
import com.conecta.conectagraxa.model.dto.VagasDTO;
import com.conecta.conectagraxa.repositories.CategoriaRepository;
import com.conecta.conectagraxa.repositories.VagasRepository;

/*
 * @version 1.0
 * @Param serviço do controlador excluir, editar, pesquisar, filtrar, criar vagas 
 */
@Service
public class VagasService {

	/*
	 * @Param Repositório Vagas
	 */
	@Autowired
	VagasRepository repository;

	/*
	 * @Param Repositório Categoria
	 */
	@Autowired
	CategoriaRepository cRepository;

	/*
	 * @Param Service Empresa
	 */
	@Autowired
	EmpresaService empService;

	/*
	 * @Param Service Categoria
	 */
	@Autowired
	CategoriaService cService;
	/*
	 * @Param Service Feed
	 */
	@Autowired
	Feed_EmpresaService feedService;

	/*
	 * @param CRIAR VAGA
	 * parâmetro : VagasDTO, Integer
	 */
	
	@Transactional
	public Vagas createVaga(VagasDTO vaga, Integer id) throws Exception {
		// procurando se o id da empresa e feed se existe
		Feed_Empresa feedEmpresa = feedService.findById(id);
		Empresa empresa = empService.findById(id);
		
		//verificando se categoria existe
		Categoria categoria = cService.CategoriaById(vaga.getCategoriaId());
		categoria.setId(vaga.getCategoriaId());
		vaga.setCategoriaId(vaga.getCategoriaId());
		Vagas vagas = new Vagas(vaga);

		// setando os dados passados no vagasDTO (Oque vai vai no corpo da requisição)
		vagas.setTitulo(vaga.getTitulo());
		vagas.setFotoPath(vaga.getFotoPath());
		vagas.setDescricao(vaga.getDescricao());
		vagas.setCidade(vaga.getCidade());
		vagas.setEstado(vaga.getEstado());
		vagas.setDataPostagem(vagas.getDataPostagem());
		// seta feed e empresa
		vagas.setFeedEmpresaId(feedEmpresa);
		vagas.setEmpresaId(empresa);
		vagas.setCategoriaId(categoria);
		// adiciona a vaga setada no feed da empresa
		categoria.getVagas().add(vagas);
		feedEmpresa.getVagas().add(vagas);
		// salva no banco
		Vagas novaVaga = repository.save(vagas);

		// retorna um model vagas com valor atualizado
		return novaVaga;

	}
	//todos os profissionais
	public List<Vagas> getAllVagas() {
		return repository.findAll();
	}


	/*
	 * @Param esse método EDITA UMA VAGA no corpo da requisição (vagaDTO)
	 *  Integer é usado para associar ao feed e verificação se existe o feed e empresa. 
	 */
	public Vagas editarVaga(VagasDTO vagaDTO, Integer id) throws Exception {
		/*
		 * procurando se o id da vaga e empresa existe	
		 */
		/*Feed_Empresa feedEmpresa =/* feedService.findById(id);
		/*Empresa empresa = */empService.findById(id);
		Categoria categoria = cService.CategoriaById(vagaDTO.getCategoriaId());
		Vagas novaVaga = new Vagas();
		Optional <Vagas> vagas = repository.findById(id);
		if(vagas.isPresent()) {
		novaVaga.setId(vagas.get().getId());

		/* 
		 *	recuperando e verificando se os dados encontrados no
		 *	banco estão vazios, se não estiver, pega a informação e mantém no newObj
		 *	
		 *  leitura informações já existentes
		 */
		if (vagas.get().getCategoriaId() != null) {
			novaVaga.setCategoriaId(vagas.get().getCategoriaId());
		}
		if (vagas.get().getTitulo() != null) {
			novaVaga.setTitulo(vagas.get().getTitulo());
		}
		if (vagas.get().getFotoPath() != null) {
			novaVaga.setFotoPath(vagas.get().getFotoPath());
		}
		if (vagas.get().getDescricao() != null) {
			novaVaga.setDescricao(vagas.get().getDescricao());
		}
		if (vagas.get().getCidade() != null) {
			novaVaga.setCidade(vagas.get().getCidade());
		}
		if (vagas.get().getEstado() != null) {
			novaVaga.setEstado(vagas.get().getEstado());
		
		}if(vagas.get().getCategoriasUp() !=null) {
			novaVaga.setCategoriasUp(vagas.get().getCategoriasUp());
		}
		novaVaga.setDataPostagem(vagas.get().getDataPostagem());
		novaVaga.setFeedEmpresaId(vagas.get().getFeedEmpresaId());
		novaVaga.setEmpresaId(vagas.get().getEmpresaId());
		novaVaga.setCandidaturas(vagas.get().getCandidaturas());
		
		//input novas informações
		//recuperando e verificando se os campos do update na requisição
		//estão vazios, se não estiver, pega a informação e seta no newObj
		
		if (vagaDTO.getCategoriaId() != null) {
			novaVaga.setCategoriaId(categoria);
		}
		if (vagaDTO.getTitulo() != null) {
			novaVaga.setTitulo(vagaDTO.getTitulo());
		}
		if (vagaDTO.getFotoPath() != null) {
			novaVaga.setFotoPath(vagaDTO.getFotoPath());
		}
		if (vagaDTO.getDescricao() != null) {
			novaVaga.setDescricao(vagaDTO.getDescricao());
		}
		if (vagaDTO.getCidade() != null) {
			novaVaga.setCidade(vagaDTO.getCidade());
		}
		if (vagaDTO.getEstado() != null) {
			novaVaga.setEstado(vagaDTO.getEstado());
		}if(vagaDTO.getCategoriaId() !=null) {
			
			novaVaga.setCategoriasUp(vagaDTO.getCategoriaId());
		}
		
		
		//salva update no banco
		novaVaga = repository.save(novaVaga);
		//retorna um model vagas com valor atualizado
		}
		return 	novaVaga;
		
	}

//	@Query("SELECT categoria FROM vagas WHERE categoria LIKE '%1%'")
//@Query("select vagas.titulo from vagas where vagas.categoriaId = :categoriaId")
	/*
	 * FILTRAR VAGA CATEGORIA
	 * 
	 * @Param filtro por categoria mocada no banco de dados, categorias com id de 1
	 * ao 5. 1 - todos | 2 - Áudio e Som | 3 - Iluminação | 4 - Palco | 5 -
	 * Equipamentos
	 * 
	 * @Param Parâmetro = Integer , usado para verificar se a categoria existe por
	 * id
	 * 
	 * @return isPresent: filtragem por id da categoria, listando todas as vagas de
	 * acordo.
	 * 
	 * @return não isPresent: lista vazia.
	 */
	@Transactional
	public List<Vagas> findCategoria(Integer categoriaId) throws Exception {
		Optional<Categoria> vagas = cRepository.findById(categoriaId);
		// List<Vagas> obj = repository.findAll();

		if (vagas.isPresent()) {
			return // repository.findByCategoriaIdContaining(v1.get());
			repository.findByCategoriasUp(categoriaId);

		}
		return new ArrayList<>();
	}

	/*
	 * @Param LISTA VAGAA POR TITULO
	 * 
	 * @Param parâmetro: String
	 * 
	 * @return lista de vagas com titulos buscados
	 */
	@Transactional
	public List<Vagas> findByTitulo(String titulo) throws Exception {
		List<Vagas> vagas = repository.findByTitulo(titulo);
		return vagas;
		
	}

	/*
	 * DELETAR VAGA
	 * 
	 * @Param para deletar a vaga, nesse método é necessário desassociar as relações
	 * da classe filha com a classe mãe, esse método deleta uma vaga.
	 */
	@Transactional
	public void delete(Integer id) throws Exception {
		Optional<Vagas> vagas = repository.findById(id);

		if (vagas.isPresent()) {

			/*
			 * removemento relações setando nulos os campos associados a Vagas
			 */
			vagas.get().deleteCategoria();
			vagas.get().deleteCandidaturas();
			vagas.get().deleteEmpresa();
			vagas.get().deleteFeedEmpresa();

			/*
			 * removendo a vaga da lista nas classes pai
			 */
			vagas.get().getFeedEmpresaId().deleteVagas();
			vagas.get().getCategoriaId().deleteVagas();
			/*
			 * deletando
			 */
			repository.deleteById(id);
		} else {
			/*
			 * execeção caso não encontrada
			 */
			throw new Exception("Vaga não encontrada");
		}

	}

}
