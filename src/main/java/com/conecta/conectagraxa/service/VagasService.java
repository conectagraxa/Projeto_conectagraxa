package com.conecta.conectagraxa.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conecta.conectagraxa.model.Empresa;
import com.conecta.conectagraxa.model.Feed_Empresa;
import com.conecta.conectagraxa.model.Postagens;
import com.conecta.conectagraxa.model.Vagas;
import com.conecta.conectagraxa.model.dto.VagasDTO;
import com.conecta.conectagraxa.repositories.VagasRepository;

@Service
public class VagasService {

	
	@Autowired
	VagasRepository repository;
	
	@Autowired
	EmpresaService empService;
	
	
	@Autowired
	Feed_EmpresaService feedService;
	
	//CRIAR VAGA
	public Vagas createVaga(VagasDTO obj) throws Exception {
//procurando se o id da vaga e empresa existe	
		Feed_Empresa feedEmpresa = feedService.findById(obj.getFeedEmpresaId());
		Empresa empresa = empService.findById(obj.getId());			
		Vagas vagas = new Vagas(obj);

//setando os dados passados no vagasDTO (Oque vai vai no corpo da requisição)
		vagas.setCategoria(obj.getCategoria());;
		vagas.setTitulo(obj.getTitulo());
		vagas.setFotoPath(obj.getFotoPath());
		vagas.setDescricao(obj.getDescricao());
		vagas.setCidade(obj.getCidade());
		vagas.setEstado(obj.getEstado());
		vagas.setDataPostagem(vagas.getDataPostagem());
//seta feed e empresa
		vagas.setFeedEmpresaId(feedEmpresa);
		vagas.setEmpresaId(empresa);
//adiciona a vaga setada no feed da empresa
		feedEmpresa.getVagas().add(vagas);
//salva no banco
		vagas = repository.save(vagas);
//retorna um model vagas com valor atualizado
		return vagas;
	
	}


	// EDITAR VAGA

	// FILTRAR VAGA CATEGORIA

	// LISTAR TODAS AS VAGAS POR NOME

	// DELETAR VAGA

}
